package br.com.orbetail.gettrainee.model.aluno;

import br.com.orbetail.gettrainee.model.universidade.Curso;
import br.com.orbetail.gettrainee.model.universidade.Disciplina;

import javax.persistence.*;
import java.util.Set;

/**
 * @author heitor
 * @since 05/05/16.
 */

@Entity
@Table(name = "CUR_CURRICULO")
public class Curriculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUR_ID")
    private Long id;

    @Column(name = "CUR_OBJETIVO", length = 40, nullable = false)
    private String objetivo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "CUR_CURSOS")
    private Set<Curso> cursos;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "CUR_DISCIPLINAS_CURSADAS")
    private Set<Disciplina> disciplinasCursadas;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "CUR_EXPERIENCIAS")
    private Set<Experiencia> experiencias;

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

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

    public Set<Disciplina> getDisciplinasCursadas() {
        return disciplinasCursadas;
    }

    public void setDisciplinasCursadas(Set<Disciplina> disciplinasCursadas) {
        this.disciplinasCursadas = disciplinasCursadas;
    }

    public Set<Experiencia> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(Set<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }
}
