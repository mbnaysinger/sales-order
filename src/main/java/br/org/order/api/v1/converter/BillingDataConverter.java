package br.org.order.api.v1.converter;

import br.org.order.api.v1.dto.order.BillingDataDTO;
import br.org.order.domain.model.BankSlipDetail;
import br.org.order.domain.model.BankSlipItem;
import br.org.order.domain.model.BillingData;
import br.org.order.utils.TaxpayerFormatter;

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
        TaxpayerFormatter.FormattedTaxpayer ftp = TaxpayerFormatter.format(billingDataDTO.getTaxpayerId());

        List<BankSlipDetail> titulos = billingDataDTO.getFinancialSecurities().stream()
                .map(bankSlipDetailConverter::convertToEntity)
                .collect(Collectors.toList());

        List<BankSlipItem> itens = billingDataDTO.getItems().stream()
                .map(bankSlipItemConverter::convertToEntity)
                .collect(Collectors.toList());

        return new BillingData.Builder()
                .filial(billingDataDTO.getBranchNumber())
                .c5Tipo(billingDataDTO.getSaleOrderType())
                .id1Pessoa(ftp.getId1())
                .id2Pessoa(ftp.getId2())
                .id3Pessoa(ftp.getId3())
                .condPgto(billingDataDTO.getPaymentCondition())
                .fatAut(billingDataDTO.getAutomaticInvoicing())
                .serie(billingDataDTO.getSeries())
                .sigla(billingDataDTO.getSourceSystem())
                .idcOperacao(billingDataDTO.getOperationNumber())
                .idcNatureza(billingDataDTO.getFinancialNature())
                .tipoTitulo(billingDataDTO.getFinSecuritiesType())
                .titulos(titulos)
                .itens(itens)
                .build();
    }
}
