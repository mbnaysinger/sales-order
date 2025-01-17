package br.org.order.api.v1.converter;

import br.org.order.api.v1.dto.order.BankSlipDetailDTO;
import br.org.order.domain.model.BankSlipDetail;

public class BankSlipDetailConverter {

    public BankSlipDetail convertToEntity(BankSlipDetailDTO detailDTO) {
        return new BankSlipDetail.Builder()
                .parcela(detailDTO.getParcela())
                .dtVcto(detailDTO.getDtVcto())
                .numParc(detailDTO.getNumParc())
                .build();
    }
}
