package br.com.orbetail.gettrainee.model.aluno;

import br.com.orbetail.gettrainee.model.Usuario;

import javax.persistence.*;

/**
 * @author heitor
 * @since 05/05/16.
 */
@Entity
@Table(name = "REC_RECOMENDACAO")
public class Recomendacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REC_ID")
    private Long id;

    @Column(name = "REC_NOTA", length = 2, nullable = false)
    private Integer nota;

    @Column(name = "REC_MENSAGEM", nullable = false)
    private String Recomendacao;

    @Column(name = "REC_USUARIO", length = 2, nullable = false)
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
