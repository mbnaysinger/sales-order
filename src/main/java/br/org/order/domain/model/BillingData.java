package br.org.order.domain.model;

import java.util.List;

public class BillingData {

    private String correlationId;
    private String branchNumber;            //filial
    private String saleOrderType;           //c5tipo
    private String taxpayerId;
    private String paymentCondition;
    private String automaticInvoicing;
    private String series;
    private String sourceSystem;
    private String operationNumber;         //idcOperacao
    private String financialNature;         //idcNatureza
    private Integer finSecuritiesType;      //tipoTitulo
    private Instructions instructions;
    private List<BankSlipDetail> financialSecurities;
    private List<BankSlipItem> items;
    private String callbackUrl;

    private BillingData(Builder builder) {
        this.correlationId = builder.correlationId;
        this.branchNumber = builder.branchNumber;
        this.saleOrderType = builder.saleOrderType;
        this.taxpayerId = builder.taxpayerId;
        this.paymentCondition = builder.paymentCondition;
        this.automaticInvoicing = builder.automaticInvoicing;
        this.series = builder.series;
        this.sourceSystem = builder.sourceSystem;
        this.operationNumber = builder.operationNumber;
        this.financialNature = builder.financialNature;
        this.finSecuritiesType = builder.finSecuritiesType;
        this.instructions = builder.instructions;
        this.financialSecurities = builder.financialSecurities;
        this.items = builder.items;
        this.callbackUrl = builder.callbackUrl;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String correlationId;
        private String branchNumber;
        private String saleOrderType;
        private String taxpayerId;
        private String paymentCondition;
        private String automaticInvoicing;
        private String series;
        private String sourceSystem;
        private String operationNumber;
        private String financialNature;
        private Integer finSecuritiesType;
        private Instructions instructions;
        private List<BankSlipDetail> financialSecurities;
        private List<BankSlipItem> items;
        private String callbackUrl;

        public Builder correlationId(String correlationId) {
            this.correlationId = correlationId;
            return this;
        }

        public Builder branchNumber(String branchNumber) {
            this.branchNumber = branchNumber;
            return this;
        }

        public Builder saleOrderType(String saleOrderType) {
            this.saleOrderType = saleOrderType;
            return this;
        }

        public Builder taxpayerId(String taxpayerId) {
            this.taxpayerId = taxpayerId;
            return this;
        }

        public Builder paymentCondition(String paymentCondition) {
            this.paymentCondition = paymentCondition;
            return this;
        }

        public Builder automaticInvoicing(String automaticInvoicing) {
            this.automaticInvoicing = automaticInvoicing;
            return this;
        }

        public Builder series(String series) {
            this.series = series;
            return this;
        }

        public Builder sourceSystem(String sourceSystem) {
            this.sourceSystem = sourceSystem;
            return this;
        }

        public Builder operationNumber(String operationNumber) {
            this.operationNumber = operationNumber;
            return this;
        }

        public Builder financialNature(String financialNature) {
            this.financialNature = financialNature;
            return this;
        }

        public Builder finSecuritiesType(Integer finSecuritiesType) {
            this.finSecuritiesType = finSecuritiesType;
            return this;
        }

        public Builder instructions(Instructions instructions) {
            this.instructions = instructions;
            return this;
        }

        public Builder financialSecurities(List<BankSlipDetail> financialSecurities) {
            this.financialSecurities = financialSecurities;
            return this;
        }

        public Builder items(List<BankSlipItem> items) {
            this.items = items;
            return this;
        }

        public Builder callbackUrl(String callbackUrl) {
            this.callbackUrl = callbackUrl;
            return this;
        }

        public BillingData build() {
            return new BillingData(this);
        }
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public String getBranchNumber() {
        return branchNumber;
    }

    public String getSaleOrderType() {
        return saleOrderType;
    }

    public String getTaxpayerId() {
        return taxpayerId;
    }

    public String getPaymentCondition() {
        return paymentCondition;
    }

    public String getAutomaticInvoicing() {
        return automaticInvoicing;
    }

    public String getSeries() {
        return series;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public String getOperationNumber() {
        return operationNumber;
    }

    public String getFinancialNature() {
        return financialNature;
    }

    public Integer getFinSecuritiesType() {
        return finSecuritiesType;
    }

    public Instructions getInstructions() {
        return instructions;
    }

    public List<BankSlipDetail> getFinancialSecurities() {
        return financialSecurities;
    }

    public List<BankSlipItem> getItems() {
        return items;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }
}
