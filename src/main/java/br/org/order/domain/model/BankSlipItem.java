package br.org.order.domain.model;

import java.math.BigDecimal;

public class BankSlipItem {

    private Integer itemQty;                //c6Item
    private Integer itemNumber;             //c6Num
    private Integer productNumber;          //c6Produto
    private BigDecimal soldQty;             //c6Qtdven
    private BigDecimal saleValue;           //c6Prcven
    private BigDecimal itemValue;           //c6Valor
    private BigDecimal releasedItemQty;     //c6Qtdlib
    private String iotNumber;               //Input and output type (Protheus TES)
    private String accountNumber;           //c6Xconta
    private String xccNumber;               //c6Xcc
    private String xicNumber;               //c6Xitemc
    private String xclvlNumber;             //c6Xclvl

    private BankSlipItem(ItemBuilder builder) {
        this.itemQty = builder.itemQty;
        this.itemNumber = builder.itemNumber;
        this.productNumber = builder.productNumber;
        this.soldQty = builder.soldQty;
        this.saleValue = builder.saleValue;
        this.itemValue = builder.itemValue;
        this.releasedItemQty = builder.releasedItemQty;
        this.iotNumber = builder.iotNumber;
        this.accountNumber = builder.accountNumber;
        this.xccNumber = builder.xccNumber;
        this.xicNumber = builder.xicNumber;
        this.xclvlNumber = builder.xclvlNumber;
    }

    public static ItemBuilder builder() {
        return new ItemBuilder();
    }

    public static class ItemBuilder {
        private Integer itemQty;
        private Integer itemNumber;
        private Integer productNumber;
        private BigDecimal soldQty;
        private BigDecimal saleValue;
        private BigDecimal itemValue;
        private BigDecimal releasedItemQty;
        private String iotNumber;
        private String accountNumber;
        private String xccNumber;
        private String xicNumber;
        private String xclvlNumber;

        public ItemBuilder itemQty(Integer itemQty) {
            this.itemQty = itemQty;
            return this;
        }

        public ItemBuilder itemNumber(Integer itemNumber) {
            this.itemNumber = itemNumber;
            return this;
        }

        public ItemBuilder productNumber(Integer productNumber) {
            this.productNumber = productNumber;
            return this;
        }

        public ItemBuilder soldQty(BigDecimal soldQty) {
            this.soldQty = soldQty;
            return this;
        }

        public ItemBuilder saleValue(BigDecimal saleValue) {
            this.saleValue = saleValue;
            return this;
        }

        public ItemBuilder itemValue(BigDecimal itemValue) {
            this.itemValue = itemValue;
            return this;
        }

        public ItemBuilder releasedItemQty(BigDecimal releasedItemQty) {
            this.releasedItemQty = releasedItemQty;
            return this;
        }

        public ItemBuilder iotNumber(String iotNumber) {
            this.iotNumber = iotNumber;
            return this;
        }

        public ItemBuilder accountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public ItemBuilder xccNumber(String xccNumber) {
            this.xccNumber = xccNumber;
            return this;
        }

        public ItemBuilder xicNumber(String xicNumber) {
            this.xicNumber = xicNumber;
            return this;
        }

        public ItemBuilder xclvlNumber(String xclvlNumber) {
            this.xclvlNumber = xclvlNumber;
            return this;
        }

        public BankSlipItem build() {
            return new BankSlipItem(this);
        }
    }

    public Integer getItemQty() {
        return itemQty;
    }

    public Integer getItemNumber() {
        return itemNumber;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public BigDecimal getSoldQty() {
        return soldQty;
    }

    public BigDecimal getSaleValue() {
        return saleValue;
    }

    public BigDecimal getItemValue() {
        return itemValue;
    }

    public BigDecimal getReleasedItemQty() {
        return releasedItemQty;
    }

    public String getIotNumber() {
        return iotNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getXccNumber() {
        return xccNumber;
    }

    public String getXicNumber() {
        return xicNumber;
    }

    public String getXclvlNumber() {
        return xclvlNumber;
    }
}
