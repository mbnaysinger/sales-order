package br.org.order.api.v1.dto.order;

public class OrderProcedureReturnDTO {
    private String securitiesNumber;
    private String integrationId;
    private String prcMessage;
    private Integer prcReturn;


    public String getSecuritiesNumber() {
        return securitiesNumber;
    }

    public void setSecuritiesNumber(String securitiesNumber) {
        this.securitiesNumber = securitiesNumber;
    }

    public String getIntegrationId() {
        return integrationId;
    }

    public void setIntegrationId(String integrationId) {
        this.integrationId = integrationId;
    }

    public String getPrcMessage() {
        return prcMessage;
    }

    public void setPrcMessage(String prcMessage) {
        this.prcMessage = prcMessage;
    }

    public Integer getPrcReturn() {
        return prcReturn;
    }

    public void setPrcReturn(Integer prcReturn) {
        this.prcReturn = prcReturn;
    }

    @Override
    public String toString() {
        return "OrderProcedureReturnDTO{" +
                "securitiesNumber='" + securitiesNumber + '\'' +
                ", integrationId='" + integrationId + '\'' +
                ", prcMessage='" + prcMessage + '\'' +
                ", prcReturn=" + prcReturn +
                '}';
    }
}