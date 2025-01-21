package br.org.order.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BankSlipDetail {

    private BigDecimal installment;     //parcelamento
    private LocalDate dueDate;          //dtVencimento
    private String installmentNumber;   //nroParcela

    private BankSlipDetail(Builder builder) {
        this.installment = builder.installment;
        this.dueDate = builder.dueDate;
        this.installmentNumber = builder.installmentNumber;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private BigDecimal installment;
        private LocalDate dueDate;
        private String installmentNumber;

        public Builder installment(BigDecimal installment) {
            this.installment = installment;
            return this;
        }

        public Builder dueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder installmentNumber(String installmentNumber) {
            this.installmentNumber = installmentNumber;
            return this;
        }

        public BankSlipDetail build() {
            return new BankSlipDetail(this);
        }
    }

    public BigDecimal getInstallment() {
        return installment;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getInstallmentNumber() { return installmentNumber; }
}
