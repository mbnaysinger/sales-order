package br.org.order.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BankSlipDetail {

    private BigDecimal parcela;
    private LocalDate dtVcto;
    private String numParc;

    private BankSlipDetail(Builder builder) {
        this.parcela = builder.parcela;
        this.dtVcto = builder.dtVcto;
        this.numParc = builder.numParc;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private BigDecimal parcela;
        private LocalDate dtVcto;
        private String numParc;

        public Builder parcela(BigDecimal parcela) {
            this.parcela = parcela;
            return this;
        }

        public Builder dtVcto(LocalDate dtVcto) {
            this.dtVcto = dtVcto;
            return this;
        }

        public Builder numParc(String numParc) {
            this.numParc = numParc;
            return this;
        }

        public BankSlipDetail build() {
            return new BankSlipDetail(this);
        }
    }

    public BigDecimal getParcela() {
        return parcela;
    }

    public String getDtVcto() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return dtVcto.format(formatter);
    }

    public String getNumParc() { return numParc; }
}
