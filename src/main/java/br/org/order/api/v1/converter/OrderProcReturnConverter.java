package br.org.order.api.v1.converter;

import br.org.order.api.v1.dto.order.OrderProcedureReturnDTO;
import br.org.order.domain.model.OrderProcedureReturn;
import org.springframework.stereotype.Component;

@Component
public class OrderProcReturnConverter {

    public OrderProcedureReturnDTO convertToDto(OrderProcedureReturn model) {
        var dto = new OrderProcedureReturnDTO();
        dto.setSecuritiesNumber(String.valueOf(model.getSecuritiesNumber()));
        dto.setIntegrationId(model.getIntegrationId());
        dto.setPrcMessage(model.getPrcMessage());
        dto.setPrcReturn(model.getPrcReturn());

        return dto;
    }

}
