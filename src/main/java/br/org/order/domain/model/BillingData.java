package br.org.order.domain.model;

import java.util.List;

public class BillingData {
    private final String filial;
    private final String c5Tipo;
    private final Integer id1Empresa;
    private final Integer id2Empresa;
    private final Integer id3Empresa;
    private final String condPgto;
    private final String fatAut;
    private final String serie;
    private final String sigla;
    private final String idcOperacao;
    private final String idcNatureza;
    private final Integer tipoTitulo;
    private final List<BankSlipDetail> titulos;
    private final List<BankSlipItem> itens;

    private BillingData(Builder builder) {
        this.filial = builder.filial;
        this.c5Tipo = builder.c5Tipo;
        this.id1Empresa = builder.id1Empresa;
        this.id2Empresa = builder.id2Empresa;
        this.id3Empresa = builder.id3Empresa;
        this.condPgto = builder.condPgto;
        this.fatAut = builder.fatAut;
        this.serie = builder.serie;
        this.sigla = builder.sigla;
        this.idcOperacao = builder.idcOperacao;
        this.idcNatureza = builder.idcNatureza;
        this.tipoTitulo = builder.tipoTitulo;
        this.titulos = builder.titulos;
        this.itens = builder.itens;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String filial;
        private String c5Tipo;
        private Integer id1Empresa;
        private Integer id2Empresa;
        private Integer id3Empresa;
        private String condPgto;
        private String fatAut;
        private String serie;
        private String sigla;
        private String idcOperacao;
        private String idcNatureza;
        private Integer tipoTitulo;
        private List<BankSlipDetail> titulos;
        private List<BankSlipItem> itens;

        public Builder filial(String filial) {
            this.filial = filial;
            return this;
        }

        public Builder c5Tipo(String c5Tipo) {
            this.c5Tipo = c5Tipo;
            return this;
        }

        public Builder id1Empresa(Integer id1Empresa) {
            this.id1Empresa = id1Empresa;
            return this;
        }

        public Builder id2Empresa(Integer id2Empresa) {
            this.id2Empresa = id2Empresa;
            return this;
        }

        public Builder id3Empresa(Integer id3Empresa) {
            this.id3Empresa = id3Empresa;
            return this;
        }

        public Builder condPgto(String condPgto) {
            this.condPgto = condPgto;
            return this;
        }

        public Builder fatAut(String fatAut) {
            this.fatAut = fatAut;
            return this;
        }

        public Builder serie(String serie) {
            this.serie = serie;
            return this;
        }

        public Builder sigla(String sigla) {
            this.sigla = sigla;
            return this;
        }

        public Builder idcOperacao(String idcOperacao) {
            this.idcOperacao = idcOperacao;
            return this;
        }

        public Builder idcNatureza(String idcNatureza) {
            this.idcNatureza = idcNatureza;
            return this;
        }

        public Builder tipoTitulo(Integer tipoTitulo) {
            this.tipoTitulo = tipoTitulo;
            return this;
        }

        public Builder titulos(List<BankSlipDetail> titulos) {
            this.titulos = titulos;
            return this;
        }

        public Builder itens(List<BankSlipItem> itens) {
            this.itens = itens;
            return this;
        }

        public BillingData build() {
            return new BillingData(this);
        }
    }

    public String getFilial() {
        return filial;
    }

    public String getC5Tipo() {
        return c5Tipo;
    }

    public Integer getId1Empresa() {
        return id1Empresa;
    }

    public Integer getId2Empresa() {
        return id2Empresa;
    }

    public Integer getId3Empresa() {
        return id3Empresa;
    }

    public String getCondPgto() {
        return condPgto;
    }

    public String getFatAut() {
        return fatAut;
    }

    public String getSerie() {
        return serie;
    }

    public String getSigla() {
        return sigla;
    }

    public String getIdcOperacao() {
        return idcOperacao;
    }

    public String getIdcNatureza() {
        return idcNatureza;
    }

    public Integer getTipoTitulo() {
        return tipoTitulo;
    }

    public List<BankSlipDetail> getTitulos() {
        return titulos;
    }

    public List<BankSlipItem> getItens() {
        return itens;
    }
}
