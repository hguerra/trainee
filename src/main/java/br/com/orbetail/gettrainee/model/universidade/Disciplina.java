package br.com.orbetail.gettrainee.model.universidade;

import javax.persistence.*;

/**
 * @author heitor
 * @since 05/05/16.
 */
@Entity
@Table(name = "DIS_DISCIPLINA")
public class Disciplina implements Comparable<Disciplina> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DIS_ID")
    private Long id;

    @Column(name = "DIS_SEMESTRE", length = 2, nullable = false)
    private Integer semestre;

    @Column(name = "DIS_NOME", unique = true, length = 50, nullable = false)
    private String nome;

    @Column(name = "DIS_DESCRICAO")
    private String descricao;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "DOC_ID")
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
