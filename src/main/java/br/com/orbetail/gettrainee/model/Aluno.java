package br.com.orbetail.gettrainee.model;

import br.com.orbetail.gettrainee.model.aluno.*;

import java.util.Set;

/**
 * @author heitor
 * @since 05/05/16.
 */
public class Aluno {
    private String cpf;
    private Curriculo curriculo;
    private Set<Projeto> portifolio;
    private Set<Competencia> competencias;
    private Set<Publicacao> publicacoes;
    private Set<Idioma> idiomas;
    private Set<Grupo> grupos;
    private Set<Recomendacao> recomendacaoes;

    /**
     * Getters and setters
     *
     * @return attribute value
     */
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Curriculo getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(Curriculo curriculo) {
        this.curriculo = curriculo;
    }

    public Set<Projeto> getPortifolio() {
        return portifolio;
    }

    public void setPortifolio(Set<Projeto> portifolio) {
        this.portifolio = portifolio;
    }

    public Set<Competencia> getCompetencias() {
        return competencias;
    }

    public void setCompetencias(Set<Competencia> competencias) {
        this.competencias = competencias;
    }

    public Set<Publicacao> getPublicacoes() {
        return publicacoes;
    }

    public void setPublicacoes(Set<Publicacao> publicacoes) {
        this.publicacoes = publicacoes;
    }

    public Set<Idioma> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(Set<Idioma> idiomas) {
        this.idiomas = idiomas;
    }

    public Set<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(Set<Grupo> grupos) {
        this.grupos = grupos;
    }

    public Set<Recomendacao> getRecomendacaoes() {
        return recomendacaoes;
    }

    public void setRecomendacaoes(Set<Recomendacao> recomendacaoes) {
        this.recomendacaoes = recomendacaoes;
    }
}
