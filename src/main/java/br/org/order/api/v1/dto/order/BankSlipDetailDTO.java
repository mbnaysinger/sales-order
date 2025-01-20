package br.org.order.api.v1.dto.order;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BankSlipDetailDTO {

    @NotNull(message = "O valor da parcela é obrigatório")
    @DecimalMin(value = "0.01", message = "O valor da parcela deve ser maior que zero")
    private BigDecimal installment;

    @NotNull(message = "A data de vencimento é obrigatória")
    private LocalDate dueDate;

    @NotBlank(message = "O número da parcela é obrigatório")
    private String installmentNumber;

    public BigDecimal getInstallment() {
        return installment;
    }

    public void setInstallment(BigDecimal installment) {
        this.installment = installment;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(String installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    @Override
    public String toString() {
        return "BankSlipDetailDTO{" +
                "installment=" + installment +
                ", dueDate=" + dueDate +
                ", installmentNumber='" + installmentNumber + '\'' +
                '}';
    }
}
