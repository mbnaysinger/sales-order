package br.org.order.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BankSlipDetail {

    private BigDecimal parcela;
    private LocalDate dtVcto;

    private BankSlipDetail(Builder builder) {
        this.parcela = builder.parcela;
        this.dtVcto = builder.dtVcto;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private BigDecimal parcela;
        private LocalDate dtVcto;

        public Builder parcela(BigDecimal parcela) {
            this.parcela = parcela;
            return this;
        }

        public Builder dtVcto(LocalDate dtVcto) {
            this.dtVcto = dtVcto;
            return this;
        }

        public BankSlipDetail build() {
            return new BankSlipDetail(this);
        }
    }

    public BigDecimal getParcela() {
        return parcela;
    }

    public LocalDate getDtVcto() {
        return dtVcto;
    }
}
