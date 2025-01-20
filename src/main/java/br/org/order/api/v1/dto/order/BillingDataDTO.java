package br.org.order.api.v1.dto.order;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class BillingDataDTO {

    @NotBlank(message = "correlationId não pode ser vazio")
    private String correlationId;

    @NotBlank(message = "branchNumber (Filial) não pode ser vazio")
    private String branchNumber;

    @NotBlank(message = "saleOrderType (C5Tipo) não pode ser vazio")
    private String saleOrderType;

    @NotNull(message = "taxpayerId (Dados do Pagador) não pode ser nulo")
    private String taxpayerId;

    @NotBlank(message = "paymentCondition (Condição de Pagamento) não pode ser vazio")
    private String paymentCondition;

    @NotBlank(message = "automatedInvoicing (Faturamento Automático não pode ser vazio")
    private String automaticInvoicing;

    @NotBlank(message = "Série não pode ser vazio")
    private String series;

    @NotBlank(message = "sourceSystem (Sigla da aplicação de origem) não pode ser vazio")
    private String sourceSystem;

    @NotBlank(message = "operationNumber (Operação) não pode ser vazio")
    private String operationNumber;

    @NotBlank(message = "financialNature (IDC Natureza) não pode ser vazio")
    private String financialNature;

    @NotNull(message = "finSecuritiesType (Tipo de Título) não pode ser nulo")
    private Integer finSecuritiesType;

    private InstructionsDTO instructions;

    @NotEmpty(message = "Lista de Títulos não pode ser vazia")
    @Valid
    private List<BankSlipDetailDTO> financialSecurities;

    @NotEmpty(message = "Lista de Itens não pode ser vazia")
    @Valid
    private List<BankSlipItemDTO> items;

    private String paymentStatusCallbackUrl;
    private String availableInvoiceCallbackUrl;

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

    public String getPaymentStatusCallbackUrl() {
        return paymentStatusCallbackUrl;
    }

    public void setPaymentStatusCallbackUrl(String paymentStatusCallbackUrl) {
        this.paymentStatusCallbackUrl = paymentStatusCallbackUrl;
    }

    public String getAvailableInvoiceCallbackUrl() {
        return availableInvoiceCallbackUrl;
    }

    public void setAvailableInvoiceCallbackUrl(String availableInvoiceCallbackUrl) {
        this.availableInvoiceCallbackUrl = availableInvoiceCallbackUrl;
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
                ", paymentStatusCallbackUrl='" + paymentStatusCallbackUrl + '\'' +
                ", availableInvoiceCallbackUrl='" + availableInvoiceCallbackUrl + '\'' +
                '}';
    }
}
