package br.com.orbetail.gettrainee.model.endereco;

/**
 * @author heitor
 * @since 05/05/16.
 */
public class Cidade {
    private Long id;
    private String cidade;

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
}
