package br.com.orbetail.gettrainee.model.endereco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author heitor
 * @since 05/05/16.
 */
@Entity
@Table(name = "BAI_BAIRRO")
public class Bairro {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "BAI_ID")
    private Long id;

    @Column(name = "BAI_BAIRRO", unique=true, length = 40, nullable = false)
    private String bairro;

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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
