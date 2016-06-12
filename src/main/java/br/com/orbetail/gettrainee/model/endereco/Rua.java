package br.com.orbetail.gettrainee.model.endereco;

import javax.persistence.*;

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

    @Column(name = "RU_RUA", length = 40, nullable = false)
    private String rua;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "RU_BAIRRO", nullable = false)
    private Bairro bairro;

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

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }
}
