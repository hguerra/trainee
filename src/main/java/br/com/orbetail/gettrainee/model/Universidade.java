package br.com.orbetail.gettrainee.model;

import br.com.orbetail.gettrainee.model.universidade.Curso;

import java.util.Set;

/**
 * @author heitor
 * @since 05/05/16.
 */
public class Universidade extends Usuario {
    private String cnpj;
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
