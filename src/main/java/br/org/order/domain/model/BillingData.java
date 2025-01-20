package br.org.order.domain.model;

import java.util.List;

public class BillingData {
    private final String filial;
    private final String c5Tipo;
    private final Long id1Pessoa;
    private final int id2Pessoa;
    private final int id3Pessoa;
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
        this.id1Pessoa = builder.id1Pessoa;
        this.id2Pessoa = builder.id2Pessoa;
        this.id3Pessoa = builder.id3Pessoa;
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
        private Long id1Pessoa;
        private int id2Pessoa;
        private int id3Pessoa;
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

        public Builder id1Pessoa(Long id1Pessoa) {
            this.id1Pessoa = id1Pessoa;
            return this;
        }

        public Builder id2Pessoa(int id2Pessoa) {
            this.id2Pessoa = id2Pessoa;
            return this;
        }

        public Builder id3Pessoa(int id3Pessoa) {
            this.id3Pessoa = id3Pessoa;
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

    public Long getId1Pessoa() {
        return id1Pessoa;
    }

    public int getId2Pessoa() {
        return id2Pessoa;
    }

    public int getId3Pessoa() {
        return id3Pessoa;
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
