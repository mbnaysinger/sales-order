package br.org.order.api.v1.converter;

import br.org.order.api.v1.dto.order.BankSlipItemDTO;
import br.org.order.domain.model.BankSlipItem;

public class BankSlipItemConverter {

    public BankSlipItem convertToEntity(BankSlipItemDTO itemDTO) {
        return new BankSlipItem.ItemBuilder()
                .c6Item(itemDTO.getItemQty())
                .c6Num(itemDTO.getItemNumber())
                .c6Produto(itemDTO.getProductNumber())
                .c6Qtdven(itemDTO.getSoldQty())
                .c6Prcven(itemDTO.getSaleValue())
                .c6Valor(itemDTO.getItemValue())
                .c6Qtdlib(itemDTO.getReleasedItemQty())
                .c6Tes(itemDTO.getIotNumber())
                .c6Xconta(itemDTO.getAccountNumber())
                .c6Xcc(itemDTO.getXccNumber())
                .c6Xitemc(itemDTO.getXicNumber())
                .c6Xclvl(itemDTO.getXclvlNumber())
                .build();
    }
}