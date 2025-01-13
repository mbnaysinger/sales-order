package br.org.order.infrastructure.jpa.entity;

public class OrderProcedureReturnEntity {

        private String numTitulo;
        private String idIntegracao;
        private String mensagem;
        private Integer retorno;

    public String getNumTitulo() {
        return numTitulo;
    }

    public void setNumTitulo(String numTitulo) {
        this.numTitulo = numTitulo;
    }

    public String getIdIntegracao() {
        return idIntegracao;
    }

    public void setIdIntegracao(String idIntegracao) {
        this.idIntegracao = idIntegracao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Integer getRetorno() {
        return retorno;
    }

    public void setRetorno(Integer retorno) {
        this.retorno = retorno;
    }
}
