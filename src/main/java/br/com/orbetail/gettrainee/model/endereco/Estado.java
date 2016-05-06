package br.com.orbetail.gettrainee.model.endereco;

/**
 * @author heitor
 * @since 05/05/16.
 */
public class Estado {
    private Long id;
    private String estado;

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
}
