package br.org.order.api.v1.converter;

import br.org.order.api.v1.dto.order.BankSlipItemDTO;
import br.org.order.domain.model.BankSlipItem;
import org.springframework.stereotype.Component;

@Component
public class BankSlipItemConverter {

    public BankSlipItem convertToEntity(BankSlipItemDTO itemDTO) {
        return new BankSlipItem.ItemBuilder()
                .itemQty(itemDTO.getItemQty())
                .itemNumber(itemDTO.getItemNumber())
                .productNumber(itemDTO.getProductNumber())
                .soldQty(itemDTO.getSoldQty())
                .saleValue(itemDTO.getSaleValue())
                .itemValue(itemDTO.getItemValue())
                .releasedItemQty(itemDTO.getReleasedItemQty())
                .iotNumber(itemDTO.getIotNumber())
                .accountNumber(itemDTO.getAccountNumber())
                .xccNumber(itemDTO.getXccNumber())
                .xicNumber(itemDTO.getXicNumber())
                .xclvlNumber(itemDTO.getXclvlNumber())
                .build();
    }
}