package br.org.order.domain.model;

public class OrderProcedureReturn {
    private String numTitulo;
    private String idIntegracao;
    private String mensagem;
    private Integer retorno;

    private OrderProcedureReturn(Builder builder) {
        this.numTitulo = builder.numTitulo;
        this.idIntegracao = builder.idIntegracao;
        this.mensagem = builder.mensagem;
        this.retorno = builder.retorno;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String numTitulo;
        private String idIntegracao;
        private String mensagem;
        private Integer retorno;

        public Builder numTitulo(String numTitulo) {
            this.numTitulo = numTitulo;
            return this;
        }

        public Builder idIntegracao(String idIntegracao) {
            this.idIntegracao = idIntegracao;
            return this;
        }

        public Builder mensagem(String mensagem) {
            this.mensagem = mensagem;
            return this;
        }

        public Builder retorno(Integer retorno) {
            this.retorno = retorno;
            return this;
        }

        public OrderProcedureReturn build() {
            return new OrderProcedureReturn(this);
        }
    }

    public String getNumTitulo() {
        return numTitulo;
    }

    public String getIdIntegracao() {
        return idIntegracao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Integer getRetorno() {
        return retorno;
    }
}
