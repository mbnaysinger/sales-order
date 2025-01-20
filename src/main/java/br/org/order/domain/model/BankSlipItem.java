package br.org.order.domain.model;

import java.math.BigDecimal;

public class BankSlipItem {
    private final Integer c6Item;
    private final Integer c6Num;
    private final Integer c6Produto;
    private final BigDecimal c6Qtdven;
    private final BigDecimal c6Prcven;
    private final BigDecimal c6Valor;
    private final BigDecimal c6Qtdlib;
    private final String c6Tes;
    private final String c6Xconta;
    private final String c6Xcc;
    private final String c6Xitemc;
    private final String c6Xclvl;

    private BankSlipItem(ItemBuilder builder) {
        this.c6Item = builder.c6Item;
        this.c6Num = builder.c6Num;
        this.c6Produto = builder.c6Produto;
        this.c6Qtdven = builder.c6Qtdven;
        this.c6Prcven = builder.c6Prcven;
        this.c6Valor = builder.c6Valor;
        this.c6Qtdlib = builder.c6Qtdlib;
        this.c6Tes = builder.c6Tes;
        this.c6Xconta = builder.c6Xconta;
        this.c6Xcc = builder.c6Xcc;
        this.c6Xitemc = builder.c6Xitemc;
        this.c6Xclvl = builder.c6Xclvl;
    }

    public static ItemBuilder builder() {
        return new ItemBuilder();
    }

    public static class ItemBuilder {
        private Integer c6Item;
        private Integer c6Num;
        private Integer c6Produto;
        private BigDecimal c6Qtdven;
        private BigDecimal c6Prcven;
        private BigDecimal c6Valor;
        private BigDecimal c6Qtdlib;
        private String c6Tes;
        private String c6Xconta;
        private String c6Xcc;
        private String c6Xitemc;
        private String c6Xclvl;

        public ItemBuilder c6Item(Integer c6Item) {
            this.c6Item = c6Item;
            return this;
        }

        public ItemBuilder c6Num(Integer c6Num) {
            this.c6Num = c6Num;
            return this;
        }

        public ItemBuilder c6Produto(Integer c6Produto) {
            this.c6Produto = c6Produto;
            return this;
        }

        public ItemBuilder c6Qtdven(BigDecimal c6Qtdven) {
            this.c6Qtdven = c6Qtdven;
            return this;
        }

        public ItemBuilder c6Prcven(BigDecimal c6Prcven) {
            this.c6Prcven = c6Prcven;
            return this;
        }

        public ItemBuilder c6Valor(BigDecimal c6Valor) {
            this.c6Valor = c6Valor;
            return this;
        }

        public ItemBuilder c6Qtdlib(BigDecimal c6Qtdlib) {
            this.c6Qtdlib = c6Qtdlib;
            return this;
        }

        public ItemBuilder c6Tes(String c6Tes) {
            this.c6Tes = c6Tes;
            return this;
        }

        public ItemBuilder c6Xconta(String c6Xconta) {
            this.c6Xconta = c6Xconta;
            return this;
        }

        public ItemBuilder c6Xcc(String c6Xcc) {
            this.c6Xcc = c6Xcc;
            return this;
        }

        public ItemBuilder c6Xitemc(String c6Xitemc) {
            this.c6Xitemc = c6Xitemc;
            return this;
        }

        public ItemBuilder c6Xclvl(String c6Xclvl) {
            this.c6Xclvl = c6Xclvl;
            return this;
        }

        public BankSlipItem build() {
            return new BankSlipItem(this);
        }
    }

    public Integer getC6Item() {
        return c6Item;
    }

    public Integer getC6Num() {
        return c6Num;
    }

    public Integer getC6Produto() {
        return c6Produto;
    }

    public BigDecimal getC6Qtdven() {
        return c6Qtdven;
    }

    public BigDecimal getC6Prcven() {
        return c6Prcven;
    }

    public BigDecimal getC6Valor() {
        return c6Valor;
    }

    public BigDecimal getC6Qtdlib() {
        return c6Qtdlib;
    }

    public String getC6Tes() {
        return c6Tes;
    }

    public String getC6Xconta() {
        return c6Xconta;
    }

    public String getC6Xcc() {
        return c6Xcc;
    }

    public String getC6Xitemc() {
        return c6Xitemc;
    }

    public String getC6Xclvl() {
        return c6Xclvl;
    }
}
