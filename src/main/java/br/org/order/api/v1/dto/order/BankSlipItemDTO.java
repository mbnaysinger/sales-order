package br.org.order.api.v1.dto.order;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class BankSlipItemDTO {

    @NotNull(message = "bankslipitem.itemQty.required")
    private Integer itemQty;

    private Integer itemNumber;

    @NotNull(message = "bankslipitem.productNumber.required")
    private Integer productNumber;

    @NotNull(message = "bankslipitem.soldQty.required")
    private BigDecimal soldQty;

    @NotNull(message = "bankslipitem.saleValue.required")
    private BigDecimal saleValue;

    @NotNull(message = "bankslipitem.itemValue.required")
    private BigDecimal itemValue;

    @NotNull(message = "bankslipitem.releasedItemQty.required")
    private BigDecimal releasedItemQty;

    @NotBlank(message = "bankslipitem.iotNumber.required")
    private String iotNumber; // Input and output type (Protheus)

    @NotBlank(message = "bankslipitem.accountNumber.required")
    private String accountNumber;

    @NotBlank(message = "bankslipitem.xccNumber.required")
    private String xccNumber;

    @NotBlank(message = "bankslipitem.xicNumber.required")
    private String xicNumber;

    @NotBlank(message = "bankslipitem.xclvlNumber.required")
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
        return iotNumber;
    }

    public void setIotNumber(String iotNumber) {
        this.iotNumber = iotNumber;
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
                ", iotNumber='" + iotNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", xccNumber='" + xccNumber + '\'' +
                ", xicNumber='" + xicNumber + '\'' +
                ", xclvlNumber='" + xclvlNumber + '\'' +
                '}';
    }
}
