package br.com.orbetail.gettrainee.model.universidade;

/**
 * @author heitor
 * @since 05/05/16.
 */
public class ClassificacaoDisciplina {
    private Long id;
    private Integer peso;
    private Disciplina disciplina;
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

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
