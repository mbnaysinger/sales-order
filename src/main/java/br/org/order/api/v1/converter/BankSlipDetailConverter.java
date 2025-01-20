package br.org.order.api.v1.converter;

import br.org.order.api.v1.dto.order.BankSlipDetailDTO;
import br.org.order.domain.model.BankSlipDetail;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BankSlipDetailConverter {

    public BankSlipDetail convertToEntity(BankSlipDetailDTO detailDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return new BankSlipDetail.Builder()
                .parcela(detailDTO.getInstallment())
                .dtVcto(dateSql(detailDTO.getDueDate()))
                .numParc(detailDTO.getInstallmentNumber())
                .build();
    }

    private String dateSql(LocalDate dueDate) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return dueDate.format(f);
    }
}
