package br.com.orbetail.gettrainee.model.aluno;

import java.time.LocalDate;

/**
 * @author heitor
 * @since 05/05/16.
 */
public class Certificado {
    private Long id;
    private String nomeCurso;
    private String nomeOrgaoExpeditor;
    private LocalDate dataInicio;
    private LocalDate dataConclusao;
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
