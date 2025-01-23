package br.org.order.infrastructure.soap.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
@XmlType(propOrder = {"body"})
public class ClienteSoapResponseDTO {

    private Body body;

    @XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public static class Body {
        private ConsultarResponse consultarResponse;

        @XmlElement(name = "consultarResponse", namespace = "http://ws.iifcore.fiergs.org.br/")
        public ConsultarResponse getConsultarResponse() {
            return consultarResponse;
        }

        public void setConsultarResponse(ConsultarResponse consultarResponse) {
            this.consultarResponse = consultarResponse;
        }

        public static class ConsultarResponse {
            private Return aReturn;

            @XmlElement(name = "return", namespace = "http://ws.iifcore.fiergs.org.br/")
            public Return getReturn() {
                return aReturn;
            }

            public void setReturn(Return aReturn) {
                this.aReturn = aReturn;
            }

            public static class Return {
                // Campos principais
                private String cpfCnpj;
                private String formaDeTratamento;
                private String nome;
                private String tiposPessoasCodigo;
                private String situacao;
                private String nascimentoFundacao;
                private String fantasia;
                private String indicativoEstatal;
                private String empresaMatrix;
                private String empresaSucessora;
                private String inscricaoEstadual;
                private String inscricaoMunicipal;
                private String numeroRg;
                private String orgaoExpedidor;
                private String sexo;
                private String grauRisco;
                private String observacao;
                private String normaISO;
                private String certificacaoISO;
                private String dataCertificacao;
                private String homePage;
                private String estadoCivil;
                private String nomeConjuge;
                private String dataNascimentoConjuge;
                private String dataDesativacao;
                private String grauInstrucao;
                private String holdingCodigo;
                private String origemSAC;
                private String tituloEleitor;
                private String numeroPisPasep;
                private String numeroInss;
                private String numeroEmpregados;
                private String CBOId;
                private String historico;
                private String produtos;
                private String optantePeloSimples;
                private String publicarEmail;
                private String eMailSemana;
                private String observacaoRai;
                private String atualizaSistemaFace;
                private String empresaDiretora;
                private String publicarNroEmpregados;
                private String dataValidadeDocumentacao;
                private String nacionalidadeCodigo;
                private String associado;
                private String codigoAtividadeEconomicaEstadual;
                private String codigoNacionalAtividadeEconomica;
                private String pesId;

                private Endereco enderecoPrincipal;
                private Endereco enderecoCobranca;
                private Endereco enderecoEntrega;

                private String primeiroNome;
                private String nomeDoMeio;
                private String ultimoNome;

                @XmlElement(name = "cpfCnpj")
                public String getCpfCnpj() {
                    return cpfCnpj;
                }

                public void setCpfCnpj(String cpfCnpj) {
                    this.cpfCnpj = cpfCnpj;
                }

                @XmlElement(name = "nome")
                public String getNome() {
                    return nome;
                }

                public void setNome(String nome) {
                    this.nome = nome;
                }

                public String geteMailSemana() {
                    return eMailSemana;
                }

                public void seteMailSemana(String eMailSemana) {
                    this.eMailSemana = eMailSemana;
                }

                // Métodos repetidos conforme necessário para todos os campos
                @XmlElement(name = "formaDeTratamento")
                public String getFormaDeTratamento() {
                    return formaDeTratamento;
                }

                public void setFormaDeTratamento(String formaDeTratamento) {
                    this.formaDeTratamento = formaDeTratamento;
                }

                @XmlElement(name = "tiposPessoasCodigo")
                public String getTiposPessoasCodigo() {
                    return tiposPessoasCodigo;
                }

                public void setTiposPessoasCodigo(String tiposPessoasCodigo) {
                    this.tiposPessoasCodigo = tiposPessoasCodigo;
                }

                @XmlElement(name = "situacao")
                public String getSituacao() {
                    return situacao;
                }

                public void setSituacao(String situacao) {
                    this.situacao = situacao;
                }

                @XmlElement(name = "nascimentoFundacao")
                public String getNascimentoFundacao() {
                    return nascimentoFundacao;
                }

                public void setNascimentoFundacao(String nascimentoFundacao) {
                    this.nascimentoFundacao = nascimentoFundacao;
                }

                @XmlElement(name = "fantasia")
                public String getFantasia() {
                    return fantasia;
                }

                public void setFantasia(String fantasia) {
                    this.fantasia = fantasia;
                }

                @XmlElement(name = "indicativoEstatal")
                public String getIndicativoEstatal() {
                    return indicativoEstatal;
                }

                public void setIndicativoEstatal(String indicativoEstatal) {
                    this.indicativoEstatal = indicativoEstatal;
                }

                @XmlElement(name = "empresaMatrix")
                public String getEmpresaMatrix() {
                    return empresaMatrix;
                }

                public void setEmpresaMatrix(String empresaMatrix) {
                    this.empresaMatrix = empresaMatrix;
                }

                @XmlElement(name = "empresaSucessora")
                public String getEmpresaSucessora() {
                    return empresaSucessora;
                }

                public void setEmpresaSucessora(String empresaSucessora) {
                    this.empresaSucessora = empresaSucessora;
                }

                @XmlElement(name = "inscricaoEstadual")
                public String getInscricaoEstadual() {
                    return inscricaoEstadual;
                }

                public void setInscricaoEstadual(String inscricaoEstadual) {
                    this.inscricaoEstadual = inscricaoEstadual;
                }

                @XmlElement(name = "inscricaoMunicipal")
                public String getInscricaoMunicipal() {
                    return inscricaoMunicipal;
                }

                public void setInscricaoMunicipal(String inscricaoMunicipal) {
                    this.inscricaoMunicipal = inscricaoMunicipal;
                }

                @XmlElement(name = "numeroRg")
                public String getNumeroRg() {
                    return numeroRg;
                }

                public void setNumeroRg(String numeroRg) {
                    this.numeroRg = numeroRg;
                }

                @XmlElement(name = "orgaoExpedidor")
                public String getOrgaoExpedidor() {
                    return orgaoExpedidor;
                }

                public void setOrgaoExpedidor(String orgaoExpedidor) {
                    this.orgaoExpedidor = orgaoExpedidor;
                }

                @XmlElement(name = "sexo")
                public String getSexo() {
                    return sexo;
                }

                public void setSexo(String sexo) {
                    this.sexo = sexo;
                }

                @XmlElement(name = "grauRisco")
                public String getGrauRisco() {
                    return grauRisco;
                }

                public void setGrauRisco(String grauRisco) {
                    this.grauRisco = grauRisco;
                }

                @XmlElement(name = "observacao")
                public String getObservacao() {
                    return observacao;
                }

                public void setObservacao(String observacao) {
                    this.observacao = observacao;
                }

                @XmlElement(name = "normaISO")
                public String getNormaISO() {
                    return normaISO;
                }

                public void setNormaISO(String normaISO) {
                    this.normaISO = normaISO;
                }

                @XmlElement(name = "certificacaoISO")
                public String getCertificacaoISO() {
                    return certificacaoISO;
                }

                public void setCertificacaoISO(String certificacaoISO) {
                    this.certificacaoISO = certificacaoISO;
                }

                @XmlElement(name = "dataCertificacao")
                public String getDataCertificacao() {
                    return dataCertificacao;
                }

                public void setDataCertificacao(String dataCertificacao) {
                    this.dataCertificacao = dataCertificacao;
                }

                @XmlElement(name = "homePage")
                public String getHomePage() {
                    return homePage;
                }

                public void setHomePage(String homePage) {
                    this.homePage = homePage;
                }

                @XmlElement(name = "estadoCivil")
                public String getEstadoCivil() {
                    return estadoCivil;
                }

                public void setEstadoCivil(String estadoCivil) {
                    this.estadoCivil = estadoCivil;
                }

                @XmlElement(name = "nomeConjuge")
                public String getNomeConjuge() {
                    return nomeConjuge;
                }

                public void setNomeConjuge(String nomeConjuge) {
                    this.nomeConjuge = nomeConjuge;
                }

                @XmlElement(name = "dataNascimentoConjuge")
                public String getDataNascimentoConjuge() {
                    return dataNascimentoConjuge;
                }

                public void setDataNascimentoConjuge(String dataNascimentoConjuge) {
                    this.dataNascimentoConjuge = dataNascimentoConjuge;
                }

                @XmlElement(name = "dataDesativacao")
                public String getDataDesativacao() {
                    return dataDesativacao;
                }

                public void setDataDesativacao(String dataDesativacao) {
                    this.dataDesativacao = dataDesativacao;
                }

                @XmlElement(name = "grauInstrucao")
                public String getGrauInstrucao() {
                    return grauInstrucao;
                }

                public void setGrauInstrucao(String grauInstrucao) {
                    this.grauInstrucao = grauInstrucao;
                }

                @XmlElement(name = "holdingCodigo")
                public String getHoldingCodigo() {
                    return holdingCodigo;
                }

                public void setHoldingCodigo(String holdingCodigo) {
                    this.holdingCodigo = holdingCodigo;
                }

                @XmlElement(name = "origemSAC")
                public String getOrigemSAC() {
                    return origemSAC;
                }

                public void setOrigemSAC(String origemSAC) {
                    this.origemSAC = origemSAC;
                }

                @XmlElement(name = "tituloEleitor")
                public String getTituloEleitor() {
                    return tituloEleitor;
                }

                public void setTituloEleitor(String tituloEleitor) {
                    this.tituloEleitor = tituloEleitor;
                }

                @XmlElement(name = "numeroPisPasep")
                public String getNumeroPisPasep() {
                    return numeroPisPasep;
                }

                public void setNumeroPisPasep(String numeroPisPasep) {
                    this.numeroPisPasep = numeroPisPasep;
                }

                @XmlElement(name = "numeroInss")
                public String getNumeroInss() {
                    return numeroInss;
                }

                public void setNumeroInss(String numeroInss) {
                    this.numeroInss = numeroInss;
                }

                @XmlElement(name = "numeroEmpregados")
                public String getNumeroEmpregados() {
                    return numeroEmpregados;
                }

                public void setNumeroEmpregados(String numeroEmpregados) {
                    this.numeroEmpregados = numeroEmpregados;
                }

                @XmlElement(name = "CBOId")
                public String getCBOId() {
                    return CBOId;
                }

                public void setCBOId(String CBOId) {
                    this.CBOId = CBOId;
                }

                @XmlElement(name = "historico")
                public String getHistorico() {
                    return historico;
                }

                public void setHistorico(String historico) {
                    this.historico = historico;
                }

                @XmlElement(name = "produtos")
                public String getProdutos() {
                    return produtos;
                }

                public void setProdutos(String produtos) {
                    this.produtos = produtos;
                }

                @XmlElement(name = "optantePeloSimples")
                public String getOptantePeloSimples() {
                    return optantePeloSimples;
                }

                public void setOptantePeloSimples(String optantePeloSimples) {
                    this.optantePeloSimples = optantePeloSimples;
                }

                @XmlElement(name = "publicarEmail")
                public String getPublicarEmail() {
                    return publicarEmail;
                }

                public void setPublicarEmail(String publicarEmail) {
                    this.publicarEmail = publicarEmail;
                }

                @XmlElement(name = "eMailSemana")
                public String getEMailSemana() {
                    return eMailSemana;
                }

                public void setEMailSemana(String eMailSemana) {
                    this.eMailSemana = eMailSemana;
                }

                @XmlElement(name = "observacaoRai")
                public String getObservacaoRai() {
                    return observacaoRai;
                }

                public void setObservacaoRai(String observacaoRai) {
                    this.observacaoRai = observacaoRai;
                }

                @XmlElement(name = "atualizaSistemaFace")
                public String getAtualizaSistemaFace() {
                    return atualizaSistemaFace;
                }

                public void setAtualizaSistemaFace(String atualizaSistemaFace) {
                    this.atualizaSistemaFace = atualizaSistemaFace;
                }

                @XmlElement(name = "empresaDiretora")
                public String getEmpresaDiretora() {
                    return empresaDiretora;
                }

                public void setEmpresaDiretora(String empresaDiretora) {
                    this.empresaDiretora = empresaDiretora;
                }

                @XmlElement(name = "publicarNroEmpregados")
                public String getPublicarNroEmpregados() {
                    return publicarNroEmpregados;
                }

                public void setPublicarNroEmpregados(String publicarNroEmpregados) {
                    this.publicarNroEmpregados = publicarNroEmpregados;
                }

                @XmlElement(name = "dataValidadeDocumentacao")
                public String getDataValidadeDocumentacao() {
                    return dataValidadeDocumentacao;
                }

                public void setDataValidadeDocumentacao(String dataValidadeDocumentacao) {
                    this.dataValidadeDocumentacao = dataValidadeDocumentacao;
                }

                @XmlElement(name = "nacionalidadeCodigo")
                public String getNacionalidadeCodigo() {
                    return nacionalidadeCodigo;
                }

                public void setNacionalidadeCodigo(String nacionalidadeCodigo) {
                    this.nacionalidadeCodigo = nacionalidadeCodigo;
                }

                @XmlElement(name = "associado")
                public String getAssociado() {
                    return associado;
                }

                public void setAssociado(String associado) {
                    this.associado = associado;
                }

                @XmlElement(name = "codigoAtividadeEconomicaEstadual")
                public String getCodigoAtividadeEconomicaEstadual() {
                    return codigoAtividadeEconomicaEstadual;
                }

                public void setCodigoAtividadeEconomicaEstadual(String codigoAtividadeEconomicaEstadual) {
                    this.codigoAtividadeEconomicaEstadual = codigoAtividadeEconomicaEstadual;
                }

                @XmlElement(name = "codigoNacionalAtividadeEconomica")
                public String getCodigoNacionalAtividadeEconomica() {
                    return codigoNacionalAtividadeEconomica;
                }

                public void setCodigoNacionalAtividadeEconomica(String codigoNacionalAtividadeEconomica) {
                    this.codigoNacionalAtividadeEconomica = codigoNacionalAtividadeEconomica;
                }

                @XmlElement(name = "pes_id")
                public String getPesId() {
                    return pesId;
                }

                public void setPesId(String pesId) {
                    this.pesId = pesId;
                }

                @XmlElement(name = "enderecoPrincipal", namespace = "http://ws.iifcore.fiergs.org.br/")
                public Endereco getEnderecoPrincipal() {
                    return enderecoPrincipal;
                }

                public void setEnderecoPrincipal(Endereco enderecoPrincipal) {
                    this.enderecoPrincipal = enderecoPrincipal;
                }

                @XmlElement(name = "enderecoCobranca", namespace = "http://ws.iifcore.fiergs.org.br/")
                public Endereco getEnderecoCobranca() {
                    return enderecoCobranca;
                }

                public void setEnderecoCobranca(Endereco enderecoCobranca) {
                    this.enderecoCobranca = enderecoCobranca;
                }

                @XmlElement(name = "enderecoEntrega", namespace = "http://ws.iifcore.fiergs.org.br/")
                public Endereco getEnderecoEntrega() {
                    return enderecoEntrega;
                }

                public void setEnderecoEntrega(Endereco enderecoEntrega) {
                    this.enderecoEntrega = enderecoEntrega;
                }

                @XmlElement(name = "primeiroNome")
                public String getPrimeiroNome() {
                    return primeiroNome;
                }

                public void setPrimeiroNome(String primeiroNome) {
                    this.primeiroNome = primeiroNome;
                }

                @XmlElement(name = "nomeDoMeio")
                public String getNomeDoMeio() {
                    return nomeDoMeio;
                }

                public void setNomeDoMeio(String nomeDoMeio) {
                    this.nomeDoMeio = nomeDoMeio;
                }

                @XmlElement(name = "ultimoNome")
                public String getUltimoNome() {
                    return ultimoNome;
                }

                public void setUltimoNome(String ultimoNome) {
                    this.ultimoNome = ultimoNome;
                }

                public static class Endereco {
                    private String tipoLogradouro;
                    private String logradouro;
                    private String numero;
                    private String bairro;
                    private String cep;
                    private String dddTelefone;
                    private String telefone;
                    private Municipio municipio;

                    @XmlElement(name = "tipoLogradouro")
                    public String getTipoLogradouro() {
                        return tipoLogradouro;
                    }

                    public void setTipoLogradouro(String tipoLogradouro) {
                        this.tipoLogradouro = tipoLogradouro;
                    }

                    @XmlElement(name = "logradouro")
                    public String getLogradouro() {
                        return logradouro;
                    }

                    public void setLogradouro(String logradouro) {
                        this.logradouro = logradouro;
                    }

                    @XmlElement(name = "numero")
                    public String getNumero() {
                        return numero;
                    }

                    public void setNumero(String numero) {
                        this.numero = numero;
                    }

                    @XmlElement(name = "bairro")
                    public String getBairro() {
                        return bairro;
                    }

                    public void setBairro(String bairro) {
                        this.bairro = bairro;
                    }

                    @XmlElement(name = "cep")
                    public String getCep() {
                        return cep;
                    }

                    public void setCep(String cep) {
                        this.cep = cep;
                    }

                    @XmlElement(name = "dddTelefone")
                    public String getDddTelefone() {
                        return dddTelefone;
                    }

                    public void setDddTelefone(String dddTelefone) {
                        this.dddTelefone = dddTelefone;
                    }

                    @XmlElement(name = "telefone")
                    public String getTelefone() {
                        return telefone;
                    }

                    public void setTelefone(String telefone) {
                        this.telefone = telefone;
                    }

                    @XmlElement(name = "municipio")
                    public Municipio getMunicipio() {
                        return municipio;
                    }

                    public void setMunicipio(Municipio municipio) {
                        this.municipio = municipio;
                    }

                    public static class Municipio {
                        private String codigo;
                        private String nome;
                        private String codigoIbge;
                        private String codigoReceita;
                        private String codigoMec;
                        private String codigoDetran;
                        private String cepInicial;
                        private String cepFinal;
                        private String numeroHabitantes;
                        private UnidadeFederativa unidadeFederativa;

                        @XmlElement(name = "codigo")
                        public String getCodigo() {
                            return codigo;
                        }

                        public void setCodigo(String codigo) {
                            this.codigo = codigo;
                        }

                        @XmlElement(name = "nome")
                        public String getNome() {
                            return nome;
                        }

                        public void setNome(String nome) {
                            this.nome = nome;
                        }

                        @XmlElement(name = "codigoIbge")
                        public String getCodigoIbge() {
                            return codigoIbge;
                        }

                        public void setCodigoIbge(String codigoIbge) {
                            this.codigoIbge = codigoIbge;
                        }

                        @XmlElement(name = "codigoReceita")
                        public String getCodigoReceita() {
                            return codigoReceita;
                        }

                        public void setCodigoReceita(String codigoReceita) {
                            this.codigoReceita = codigoReceita;
                        }

                        @XmlElement(name = "codigoMec")
                        public String getCodigoMec() {
                            return codigoMec;
                        }

                        public void setCodigoMec(String codigoMec) {
                            this.codigoMec = codigoMec;
                        }

                        @XmlElement(name = "codigoDetran")
                        public String getCodigoDetran() {
                            return codigoDetran;
                        }

                        public void setCodigoDetran(String codigoDetran) {
                            this.codigoDetran = codigoDetran;
                        }

                        @XmlElement(name = "cepInicial")
                        public String getCepInicial() {
                            return cepInicial;
                        }

                        public void setCepInicial(String cepInicial) {
                            this.cepInicial = cepInicial;
                        }

                        @XmlElement(name = "cepFinal")
                        public String getCepFinal() {
                            return cepFinal;
                        }

                        public void setCepFinal(String cepFinal) {
                            this.cepFinal = cepFinal;
                        }

                        @XmlElement(name = "numeroHabitantes")
                        public String getNumeroHabitantes() {
                            return numeroHabitantes;
                        }

                        public void setNumeroHabitantes(String numeroHabitantes) {
                            this.numeroHabitantes = numeroHabitantes;
                        }

                        @XmlElement(name = "unidadeFederativa")
                        public UnidadeFederativa getUnidadeFederativa() {
                            return unidadeFederativa;
                        }

                        public void setUnidadeFederativa(UnidadeFederativa unidadeFederativa) {
                            this.unidadeFederativa = unidadeFederativa;
                        }

                        public static class UnidadeFederativa {
                            private String sigla;
                            private String codigoIbge;
                            private String nome;
                            private String regiaoGeograf;
                            private Pais pais;

                            @XmlElement(name = "sigla")
                            public String getSigla() {
                                return sigla;
                            }

                            public void setSigla(String sigla) {
                                this.sigla = sigla;
                            }

                            @XmlElement(name = "codigoIbge")
                            public String getCodigoIbge() {
                                return codigoIbge;
                            }

                            public void setCodigoIbge(String codigoIbge) {
                                this.codigoIbge = codigoIbge;
                            }

                            @XmlElement(name = "nome")
                            public String getNome() {
                                return nome;
                            }

                            public void setNome(String nome) {
                                this.nome = nome;
                            }

                            @XmlElement(name = "regiaoGeograf")
                            public String getRegiaoGeograf() {
                                return regiaoGeograf;
                            }

                            public void setRegiaoGeograf(String regiaoGeograf) {
                                this.regiaoGeograf = regiaoGeograf;
                            }

                            @XmlElement(name = "pais")
                            public Pais getPais() {
                                return pais;
                            }

                            public void setPais(Pais pais) {
                                this.pais = pais;
                            }

                            public static class Pais {
                                private String sigla;
                                private String nome;
                                private String codIso;
                                private String ibge;
                                private String sisbacen;

                                @XmlElement(name = "sigla")
                                public String getSigla() {
                                    return sigla;
                                }

                                public void setSigla(String sigla) {
                                    this.sigla = sigla;
                                }

                                @XmlElement(name = "nome")
                                public String getNome() {
                                    return nome;
                                }

                                public void setNome(String nome) {
                                    this.nome = nome;
                                }

                                @XmlElement(name = "codIso")
                                public String getCodIso() {
                                    return codIso;
                                }

                                public void setCodIso(String codIso) {
                                    this.codIso = codIso;
                                }

                                @XmlElement(name = "ibge")
                                public String getIbge() {
                                    return ibge;
                                }

                                public void setIbge(String ibge) {
                                    this.ibge = ibge;
                                }

                                @XmlElement(name = "sisbacen")
                                public String getSisbacen() {
                                    return sisbacen;
                                }

                                public void setSisbacen(String sisbacen) {
                                    this.sisbacen = sisbacen;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}