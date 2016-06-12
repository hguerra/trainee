package br.com.orbetail.gettrainee.model.endereco;

import javax.persistence.*;

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

    @Column(name = "BAI_BAIRRO", length = 40, nullable = false)
    private String bairro;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "BAI_CIDADE", nullable = false)
    private Cidade cidade;

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

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
