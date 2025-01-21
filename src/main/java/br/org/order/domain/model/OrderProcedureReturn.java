package br.org.order.domain.model;

public class OrderProcedureReturn {
    private String securitiesNumber;
    private String integrationId;
    private String prcMessage;
    private Integer prcReturn;

    private OrderProcedureReturn(Builder builder) {
        this.securitiesNumber = builder.securitiesNumber;
        this.integrationId = builder.integrationId;
        this.prcMessage = builder.prcMessage;
        this.prcReturn = builder.prcReturn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String securitiesNumber;
        private String integrationId;
        private String prcMessage;
        private Integer prcReturn;

        public Builder securitiesNumber(String securitiesNumber) {
            this.securitiesNumber = securitiesNumber;
            return this;
        }

        public Builder integrationId(String integrationId) {
            this.integrationId = integrationId;
            return this;
        }

        public Builder prcMessage(String prcMessage) {
            this.prcMessage = prcMessage;
            return this;
        }

        public Builder prcReturn(Integer prcReturn) {
            this.prcReturn = prcReturn;
            return this;
        }

        public OrderProcedureReturn build() {
            return new OrderProcedureReturn(this);
        }
    }

    public String getSecuritiesNumber() {
        return securitiesNumber;
    }

    public String getIntegrationId() {
        return integrationId;
    }

    public String getPrcMessage() {
        return prcMessage;
    }

    public Integer getPrcReturn() {
        return prcReturn;
    }
}
