package br.org.order.infrastructure.adapter;

import br.org.order.domain.model.BillingData;
import br.org.order.domain.model.OrderProcedureReturn;
import br.org.order.domain.port.OrderProcedurePort;
import br.org.order.infrastructure.jpa.entity.OrderProcedureReturnEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

@Component
public class OrderProcedureAdapter implements OrderProcedurePort {

    private final JdbcTemplate jdbcTemplate;

    public OrderProcedureAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Mono<OrderProcedureReturn> insereTitulo(BillingData bd) {
        return Mono.fromCallable(() -> {
            Connection connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement callableStatement = connection
                    .prepareCall("{CALL APIMS_TITULOS_COBRANCA_PCK.insere_titulo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");

            callableStatement.setString(1, bd.getFilial());
            callableStatement.setString(2, bd.getC5Tipo());
            callableStatement.setInt(3, bd.getId1Empresa());
            callableStatement.setInt(4, bd.getId2Empresa());
            callableStatement.setInt(5, bd.getId3Empresa());
            callableStatement.setString(6, bd.getCondPgto());
            callableStatement.setString(7, bd.getFatAut());
            callableStatement.setString(8, bd.getSerie());
            callableStatement.setString(9, bd.getSigla());
            callableStatement.setString(10, bd.getIdcOperacao());
            callableStatement.setString(11, bd.getIdcNatureza());
            callableStatement.setInt(12, bd.getTipoTitulo());

            Array detail = connection.createArrayOf("STRUCT", bd.getTitulos().toArray());
            Array item = connection.createArrayOf("STRUCT", bd.getItens().toArray());
            callableStatement.setArray(13, detail);
            callableStatement.setArray(14, item);

            callableStatement.registerOutParameter(15, Types.VARCHAR);  // p_num_titulo
            callableStatement.registerOutParameter(16, Types.INTEGER);  // p_id_integracao
            callableStatement.registerOutParameter(17, Types.VARCHAR);  // p_mensagem
            callableStatement.registerOutParameter(18, Types.INTEGER);  // p_retorno

            callableStatement.execute();

            OrderProcedureReturnEntity entity = new OrderProcedureReturnEntity();
            entity.setNumTitulo(callableStatement.getString(15));
            entity.setIdIntegracao(callableStatement.getString(16));
            entity.setMensagem(callableStatement.getString(17));
            entity.setRetorno(callableStatement.getInt(18));

            return convert(entity);
        });
    }

    private OrderProcedureReturn convert(OrderProcedureReturnEntity entity) {
        return OrderProcedureReturn.builder()
                .numTitulo(entity.getNumTitulo())
                .idIntegracao(entity.getIdIntegracao())
                .mensagem(entity.getMensagem())
                .retorno(entity.getRetorno())
                .build();
    }
}
