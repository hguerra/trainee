package br.com.orbetail.gettrainee.model;

import javax.persistence.*;
import java.util.Set;

/**
 * @author heitor
 * @since 05/05/16.
 */
@Entity
@Table(name = "EMP_EMPRESA")
public class Empresa extends Usuario {

    @Column(name = "EMP_CNPJ", unique = true, length = 20, nullable = false)
    private String cnpj;

    @Column(name = "EMP_DESCRICAO")
    private String descricao;

    @ElementCollection
    @CollectionTable(name = "EMP_ESPECIALIZACAO")
    private Set<String> especializacao;

    /**
     * Getters and setters
     *
     * @return attribute value
     */
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna um set de palavras-chave
     *
     * @return Set<String>
     */
    public Set<String> getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(Set<String> especializacao) {
        this.especializacao = especializacao;
    }
}
