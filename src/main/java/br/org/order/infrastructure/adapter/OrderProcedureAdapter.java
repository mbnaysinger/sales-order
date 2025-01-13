package br.org.order.infrastructure.adapter;

import br.org.order.domain.model.BankSlipDetail;
import br.org.order.domain.model.BankSlipItem;
import br.org.order.domain.model.BillingData;
import br.org.order.domain.model.OrderProcedureReturn;
import br.org.order.domain.port.OrderProcedurePort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.sql.*;
import java.util.Objects;

@Component
public class OrderProcedureAdapter implements OrderProcedurePort {

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
                    .numTitulo(stmt.getString(1))
                    .idIntegracao(stmt.getString(2))
                    .mensagem(stmt.getString(3))
                    .retorno(stmt.getInt(4))
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao executar procedure Oracle: " + e.getMessage(), e);
        }
    }

    private String buildSqlStatement(BillingData bd) {
        StringBuilder sql = new StringBuilder();
        sql.append("DECLARE ")
                .append("    v_retorno NUMBER; ")
                .append("    v_mensagem VARCHAR2(4000); ")
                .append("    v_num_titulo VARCHAR2(200); ")
                .append("    v_id_integra NUMBER; ")
                .append("    v_titulos dda_iif.iif_pedido_venda_pck.tb_tit := dda_iif.iif_pedido_venda_pck.tb_tit(); ")
                .append("    v_itens dda_iif.iif_pedido_venda_pck.tb_itens := dda_iif.iif_pedido_venda_pck.tb_itens(); ")
                .append("    v_sigla VARCHAR2(8) := '").append(bd.getSigla()).append("'; ")
                .append("BEGIN ");

        for (int i = 0; i < bd.getItens().size(); i++) {
            BankSlipItem item = bd.getItens().get(i);
            sql.append("    v_itens(").append(i+1).append(").c6_filial := '").append(item.getC6Filial()).append("'; ")
                    .append("    v_itens(").append(i+1).append(").c6_item := ").append(item.getC6Item()).append("; ")
                    .append("    v_itens(").append(i+1).append(").c6_num := ").append(item.getC6Num() == null ? "null" : "'" + item.getC6Num() + "'").append("; ")
                    .append("    v_itens(").append(i+1).append(").c6_produto := ").append(item.getC6Produto()).append("; ")
                    .append("    v_itens(").append(i+1).append(").c6_qtdven := ").append(item.getC6Qtdven()).append("; ")
                    .append("    v_itens(").append(i+1).append(").c6_prcven := ").append(item.getC6Prcven()).append("; ")
                    .append("    v_itens(").append(i+1).append(").c6_valor := ").append(item.getC6Valor()).append("; ")
                    .append("    v_itens(").append(i+1).append(").c6_qtdlib := ").append(item.getC6Qtdlib()).append("; ")
                    .append("    v_itens(").append(i+1).append(").c6_tes := '").append(item.getC6Tes()).append("'; ")
                    .append("    v_itens(").append(i+1).append(").c6_xconta := '").append(item.getC6Xconta()).append("'; ")
                    .append("    v_itens(").append(i+1).append(").c6_xcc := '").append(item.getC6Xcc()).append("'; ")
                    .append("    v_itens(").append(i+1).append(").c6_xitemc := '").append(item.getC6Xitemc()).append("'; ")
                    .append("    v_itens(").append(i+1).append(").c6_xclvl := '").append(item.getC6Xclvl()).append("'; ");
        }

        for (int i = 0; i < bd.getTitulos().size(); i++) {
            BankSlipDetail titulo = bd.getTitulos().get(i);
            sql.append("    v_titulos(").append(i+1).append(").parcela := ").append(titulo.getParcela()).append("; ")
                    .append("    v_titulos(").append(i+1).append(").dt_vcto := TO_DATE('").append(titulo.getDtVcto()).append("', 'YYYY-MM-DD'); ");
        }

        sql.append("    dda_apims.apims_titulos_cobranca_pck.insere_titulo( ")
                .append("        v_sigla, ")
                .append("        '").append(bd.getC5Tipo()).append("', ")
                .append("        ").append(bd.getId1Empresa()).append(", ")
                .append("        ").append(bd.getId2Empresa()).append(", ")
                .append("        ").append(bd.getId3Empresa()).append(", ")
                .append("        '").append(bd.getCondPgto()).append("', ")
                .append("        '").append(bd.getFatAut()).append("', ")
                .append("        '").append(bd.getSerie()).append("', ")
                .append("        '").append(bd.getSigla()).append("', ")
                .append("        '").append(bd.getIdcOperacao()).append("', ")
                .append("        '").append(bd.getIdcNatureza()).append("', ")
                .append("        ").append(bd.getTipoTitulo()).append(", ")
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

        return sql.toString();
    }
}
