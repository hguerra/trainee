package br.com.orbetail.gettrainee.model.endereco;

import javax.persistence.*;

/**
 * @author heitor
 * @since 05/05/16.
 */
@Entity
@Table(name = "CID_CIDADE")
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CID_ID")
    private Long id;

    @Column(name = "CID_CIDADE", length = 40, nullable = false)
    private String cidade;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "CID_ESTADO", nullable = false)
    private Estado estado;

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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
