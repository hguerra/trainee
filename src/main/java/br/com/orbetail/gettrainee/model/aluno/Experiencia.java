package br.com.orbetail.gettrainee.model.aluno;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author heitor
 * @since 05/05/16.
 */
@Entity
@Table(name = "EXP_EXPERIENCIA")
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EXP_ID")
    private Long id;

    @Column(name = "EXP_AREA", length = 40, nullable = false)
    private String area;

    @Column(name = "EXP_DESCRICAO")
    private String descricao;

    @Column(name = "EXP_DATA_INICIO", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "EXP_DATA_TERMINO", nullable = false)
    private LocalDate dataTermino;

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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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
}
