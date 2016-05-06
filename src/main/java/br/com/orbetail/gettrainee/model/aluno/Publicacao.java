package br.com.orbetail.gettrainee.model.aluno;

import java.time.LocalDate;
import java.util.List;

/**
 * @author heitor
 * @since 05/05/16.
 */
public class Publicacao {
    private Long id;
    private String titulo;
    private String livro;
    private String paginas;
    private LocalDate ano;
    private List<String> autores;

    /**
     * @return full ABNT reference
     */
    @Override
    public String toString() {
        /**
         * TODO Isabela, usar StringBuilder para criar a referencia de citacao
         */
        return super.toString();
    }

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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public LocalDate getAno() {
        return ano;
    }

    public void setAno(LocalDate ano) {
        this.ano = ano;
    }

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }
}
