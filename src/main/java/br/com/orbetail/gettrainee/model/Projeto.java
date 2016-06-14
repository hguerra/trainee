package br.com.orbetail.gettrainee.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

/**
 * @author heitor
 * @since 05/05/16.
 */
@Entity
@Table(name = "PRJ_PROJETO")
public class Projeto implements Serializable {
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

    @Column(name = "PRJ_DATA_TERMINO")
    private LocalDate dataTermino;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "projetos")
    private Set<Usuario> usuarios;

    @Transient
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getDataFormatada(LocalDate data) {
        return data.format(formatter);
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }
}
