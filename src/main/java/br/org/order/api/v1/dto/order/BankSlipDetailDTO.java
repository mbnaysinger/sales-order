package br.org.order.api.v1.dto.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BankSlipDetailDTO {

    @NotNull(message = "bankslipdetail.installment.required")
    @DecimalMin(value = "3.00", message = "bankslipdetail.installment.minimum")
    private BigDecimal installment;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "bankslipdetail.dueDate.required")
    private LocalDate dueDate;

    @NotBlank(message = "bankslipdetail.installmentNumber.required")
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
