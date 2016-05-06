package br.com.orbetail.gettrainee.model.aluno;

import br.com.orbetail.gettrainee.model.Usuario;

/**
 * @author heitor
 * @since 05/05/16.
 */
public class Recomendacao {
    private Long id;
    private Integer nota;
    private String Recomendacao;
    private Usuario usuario;

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

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getRecomendacao() {
        return Recomendacao;
    }

    public void setRecomendacao(String recomendacao) {
        Recomendacao = recomendacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
