package br.com.orbetail.gettrainee.model.endereco;

/**
 * @author heitor
 * @since 05/05/16.
 */
public class Pais {
    private Long id;
    private String pais;

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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
