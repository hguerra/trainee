package br.com.orbetail.gettrainee.model.endereco;

/**
 * @author heitor
 * @since 05/05/16.
 */
public class Rua {
    private Long id;
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
