package br.com.orbetail.gettrainee.model.aluno;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author heitor
 * @since 05/05/16.
 */
@Entity
@Table(name = "PRJ_PROJETO")
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRJ_ID")
    private Long id;

    @Column(name = "PRJ_NOME", length = 40, nullable = false)
    private String nome;

    @Column(name = "PRJ_DESCRICAO")
    private String descricao;

    @Column(name = "PRJ_DATA_INICIO", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "PRJ_DATA_TERMINO", nullable = false)
    private LocalDate datatermino;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDatatermino() {
        return datatermino;
    }

    public void setDatatermino(LocalDate datatermino) {
        this.datatermino = datatermino;
    }
}
