package br.com.orbetail.gettrainee.model;

import java.util.Set;

/**
 * @author heitor
 * @since 05/05/16.
 */
public class Empresa extends Usuario {
    private String cnpj;
    private String descricao;
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
     * @return Set<String>
     */
    public Set<String> getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(Set<String> especializacao) {
        this.especializacao = especializacao;
    }
}
