package br.org.order.api.v1.converter;

import br.org.order.api.v1.dto.order.BankSlipDetailDTO;
import br.org.order.domain.model.BankSlipDetail;
import org.springframework.stereotype.Component;

@Component
public class BankSlipDetailConverter {

    public BankSlipDetail convertToEntity(BankSlipDetailDTO detailDTO) {
        return new BankSlipDetail.Builder()
                .installment(detailDTO.getInstallment())
                .dueDate(detailDTO.getDueDate())
                .installmentNumber(detailDTO.getInstallmentNumber())
                .build();
    }
}
