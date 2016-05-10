package br.com.orbetail.gettrainee.model;

import br.com.orbetail.gettrainee.model.universidade.Curso;

import javax.persistence.*;
import java.util.Set;

/**
 * @author heitor
 * @since 05/05/16.
 */
@Entity
@Table(name = "UNI_UNIVERSIDADE")
public class Universidade extends Usuario {

    @Column(name = "UNI_CNPJ", unique = true, length = 20, nullable = false)
    private String cnpj;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "UNI_UNIVERSIDADE_CURSO", joinColumns = {@JoinColumn(name = "USR_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CUR_ID")})
    private Set<Curso> cursos;

    /**
     * Getters and setters
     *
     * @return attribute value
     */

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }
}
