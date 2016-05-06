package br.com.orbetail.gettrainee.model.universidade;

/**
 * @author heitor
 * @since 05/05/16.
 */
public class Disciplina implements Comparable<Disciplina> {
    private Long id;
    private Integer semestre;
    private String nome;
    private String descricao;
    private Docente docente;

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

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    /**
     * TODO Isabela, implementar hash equals apos definir entidades
     */
    /**
     * @param o instance of Disciplina
     * @return int of compare TO
     */
    @Override
    public int compareTo(Disciplina o) {
        return nome.compareTo(o.getNome());
    }
}
