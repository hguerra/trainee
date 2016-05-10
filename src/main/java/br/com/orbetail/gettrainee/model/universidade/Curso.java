package br.com.orbetail.gettrainee.model.universidade;

import javax.persistence.*;
import java.util.Set;

/**
 * @author heitor
 * @since 05/05/16.
 */
@Entity
@Table(name = "CUR_CURSO")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUR_ID")
    private Long id;

    @Column(name = "CUR_DESCRICAO")
    private String descricao;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "CUR_COORDENADOR")
    private Docente coordenador;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "CUR_CURSO_CLASSIFICAO_DISCIPLINA", joinColumns = {@JoinColumn(name = "CUR_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CLA_DIS_ID")})
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
