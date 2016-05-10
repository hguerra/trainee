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
@Table(name = "RU_RUA")
public class Rua {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RU_ID")
    private Long id;

    @Column(name = "RU_RUA", unique = true, length = 40, nullable = false)
    private String rua;

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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
}
