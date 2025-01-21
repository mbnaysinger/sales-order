package br.org.order.api.v1.dto.order;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class BillingDataDTO {

    @NotBlank(message = "billingdata.correlationId.required")
    private String correlationId;

    @NotBlank(message = "billingdata.branchNumber.required")
    private String branchNumber;

    @NotBlank(message = "billingdata.saleOrderType.required")
    private String saleOrderType;

    @NotNull(message = "billingdata.taxpayerId.required")
    private String taxpayerId;

    @NotBlank(message = "billingdata.paymentCondition.required")
    private String paymentCondition;

    @NotBlank(message = "billingdata.automaticInvoicing.required")
    private String automaticInvoicing;

    @NotBlank(message = "billingdata.series.required")
    private String series;

    @NotBlank(message = "billingdata.sourceSystem.required")
    private String sourceSystem;

    @NotBlank(message = "billingdata.operationNumber.required")
    private String operationNumber;

    @NotBlank(message = "billingdata.financialNature.required")
    private String financialNature;

    @NotNull(message = "billingdata.finSecuritiesType.required")
    private Integer finSecuritiesType;

    private InstructionsDTO instructions;

    @NotEmpty(message = "billingdata.financialSecurities.required")
    @Valid
    private List<BankSlipDetailDTO> financialSecurities;

    @NotEmpty(message = "billingdata.items.required")
    @Valid
    private List<BankSlipItemDTO> items;

    private String callbackUrl;

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId (String correlationId) {
        this.correlationId = correlationId;
    }

    public String getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(String branchNumber) {
        this.branchNumber = branchNumber;
    }

    public String getSaleOrderType() {
        return saleOrderType;
    }

    public void setSaleOrderType(String saleOrderType) {
        this.saleOrderType = saleOrderType;
    }

    public String getTaxpayerId() {
        return taxpayerId;
    }

    public void setTaxpayerId(String taxpayerId) {
        this.taxpayerId = taxpayerId;
    }

    public String getPaymentCondition() {
        return paymentCondition;
    }

    public void setPaymentCondition(String paymentCondition) {
        this.paymentCondition = paymentCondition;
    }

    public String getAutomaticInvoicing() {
        return automaticInvoicing;
    }

    public void setAutomaticInvoicing(String automaticInvoicing) {
        this.automaticInvoicing = automaticInvoicing;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getOperationNumber() {
        return operationNumber;
    }

    public void setOperationNumber(String operationNumber) {
        this.operationNumber = operationNumber;
    }

    public String getFinancialNature() {
        return financialNature;
    }

    public void setFinancialNature(String financialNature) {
        this.financialNature = financialNature;
    }

    public Integer getFinSecuritiesType() {
        return finSecuritiesType;
    }

    public void setFinSecuritiesType(Integer finSecuritiesType) {
        this.finSecuritiesType = finSecuritiesType;
    }

    public InstructionsDTO getInstructions() {
        return instructions;
    }

    public void setInstructions(InstructionsDTO instructions) {
        this.instructions = instructions;
    }

    public List<BankSlipDetailDTO> getFinancialSecurities() {
        return financialSecurities;
    }

    public void setFinancialSecurities(List<BankSlipDetailDTO> financialSecurities) {
        this.financialSecurities = financialSecurities;
    }

    public List<BankSlipItemDTO> getItems() {
        return items;
    }

    public void setItems(List<BankSlipItemDTO> items) {
        this.items = items;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    @Override
    public String toString() {
        return "BillingDataDTO{" +
                "correlationId='" + correlationId + '\'' +
                ", branchNumber='" + branchNumber + '\'' +
                ", saleOrderType='" + saleOrderType + '\'' +
                ", taxpayerId='" + taxpayerId + '\'' +
                ", paymentCondition='" + paymentCondition + '\'' +
                ", automaticInvoicing='" + automaticInvoicing + '\'' +
                ", series='" + series + '\'' +
                ", sourceSystem='" + sourceSystem + '\'' +
                ", operationNumbber='" + operationNumber + '\'' +
                ", financialNature='" + financialNature + '\'' +
                ", finSecuritiesType=" + finSecuritiesType +
                ", instructions=" + instructions +
                ", financialSecurities=" + financialSecurities +
                ", items=" + items +
                ", callbackUrl='" + callbackUrl + '\'' +
                '}';
    }
}
