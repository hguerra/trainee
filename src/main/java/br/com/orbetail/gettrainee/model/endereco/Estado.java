package br.com.orbetail.gettrainee.model.endereco;

import javax.persistence.*;

/**
 * @author heitor
 * @since 05/05/16.
 */
@Entity
@Table(name = "ES_ESTADO")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ES_ID")
    private Long id;

    @Column(name = "ES_ESTADO", length = 20, nullable = false)
    private String estado;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "ES_PAIS", nullable = false)
    private Pais pais;

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
