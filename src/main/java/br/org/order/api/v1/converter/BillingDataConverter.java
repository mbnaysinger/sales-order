package br.org.order.api.v1.converter;

import br.org.order.api.v1.dto.order.BillingDataDTO;
import br.org.order.api.v1.dto.order.InstructionsDTO;
import br.org.order.domain.model.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BillingDataConverter {

    private final BankSlipDetailConverter bankSlipDetailConverter;
    private final BankSlipItemConverter bankSlipItemConverter;
    private final PersonConverter personConverter;

    public BillingDataConverter(BankSlipDetailConverter bankSlipDetailConverter,
                                BankSlipItemConverter bankSlipItemConverter,
                                PersonConverter personConverter) {

        this.bankSlipDetailConverter = bankSlipDetailConverter;
        this.bankSlipItemConverter = bankSlipItemConverter;
        this.personConverter = personConverter;
    }

    public BillingData convertToModel(BillingDataDTO billingDataDTO) {

        List<BankSlipDetail> BankSlipDetails = billingDataDTO.getFinancialSecurities().stream()
                .map(bankSlipDetailConverter::convertToEntity)
                .collect(Collectors.toList());

        List<BankSlipItem> BankSlipItems = billingDataDTO.getItems().stream()
                .map(bankSlipItemConverter::convertToEntity)
                .collect(Collectors.toList());

        Person p = personConverter.convert(billingDataDTO.getPayer());

        return new BillingData.Builder()
                .branchNumber(billingDataDTO.getBranchNumber())
                .saleOrderType(billingDataDTO.getSaleOrderType())
                .taxpayerId(p.getTaxpayerIdAsString())
                .paymentCondition(billingDataDTO.getPaymentCondition())
                .automaticInvoicing(billingDataDTO.getAutomaticInvoicing())
                .series(billingDataDTO.getSeries())
                .sourceSystem(billingDataDTO.getSourceSystem())
                .operationNumber(billingDataDTO.getOperationNumber())
                .financialNature(billingDataDTO.getFinancialNature())
                .finSecuritiesType(billingDataDTO.getFinSecuritiesType())
                .financialSecurities(BankSlipDetails)
                .callbackUrl(billingDataDTO.getCallbackUrl())
                .correlationId(billingDataDTO.getCorrelationId())
                .instructions(convert(billingDataDTO.getInstructions()))
                .items(BankSlipItems)
                .build();
    }

    public Instructions convert(InstructionsDTO dto) {
        return null == dto
                ? null
                : Instructions.builder()
                .withInstruction1(dto.getInstruction1())
                .withInstruction2(dto.getInstruction2())
                .withInstruction3(dto.getInstruction3())
                .withInstruction4(dto.getInstruction4())
                .withInstruction5(dto.getInstruction5())
                .withInstruction6(dto.getInstruction6())
                .withInstruction7(dto.getInstruction7())
                .withInstruction8(dto.getInstruction8())
                .build();
    }
}
