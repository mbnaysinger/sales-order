package br.org.order.infrastructure.converter;

import br.org.order.domain.model.OrderProcedureReturn;
import br.org.order.infrastructure.jpa.entity.OrderProcedureReturnEntity;

public class OrderProcedureReturnConverter {

    public OrderProcedureReturn convert(OrderProcedureReturnEntity entity) {
        return OrderProcedureReturn.builder()
                .numTitulo(entity.getNumTitulo())
                .idIntegracao(entity.getIdIntegracao())
                .mensagem(entity.getMensagem())
                .retorno(entity.getRetorno())
                .build();
    }
}