package br.org.order.infrastructure.jpa.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "APIMS_IIF_MENSAGEM")
public class IIFMensagemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "RETORNO")
    private String retorno;

    @Column(name = "SENTIDO")
    private String sentido;

    @Column(name = "MOTIVO_CANC")
    private String motivoCanc;

    @Column(name = "JUSTIFICATIVA")
    private String justificativa;

    @Column(name = "ID_DEPENDENCIA")
    private String idDependencia;

    @Column(name = "ID_XIDESB")
    private String idXidesb;

    @Column(name = "TIPO")
    private String tipo;

    @Column(name = "ID_LEGADO")
    private String idLegado;

    @Column(name = "IDC_OPERACAO")
    private String idcOperacao;

    @Column(name = "NOME_ARQUIVO")
    private String nomeArquivo;

    @Column(name = "BANCO_DE_DADOS")
    private String bancoDeDados;

    @Column(name = "APL_SIGLA")
    private String aplSigla;

    @Column(name = "DATA_INCLUSAO")
    private LocalDate dataInclusao;

    @Column(name = "USUARIO_INCLUSAO")
    private String usuarioInclusao;

    @Column(name = "DATA_ALTERACAO")
    private LocalDate dataAlteracao;

    @Column(name = "USUARIO_ALTERACAO")
    private String usuarioAlteracao;

    @Column(name = "VERSION")
    private String version;

    @Column(name = "DOCBRANCH")
    private String docBranch;

    @Column(name = "DOCIDENTIFIER")
    private String docIdentifier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    public String getSentido() {
        return sentido;
    }

    public void setSentido(String sentido) {
        this.sentido = sentido;
    }

    public String getMotivoCanc() {
        return motivoCanc;
    }

    public void setMotivoCanc(String motivoCanc) {
        this.motivoCanc = motivoCanc;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getIdDependencia() {
        return idDependencia;
    }

    public void setIdDependencia(String idDependencia) {
        this.idDependencia = idDependencia;
    }

    public String getIdXidesb() {
        return idXidesb;
    }

    public void setIdXidesb(String idXidesb) {
        this.idXidesb = idXidesb;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIdLegado() {
        return idLegado;
    }

    public void setIdLegado(String idLegado) {
        this.idLegado = idLegado;
    }

    public String getIdcOperacao() {
        return idcOperacao;
    }

    public void setIdcOperacao(String idcOperacao) {
        this.idcOperacao = idcOperacao;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getBancoDeDados() {
        return bancoDeDados;
    }

    public void setBancoDeDados(String bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }

    public String getAplSigla() {
        return aplSigla;
    }

    public void setAplSigla(String aplSigla) {
        this.aplSigla = aplSigla;
    }

    public LocalDate getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(LocalDate dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public String getUsuarioInclusao() {
        return usuarioInclusao;
    }

    public void setUsuarioInclusao(String usuarioInclusao) {
        this.usuarioInclusao = usuarioInclusao;
    }

    public LocalDate getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDate dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public String getUsuarioAlteracao() {
        return usuarioAlteracao;
    }

    public void setUsuarioAlteracao(String usuarioAlteracao) {
        this.usuarioAlteracao = usuarioAlteracao;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDocBranch() {
        return docBranch;
    }

    public void setDocBranch(String docBranch) {
        this.docBranch = docBranch;
    }

    public String getDocIdentifier() {
        return docIdentifier;
    }

    public void setDocIdentifier(String docIdentifier) {
        this.docIdentifier = docIdentifier;
    }

    @Override
    public String toString() {
        return "IIFMensagemEntity{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", retorno='" + retorno + '\'' +
                ", sentido='" + sentido + '\'' +
                ", motivoCanc='" + motivoCanc + '\'' +
                ", justificativa='" + justificativa + '\'' +
                ", idDependencia='" + idDependencia + '\'' +
                ", idXidesb='" + idXidesb + '\'' +
                ", tipo='" + tipo + '\'' +
                ", idLegado='" + idLegado + '\'' +
                ", idcOperacao='" + idcOperacao + '\'' +
                ", nomeArquivo='" + nomeArquivo + '\'' +
                ", bancoDeDados='" + bancoDeDados + '\'' +
                ", aplSigla='" + aplSigla + '\'' +
                ", dataInclusao=" + dataInclusao +
                ", usuarioInclusao='" + usuarioInclusao + '\'' +
                ", dataAlteracao=" + dataAlteracao +
                ", usuarioAlteracao='" + usuarioAlteracao + '\'' +
                ", version='" + version + '\'' +
                ", docBranch='" + docBranch + '\'' +
                ", docIdentifier='" + docIdentifier + '\'' +
                '}';
    }

}
