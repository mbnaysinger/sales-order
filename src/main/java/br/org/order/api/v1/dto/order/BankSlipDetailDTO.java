package br.org.order.api.v1.dto.order;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BankSlipDetailDTO {

    @NotNull(message = "O valor da parcela é obrigatório")
    @DecimalMin(value = "0.01", message = "O valor da parcela deve ser maior que zero")
    private BigDecimal parcela;

    @NotNull(message = "A data de vencimento é obrigatória")
    private LocalDate dtVcto;

    @NotBlank(message = "O número da parcela é obrigatório")
    private String numParc;

    public BigDecimal getParcela() {
        return parcela;
    }

    public void setParcela(BigDecimal parcela) {
        this.parcela = parcela;
    }

    public LocalDate getDtVcto() {
        return dtVcto;
    }

    public void setDtVcto(LocalDate dtVcto) {
        this.dtVcto = dtVcto;
    }

    public String getNumParc() { return numParc; }

    public void setNumParc(String numParc) { this.numParc = numParc; }

    @Override
    public String toString() {
        return "BankSlipDetailDTO{" +
                "parcela=" + parcela +
                ", dtVcto=" + dtVcto +
                ", numParc=" + numParc +
                '}';
    }
}
