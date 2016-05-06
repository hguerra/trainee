package br.com.orbetail.gettrainee.model.endereco;

/**
 * @author heitor
 * @since 05/05/16.
 */
public class Bairro {
    private Long id;
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
