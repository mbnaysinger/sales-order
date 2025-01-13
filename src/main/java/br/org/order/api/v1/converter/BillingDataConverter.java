package br.org.order.api.v1.converter;

import br.org.order.api.v1.dto.order.BillingDataDTO;
import br.org.order.domain.model.BankSlipDetail;
import br.org.order.domain.model.BankSlipItem;
import br.org.order.domain.model.BillingData;

import java.util.List;
import java.util.stream.Collectors;

public class BillingDataConverter {

    private final BankSlipDetailConverter bankSlipDetailConverter;
    private final BankSlipItemConverter bankSlipItemConverter;

    public BillingDataConverter() {
        this.bankSlipDetailConverter = new BankSlipDetailConverter();
        this.bankSlipItemConverter = new BankSlipItemConverter();
    }

    public BillingData convertToEntity(BillingDataDTO billingDataDTO) {
        List<BankSlipDetail> titulos = billingDataDTO.getTitulos().stream()
                .map(bankSlipDetailConverter::convertToEntity)
                .collect(Collectors.toList());

        List<BankSlipItem> itens = billingDataDTO.getItens().stream()
                .map(bankSlipItemConverter::convertToEntity)
                .collect(Collectors.toList());

        return new BillingData.Builder()
                .filial(billingDataDTO.getFilial())
                .c5Tipo(billingDataDTO.getC5Tipo())
                .id1Empresa(billingDataDTO.getId1Empresa())
                .id2Empresa(billingDataDTO.getId2Empresa())
                .id3Empresa(billingDataDTO.getId3Empresa())
                .condPgto(billingDataDTO.getCondPgto())
                .fatAut(billingDataDTO.getFatAut())
                .serie(billingDataDTO.getSerie())
                .sigla(billingDataDTO.getSigla())
                .idcOperacao(billingDataDTO.getIdcOperacao())
                .idcNatureza(billingDataDTO.getIdcNatureza())
                .tipoTitulo(billingDataDTO.getTipoTitulo())
                .titulos(titulos)
                .itens(itens)
                .build();
    }
}
