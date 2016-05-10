package br.com.orbetail.gettrainee.model.universidade;

import javax.persistence.*;
import java.util.Set;

/**
 * @author heitor
 * @since 05/05/16.
 */
@Entity
@Table(name = "DOC_DOCENTE")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOC_ID")
    private Long id;

    @Column(name = "DOC_NOME", unique = true, length = 50, nullable = false)
    private String nome;

    @Column(name = "DOC_LATTES", unique = true, nullable = false)
    private String lattes;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "docente")
    private Set<Disciplina> disciplinasMinistradas;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLattes() {
        return lattes;
    }

    public void setLattes(String lattes) {
        this.lattes = lattes;
    }

    public Set<Disciplina> getDisciplinasMinistradas() {
        return disciplinasMinistradas;
    }

    public void setDisciplinasMinistradas(Set<Disciplina> disciplinasMinistradas) {
        this.disciplinasMinistradas = disciplinasMinistradas;
    }
}
