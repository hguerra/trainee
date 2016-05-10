package br.com.orbetail.gettrainee.model.aluno;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author heitor
 * @since 05/05/16.
 */
@Entity
@Table(name = "CER_CERTIFICADO")
public class Certificado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CER_ID")
    private Long id;

    @Column(name = "CER_NOME_CURSO", length = 40, nullable = false)
    private String nomeCurso;

    @Column(name = "CER_ORGAO_EXPEDITOR", length = 40, nullable = false)
    private String nomeOrgaoExpeditor;

    @Column(name = "CER_DATA_INICIO", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "CER_DATA_CONCLUSAO", nullable = false)
    private LocalDate dataConclusao;

    @Column(name = "CER_LINK")
    private String link;

    /**
     * Getters and setters
     *
     * @return attribute value
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getNomeOrgaoExpeditor() {
        return nomeOrgaoExpeditor;
    }

    public void setNomeOrgaoExpeditor(String nomeOrgaoExpeditor) {
        this.nomeOrgaoExpeditor = nomeOrgaoExpeditor;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
