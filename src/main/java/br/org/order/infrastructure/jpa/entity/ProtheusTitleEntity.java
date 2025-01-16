package br.org.order.infrastructure.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "PROTHEUS_TITULOS")
public class ProtheusTitleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TOKEN_INTEGRACAO")
    private String token;

    @Column(name = "CNPJ")
    private String assignorTaxpayerId;

    @Column(name = "CPF")
    private String payerTaxpayerId;

    @Column(name = "CODIGO")
    private String code;

    @Column(name = "NUM_PARCELA")
    private Integer installments;

    @Column(name = "DT_EMISSAO")
    private String documentDate;

    @Column(name = "DT_VENCIMENTO")
    private String dueDate;

    @Column(name = "VLR_ORIGINAL")
    private Double valueTitle;

    @Column(name = "COD_UO_ERP")
    private String organizationUnitCode;

    @Column(name = "COD_CR_ERP")
    private String responsibilityCenterCode;

    @Column(name = "COD_NN")
    private String ourNumber;

    @Column(name = "DT_EXPIRA")
    private String expirationDate;

    @Column(name = "TXT_CNTRL_APL")
    private String sourceSystem;

    @Column(name = "ID_CORRELACAO")
    private String correlationId;

    @Column(name = "TP_PESSOA")
    private String payerRegistrationType;

    @Column(name = "GEN_PESSOA")
    private String payerGender;

    @Column(name = "NOME_PAGADOR")
    private String payerName;

    @Column(name = "COD_MUN_PAGADOR")
    private String payerCityCode;

    @Column(name = "END_PAGADOR")
    private String payerAddress;

    @Column(name = "CMPLE_END_PAGADOR")
    private String addressLine2;

    @Column(name = "UF_PAGADOR")
    private String payerState;

    @Column(name = "NOME_MUN_PAGADOR")
    private String payerCityName;

    @Column(name = "BAIRRO_PAGADOR")
    private String payerDistrict;

    @Column(name = "CEP_PAGADOR")
    private String payerZipCode;

    @Column(name = "DDD_PAGADOR")
    private String payerPhoneNumberDDD;

    @Column(name = "TEL_PAGADOR")
    private String payerPhoneNumber;

    @Column(name = "EMAIL_PAGADOR")
    private String payerEmail;

    @Column(name = "AUTMOTBX")
    private String settlementCode;

    @Column(name = "AUTCODADM")
    private String brandCode;

    @Column(name = "AUTCARTAU")
    private String authorizationCode;

    @Column(name = "AUTDOCUMEN")
    private String transactionDescription;

    @Column(name = "FLG_ATU_MONGO")
    private String isSettlementIntegrated;

    @Column(name = "DAT_ATU_MONGO")
    private LocalDate settlementIntegrationDate;

    @Column(name = "DAT_ATU_ORACLE")
    private LocalDate settlementUpdateDate;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "PIX_TRANSACTION_ID")
    private String pixTransactionId;

    @Column(name = "TXT_QR_CODE")
    private String pixQrCodeText;

    @Column(name = "HIST_BXA")
    private String observation;

    @Column(name = "ID_INTEGRACAO")
    private String idIntegracao;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAssignorTaxpayerId() {
        return this.assignorTaxpayerId;
    }

    public void setAssignorTaxpayerId(String assignorTaxpayerId) {
        this.assignorTaxpayerId = assignorTaxpayerId;
    }

    public String getPayerTaxpayerId() {
        return this.payerTaxpayerId;
    }

    public void setPayerTaxpayerId(String payerTaxpayerId) {
        this.payerTaxpayerId = payerTaxpayerId;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getInstallments() {
        return this.installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    public String getDocumentDate() {
        return this.documentDate;
    }

    public void setDocumentDate(String documentDate) {
        this.documentDate = documentDate;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Double getValueTitle() {
        return this.valueTitle;
    }

    public void setValueTitle(Double valueTitle) {
        this.valueTitle = valueTitle;
    }

    public String getOrganizationUnitCode() {
        return this.organizationUnitCode;
    }

    public void setOrganizationUnitCode(String organizationUnitCode) {
        this.organizationUnitCode = organizationUnitCode;
    }

    public String getResponsibilityCenterCode() {
        return this.responsibilityCenterCode;
    }

    public void setResponsibilityCenterCode(String responsibilityCenterCode) {
        this.responsibilityCenterCode = responsibilityCenterCode;
    }

    public String getOurNumber() {
        return this.ourNumber;
    }

    public void setOurNumber(String ourNumber) {
        this.ourNumber = ourNumber;
    }

    public String getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getSourceSystem() {
        return this.sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getPayerRegistrationType() {
        return this.payerRegistrationType;
    }

    public void setPayerRegistrationType(String payerRegistrationType) {
        this.payerRegistrationType = payerRegistrationType;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getPayerName() {
        return this.payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getPayerCityCode() {
        return this.payerCityCode;
    }

    public void setPayerCityCode(String payerCityCode) {
        this.payerCityCode = payerCityCode;
    }

    public String getPayerAddress() {
        return this.payerAddress;
    }

    public void setPayerAddress(String payerAddress) {
        this.payerAddress = payerAddress;
    }

    public String getPayerState() {
        return this.payerState;
    }

    public void setPayerState(String payerState) {
        this.payerState = payerState;
    }

    public String getPayerCityName() {
        return this.payerCityName;
    }

    public void setPayerCityName(String payerCityName) {
        this.payerCityName = payerCityName;
    }

    public String getPayerDistrict() {
        return this.payerDistrict;
    }

    public void setPayerDistrict(String payerDistrict) {
        this.payerDistrict = payerDistrict;
    }

    public String getPayerZipCode() {
        return this.payerZipCode;
    }

    public void setPayerZipCode(String payerZipCode) {
        this.payerZipCode = payerZipCode;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getPayerPhoneNumberDDD() {
        return this.payerPhoneNumberDDD;
    }

    public void setPayerPhoneNumberDDD(String payerPhoneNumberDDD) {
        this.payerPhoneNumberDDD = payerPhoneNumberDDD;
    }

    public String getPayerPhoneNumber() {
        return this.payerPhoneNumber;
    }

    public void setPayerPhoneNumber(String payerPhoneNumber) {
        this.payerPhoneNumber = payerPhoneNumber;
    }

    public String getPayerEmail() {
        return this.payerEmail;
    }

    public void setPayerEmail(String payerEmail) {
        this.payerEmail = payerEmail;
    }

    public String getPayerGender() {
        return payerGender;
    }

    public void setPayerGender(String payerGender) {
        this.payerGender = payerGender;
    }

    public String getSettlementCode() {
        return this.settlementCode;
    }

    public void setSettlementCode(String settlementCode) {
        this.settlementCode = settlementCode;
    }

    public String getBrandCode() {
        return this.brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getAuthorizationCode() {
        return this.authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getTransactionDescription() {
        return this.transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public String getIsSettlementIntegrated() {
        return isSettlementIntegrated;
    }

    public void setIsSettlementIntegrated(String isSettlementIntegrated) {
        this.isSettlementIntegrated = isSettlementIntegrated;
    }

    public LocalDate getSettlementUpdateDate() {
        return settlementUpdateDate;
    }

    public void setSettlementUpdateDate(LocalDate settlementUpdateDate) {
        this.settlementUpdateDate = settlementUpdateDate;
    }

    public LocalDate getSettlementIntegrationDate() {
        return settlementIntegrationDate;
    }

    public void setSettlementIntegrationDate(LocalDate settlementIntegrationDate) {
        this.settlementIntegrationDate = settlementIntegrationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPixTransactionId() {
        return pixTransactionId;
    }

    public void setPixTransactionId(String pixTransactionId) {
        this.pixTransactionId = pixTransactionId;
    }

    public String getPixQrCodeText() {
        return pixQrCodeText;
    }

    public void setPixQrCodeText(String pixQrCodeText) {
        this.pixQrCodeText = pixQrCodeText;
    }

    public String getIdIntegracao() {
        return idIntegracao;
    }

    public void setIdIntegracao(String idIntegracao) {
        this.idIntegracao = idIntegracao;
    }

    @Override
    public String toString() {
        return "ProtheusTitleEntity{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", assignorTaxpayerId='" + assignorTaxpayerId + '\'' +
                ", payerTaxpayerId='" + payerTaxpayerId + '\'' +
                ", code='" + code + '\'' +
                ", installments=" + installments +
                ", documentDate='" + documentDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", valueTitle=" + valueTitle +
                ", organizationUnitCode='" + organizationUnitCode + '\'' +
                ", responsibilityCenterCode='" + responsibilityCenterCode + '\'' +
                ", ourNumber='" + ourNumber + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", sourceSystem='" + sourceSystem + '\'' +
                ", correlationId='" + correlationId + '\'' +
                ", payerRegistrationType='" + payerRegistrationType + '\'' +
                ", payerGender='" + payerGender + '\'' +
                ", payerName='" + payerName + '\'' +
                ", payerCityCode='" + payerCityCode + '\'' +
                ", payerAddress='" + payerAddress + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", payerState='" + payerState + '\'' +
                ", payerCityName='" + payerCityName + '\'' +
                ", payerDistrict='" + payerDistrict + '\'' +
                ", payerZipCode='" + payerZipCode + '\'' +
                ", payerPhoneNumberDDD='" + payerPhoneNumberDDD + '\'' +
                ", payerPhoneNumber='" + payerPhoneNumber + '\'' +
                ", payerEmail='" + payerEmail + '\'' +
                ", settlementCode='" + settlementCode + '\'' +
                ", brandCode='" + brandCode + '\'' +
                ", authorizationCode='" + authorizationCode + '\'' +
                ", transactionDescription='" + transactionDescription + '\'' +
                ", isSettlementIntegrated='" + isSettlementIntegrated + '\'' +
                ", settlementIntegrationDate=" + settlementIntegrationDate +
                ", settlementUpdateDate=" + settlementUpdateDate +
                ", status='" + status + '\'' +
                ", pixTransactionId='" + pixTransactionId + '\'' +
                ", pixQrCodeText='" + pixQrCodeText + '\'' +
                ", observation='" + observation + '\'' +
                ", idIntegracao='" + idIntegracao + '\'' +
                '}';
    }

}
