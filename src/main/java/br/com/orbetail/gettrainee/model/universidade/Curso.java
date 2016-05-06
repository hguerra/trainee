package br.com.orbetail.gettrainee.model.universidade;

import java.util.Set;

/**
 * @author heitor
 * @since 05/05/16.
 */
public class Curso {
    private Long id;
    private String descricao;
    private Docente coordenador;
    private Set<ClassificacaoDisciplina> disciplinas;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Docente getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Docente coordenador) {
        this.coordenador = coordenador;
    }

    public Set<ClassificacaoDisciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Set<ClassificacaoDisciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
