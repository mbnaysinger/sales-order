package br.org.order.api.v1.dto.order;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class BankSlipItemDTO {

    @NotNull(message = "itemQty (C6Item) não pode ser nulo")
    @Positive(message = "itemQty (C6Item) deve ser um número positivo")
    private Integer itemQty;

    private Integer itemNumber;

    @NotNull(message = "productNumber (C6Produto) não pode ser nulo")
    @Positive(message = "productNumber (C6Produto) deve ser um número positivo")
    private Integer productNumber;

    @NotNull(message = "soldQty (C6Qtdven) não pode ser nulo")
    @Positive(message = "soldQty (C6Qtdven) deve ser um número positivo")
    private BigDecimal soldQty;

    @NotNull(message = "saleValue (C6Prcven) não pode ser nulo")
    @Positive(message = "saleValue (C6Prcven) deve ser um número positivo")
    private BigDecimal saleValue;

    @NotNull(message = "itemValue (C6Valor) não pode ser nulo")
    @Positive(message = "itemValue (C6Valor) deve ser um número positivo")
    private BigDecimal itemValue;

    @NotNull(message = "releasedItemQty (C6Qtdlib) não pode ser nulo")
    @Positive(message = "releasedItemQty (C6Qtdlib) deve ser um número positivo")
    private BigDecimal releasedItemQty;

    @NotBlank(message = "IotNumber (C6Tes) não pode ser vazio")
    private String IotNumber; //Imput and output type (Protheus)

    @NotBlank(message = "accountNumber (C6Xconta) não pode ser vazio")
    private String accountNumber;

    @NotBlank(message = "xccNumber (C6Xcc) não pode ser vazio")
    private String xccNumber;

    @NotBlank(message = "xicNumber (C6Xitemc) não pode ser vazio")
    private String xicNumber;

    @NotBlank(message = "xclvlNumber (C6Xclvl) não pode ser vazio")
    private String xclvlNumber;

    public Integer getItemQty() {
        return itemQty;
    }

    public void setItemQty(Integer itemQty) {
        this.itemQty = itemQty;
    }

    public Integer getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(Integer itemNumber) {
        this.itemNumber = itemNumber;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    public BigDecimal getSoldQty() {
        return soldQty;
    }

    public void setSoldQty(BigDecimal soldQty) {
        this.soldQty = soldQty;
    }

    public BigDecimal getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(BigDecimal saleValue) {
        this.saleValue = saleValue;
    }

    public BigDecimal getItemValue() {
        return itemValue;
    }

    public void setItemValue(BigDecimal itemValue) {
        this.itemValue = itemValue;
    }

    public BigDecimal getReleasedItemQty() {
        return releasedItemQty;
    }

    public void setReleasedItemQty(BigDecimal releasedItemQty) {
        this.releasedItemQty = releasedItemQty;
    }

    public String getIotNumber() {
        return IotNumber;
    }

    public void setIotNumber(String iotNumber) {
        IotNumber = iotNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getXccNumber() {
        return xccNumber;
    }

    public void setXccNumber(String xccNumber) {
        this.xccNumber = xccNumber;
    }

    public String getXicNumber() {
        return xicNumber;
    }

    public void setXicNumber(String xicNumber) {
        this.xicNumber = xicNumber;
    }

    public String getXclvlNumber() {
        return xclvlNumber;
    }

    public void setXclvlNumber(String xclvlNumber) {
        this.xclvlNumber = xclvlNumber;
    }

    @Override
    public String toString() {
        return "BankSlipItemDTO{" +
                "itemQty=" + itemQty +
                ", itemNumber=" + itemNumber +
                ", productNumber=" + productNumber +
                ", soldQty=" + soldQty +
                ", saleValue=" + saleValue +
                ", itemValue=" + itemValue +
                ", releasedItemQty=" + releasedItemQty +
                ", IotNumber='" + IotNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", xccNumber='" + xccNumber + '\'' +
                ", xicNumber='" + xicNumber + '\'' +
                ", xclvlNumber='" + xclvlNumber + '\'' +
                '}';
    }
}
