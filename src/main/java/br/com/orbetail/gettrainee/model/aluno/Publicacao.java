package br.com.orbetail.gettrainee.model.aluno;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * @author heitor
 * @since 05/05/16.
 */
@Entity
@Table(name = "PUB_PUBLICACAO")
public class Publicacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PUB_ID")
    private Long id;

    @Column(name = "PUB_TITULO", nullable = false)
    private String titulo;

    @Column(name = "PUB_LIVRO", nullable = false)
    private String livro;

    @Column(name = "PUB_PAGINAS", length = 20, nullable = false)
    private String paginas;

    @Column(name = "PUB_ANO", nullable = false)
    private LocalDate ano;

    @ElementCollection
    @CollectionTable(name = "PUB_AUTORES")
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
