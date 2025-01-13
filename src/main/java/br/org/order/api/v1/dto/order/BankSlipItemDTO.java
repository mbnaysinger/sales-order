package br.org.order.api.v1.dto.order;

import java.math.BigDecimal;

public class BankSlipItemDTO {

    private String c6Filial;
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

    public String getC6Filial() {
        return c6Filial;
    }

    public void setC6Filial(String c6Filial) {
        this.c6Filial = c6Filial;
    }

    public Integer getC6Item() {
        return c6Item;
    }

    public void setC6Item(Integer c6Item) {
        this.c6Item = c6Item;
    }

    public Integer getC6Num() {
        return c6Num;
    }

    public void setC6Num(Integer c6Num) {
        this.c6Num = c6Num;
    }

    public Integer getC6Produto() {
        return c6Produto;
    }

    public void setC6Produto(Integer c6Produto) {
        this.c6Produto = c6Produto;
    }

    public BigDecimal getC6Qtdven() {
        return c6Qtdven;
    }

    public void setC6Qtdven(BigDecimal c6Qtdven) {
        this.c6Qtdven = c6Qtdven;
    }

    public BigDecimal getC6Prcven() {
        return c6Prcven;
    }

    public void setC6Prcven(BigDecimal c6Prcven) {
        this.c6Prcven = c6Prcven;
    }

    public BigDecimal getC6Valor() {
        return c6Valor;
    }

    public void setC6Valor(BigDecimal c6Valor) {
        this.c6Valor = c6Valor;
    }

    public BigDecimal getC6Qtdlib() {
        return c6Qtdlib;
    }

    public void setC6Qtdlib(BigDecimal c6Qtdlib) {
        this.c6Qtdlib = c6Qtdlib;
    }

    public String getC6Tes() {
        return c6Tes;
    }

    public void setC6Tes(String c6Tes) {
        this.c6Tes = c6Tes;
    }

    public String getC6Xconta() {
        return c6Xconta;
    }

    public void setC6Xconta(String c6Xconta) {
        this.c6Xconta = c6Xconta;
    }

    public String getC6Xcc() {
        return c6Xcc;
    }

    public void setC6Xcc(String c6Xcc) {
        this.c6Xcc = c6Xcc;
    }

    public String getC6Xitemc() {
        return c6Xitemc;
    }

    public void setC6Xitemc(String c6Xitemc) {
        this.c6Xitemc = c6Xitemc;
    }

    public String getC6Xclvl() {
        return c6Xclvl;
    }

    public void setC6Xclvl(String c6Xclvl) {
        this.c6Xclvl = c6Xclvl;
    }

    @Override
    public String toString() {
        return "BankSlipItemDTO{" +
                "c6Filial='" + c6Filial + '\'' +
                ", c6Item=" + c6Item +
                ", c6Num=" + c6Num +
                ", c6Produto=" + c6Produto +
                ", c6Qtdven=" + c6Qtdven +
                ", c6Prcven=" + c6Prcven +
                ", c6Valor=" + c6Valor +
                ", c6Qtdlib=" + c6Qtdlib +
                ", c6Tes='" + c6Tes + '\'' +
                ", c6Xconta='" + c6Xconta + '\'' +
                ", c6Xcc='" + c6Xcc + '\'' +
                ", c6Xitemc='" + c6Xitemc + '\'' +
                ", c6Xclvl='" + c6Xclvl + '\'' +
                '}';
    }
}
