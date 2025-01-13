package br.org.order.api.v1.dto.order;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BankSlipDetailDTO {

    private BigDecimal parcela;
    private LocalDate dtVcto;

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

    @Override
    public String toString() {
        return "BankSlipDetailDTO{" +
                "parcela=" + parcela +
                ", dtVcto=" + dtVcto +
                '}';
    }
}
