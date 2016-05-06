package br.com.orbetail.gettrainee.model.aluno;

/**
 * @author heitor
 * @since 05/05/16.
 */
public class Grupo {
    private Long id;
    private String grupo;
    private String descricao;
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

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
