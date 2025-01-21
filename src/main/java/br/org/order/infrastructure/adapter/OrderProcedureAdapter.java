package br.org.order.infrastructure.adapter;

import br.org.order.domain.model.BankSlipDetail;
import br.org.order.domain.model.BankSlipItem;
import br.org.order.domain.model.BillingData;
import br.org.order.domain.model.OrderProcedureReturn;
import br.org.order.domain.port.OrderProcedurePort;
import br.org.order.utils.TaxpayerFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Component
public class OrderProcedureAdapter implements OrderProcedurePort {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProcedureAdapter.class);
    private final JdbcTemplate jdbcTemplate;

    public OrderProcedureAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Mono<OrderProcedureReturn> insereTitulo(BillingData bd) {
        return Mono.fromCallable(() -> executeInsertTitulo(bd))
                .subscribeOn(Schedulers.boundedElastic());
    }

    private OrderProcedureReturn executeInsertTitulo(BillingData bd) throws SQLException {
        String sql = buildSqlStatement(bd);

        try (Connection connection = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
             CallableStatement stmt = connection.prepareCall(sql)) {

            stmt.registerOutParameter(1, Types.VARCHAR);  // num_titulo
            stmt.registerOutParameter(2, Types.NUMERIC);  // id_integra
            stmt.registerOutParameter(3, Types.VARCHAR);  // mensagem
            stmt.registerOutParameter(4, Types.NUMERIC);  // retorno
            stmt.registerOutParameter(5, Types.VARCHAR);  // possiveis_falhas

            stmt.execute();

            String errorMessage = stmt.getString(5);
            if (errorMessage != null && !errorMessage.isEmpty()) {
                throw new RuntimeException("Erro na execução da procedure: " + errorMessage);
            }

            return OrderProcedureReturn.builder()
                    .securitiesNumber(stmt.getString(1))
                    .integrationId(stmt.getString(2))
                    .prcMessage(stmt.getString(3))
                    .prcReturn(stmt.getInt(4))
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao executar procedure Oracle: " + e.getMessage(), e);
        }
    }

    private String buildSqlStatement(BillingData bd) {
        TaxpayerFormatter.FormattedTaxpayer ftp = TaxpayerFormatter.format(bd.getTaxpayerId());
        StringBuilder sql = new StringBuilder();
        sql.append("DECLARE ")
                .append("    v_retorno NUMBER; ")
                .append("    v_mensagem VARCHAR2(4000); ")
                .append("    v_num_titulo VARCHAR2(200); ")
                .append("    v_id_integra NUMBER; ")
                .append("    v_titulos dda_iif.iif_pedido_venda_pck.tb_tit := dda_iif.iif_pedido_venda_pck.tb_tit(); ")
                .append("    v_itens dda_iif.iif_pedido_venda_pck.tb_itens := dda_iif.iif_pedido_venda_pck.tb_itens(); ")
                .append("    v_sigla VARCHAR2(8) := '").append(bd.getBranchNumber()).append("'; ")
                .append("BEGIN ");

        for (int i = 0; i < bd.getItems().size(); i++) {
            BankSlipItem item = bd.getItems().get(i);
            sql.append("    v_itens(").append(i+1).append(").c6_filial := '").append(bd.getBranchNumber()).append("'; ")
                    .append("    v_itens(").append(i+1).append(").c6_item := ").append(item.getItemQty()).append("; ")
                    .append("    v_itens(").append(i+1).append(").c6_num := ").append(item.getItemNumber() == null ? "null" : "'" + item.getItemNumber() + "'").append("; ")
                    .append("    v_itens(").append(i+1).append(").c6_produto := ").append(item.getProductNumber()).append("; ")
                    .append("    v_itens(").append(i+1).append(").c6_qtdven := ").append(item.getSoldQty()).append("; ")
                    .append("    v_itens(").append(i+1).append(").c6_prcven := ").append(item.getSaleValue()).append("; ")
                    .append("    v_itens(").append(i+1).append(").c6_valor := ").append(item.getItemValue()).append("; ")
                    .append("    v_itens(").append(i+1).append(").c6_qtdlib := ").append(item.getReleasedItemQty()).append("; ")
                    .append("    v_itens(").append(i+1).append(").c6_tes := '").append(item.getIotNumber()).append("'; ")
                    .append("    v_itens(").append(i+1).append(").c6_xconta := '").append(item.getAccountNumber()).append("'; ")
                    .append("    v_itens(").append(i+1).append(").c6_xcc := '").append(item.getXccNumber()).append("'; ")
                    .append("    v_itens(").append(i+1).append(").c6_xitemc := '").append(item.getXicNumber()).append("'; ")
                    .append("    v_itens(").append(i+1).append(").c6_xclvl := '").append(item.getXclvlNumber()).append("'; ");
        }

        for (int i = 0; i < bd.getFinancialSecurities().size(); i++) {
            BankSlipDetail titulo = bd.getFinancialSecurities().get(i);
            sql.append("    v_titulos(").append(i+1).append(").parcela := ").append(titulo.getInstallment()).append("; ")
                    .append("    v_titulos(").append(i+1).append(").dt_vcto := TO_DATE('").append(dateSql(titulo.getDueDate())).append("', 'DD-MM-YYYY'); ")
                    .append("    v_titulos(").append(i+1).append(").parc_num := ").append(titulo.getInstallmentNumber()).append("; ");

        }

        sql.append("    dda_apims.apims_titulos_cobranca_pck.insere_titulo( ")
                .append("        v_sigla, ")
                .append("        '").append(bd.getSaleOrderType()).append("', ")
                .append("        ").append(ftp.getId1()).append(", ")
                .append("        ").append(ftp.getId2()).append(", ")
                .append("        ").append(ftp.getId3()).append(", ")
                .append("        '").append(bd.getPaymentCondition()).append("', ")
                .append("        '").append(bd.getAutomaticInvoicing()).append("', ")
                .append("        '").append(bd.getSeries()).append("', ")
                .append("        '").append(bd.getSourceSystem()).append("', ")
                .append("        '").append(bd.getOperationNumber()).append("', ")
                .append("        '").append(bd.getFinancialNature()).append("', ")
                .append("        ").append(bd.getFinSecuritiesType()).append(", ")
                .append("        v_titulos, v_itens, v_num_titulo, v_id_integra, v_mensagem, v_retorno ")
                .append("    ); ")
                .append("    ? := v_num_titulo; ")
                .append("    ? := v_id_integra; ")
                .append("    ? := v_mensagem; ")
                .append("    ? := v_retorno; ")
                .append("EXCEPTION ")
                .append("    WHEN OTHERS THEN ")
                .append("        ? := SQLERRM || ' - ' || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE; ")
                .append("        RAISE; ")
                .append("END;");

        LOGGER.debug("---------- Enriched Procedure Body: {}", sql.toString());
        return sql.toString();
    }

    private String dateSql(LocalDate dt) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return dt.format(f);
    }
}
