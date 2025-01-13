package br.org.order.api.v1.converter;

import br.org.order.api.v1.dto.order.BankSlipItemDTO;
import br.org.order.domain.model.BankSlipItem;

public class BankSlipItemConverter {

    public BankSlipItem convertToEntity(BankSlipItemDTO itemDTO) {
        return new BankSlipItem.ItemBuilder()
                .c6Filial(itemDTO.getC6Filial())
                .c6Item(itemDTO.getC6Item())
                .c6Num(itemDTO.getC6Num())
                .c6Produto(itemDTO.getC6Produto())
                .c6Qtdven(itemDTO.getC6Qtdven())
                .c6Prcven(itemDTO.getC6Prcven())
                .c6Valor(itemDTO.getC6Valor())
                .c6Qtdlib(itemDTO.getC6Qtdlib())
                .c6Tes(itemDTO.getC6Tes())
                .c6Xconta(itemDTO.getC6Xconta())
                .c6Xcc(itemDTO.getC6Xcc())
                .c6Xitemc(itemDTO.getC6Xitemc())
                .c6Xclvl(itemDTO.getC6Xclvl())
                .build();
    }
}