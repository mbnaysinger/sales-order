package br.org.order.api.v1.dto.order;

import java.util.List;

public class BillingDataDTO {

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
    private List<BankSlipDetailDTO> titulos;
    private List<BankSlipItemDTO> itens;

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public String getC5Tipo() {
        return c5Tipo;
    }

    public void setC5Tipo(String c5Tipo) {
        this.c5Tipo = c5Tipo;
    }

    public Integer getId1Empresa() {
        return id1Empresa;
    }

    public void setId1Empresa(Integer id1Empresa) {
        this.id1Empresa = id1Empresa;
    }

    public Integer getId2Empresa() {
        return id2Empresa;
    }

    public void setId2Empresa(Integer id2Empresa) {
        this.id2Empresa = id2Empresa;
    }

    public Integer getId3Empresa() {
        return id3Empresa;
    }

    public void setId3Empresa(Integer id3Empresa) {
        this.id3Empresa = id3Empresa;
    }

    public String getCondPgto() {
        return condPgto;
    }

    public void setCondPgto(String condPgto) {
        this.condPgto = condPgto;
    }

    public String getFatAut() {
        return fatAut;
    }

    public void setFatAut(String fatAut) {
        this.fatAut = fatAut;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getIdcOperacao() {
        return idcOperacao;
    }

    public void setIdcOperacao(String idcOperacao) {
        this.idcOperacao = idcOperacao;
    }

    public String getIdcNatureza() {
        return idcNatureza;
    }

    public void setIdcNatureza(String idcNatureza) {
        this.idcNatureza = idcNatureza;
    }

    public Integer getTipoTitulo() {
        return tipoTitulo;
    }

    public void setTipoTitulo(Integer tipoTitulo) {
        this.tipoTitulo = tipoTitulo;
    }

    public List<BankSlipDetailDTO> getTitulos() {
        return titulos;
    }

    public void setTitulos(List<BankSlipDetailDTO> titulos) {
        this.titulos = titulos;
    }

    public List<BankSlipItemDTO> getItens() {
        return itens;
    }

    public void setItens(List<BankSlipItemDTO> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "BillingDataDTO{" +
                "filial='" + filial + '\'' +
                ", c5Tipo='" + c5Tipo + '\'' +
                ", id1Empresa=" + id1Empresa +
                ", id2Empresa=" + id2Empresa +
                ", id3Empresa=" + id3Empresa +
                ", condPgto='" + condPgto + '\'' +
                ", fatAut='" + fatAut + '\'' +
                ", serie='" + serie + '\'' +
                ", sigla='" + sigla + '\'' +
                ", idcOperacao='" + idcOperacao + '\'' +
                ", idcNatureza='" + idcNatureza + '\'' +
                ", tipoTitulo=" + tipoTitulo +
                ", titulos=" + titulos +
                ", itens=" + itens +
                '}';
    }
}
