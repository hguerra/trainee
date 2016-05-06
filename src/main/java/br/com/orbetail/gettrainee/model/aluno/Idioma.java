package br.com.orbetail.gettrainee.model.aluno;

/**
 * @author heitor
 * @since 05/05/16.
 */
public class Idioma {
    private Long id;
    private String idioma;

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

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}
