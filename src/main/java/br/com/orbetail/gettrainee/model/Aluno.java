package br.com.orbetail.gettrainee.model;

import br.com.orbetail.gettrainee.model.aluno.*;

import javax.persistence.*;
import java.util.Set;

/**
 * @author heitor
 * @since 05/05/16.
 */
@Entity
@Table(name = "ALN_ALUNO")
public class Aluno extends Usuario {
    @Column(name = "ALN_CPF", unique = true, length = 20, nullable = false)
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "ALN_CURRICULO")
    private Curriculo curriculo;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "ALN_ALUNO_PROJETO", joinColumns = {@JoinColumn(name = "USR_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PRJ_ID")})
    private Set<Projeto> portifolio;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "ALN_ALUNO_COMPETENCIA", joinColumns = {@JoinColumn(name = "USR_ID")},
            inverseJoinColumns = {@JoinColumn(name = "COM_ID")})
    private Set<Competencia> competencias;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "ALN_ALUNO_PUBLICACAO", joinColumns = {@JoinColumn(name = "USR_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PUB_ID")})
    private Set<Publicacao> publicacoes;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "ALN_IDIOMAs")
    private Set<Idioma> idiomas;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "ALN_GRUPOS")
    private Set<Grupo> grupos;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "ALN_RECOMENDACOES")
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
