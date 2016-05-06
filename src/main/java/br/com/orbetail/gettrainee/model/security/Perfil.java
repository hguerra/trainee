package br.com.orbetail.gettrainee.model.security;

import java.util.Set;

/**
 * @author heitor
 * @since 05/05/16.
 */
public class Perfil {
    private Long id;
    private String nome;
    private Set<Role> roles;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
