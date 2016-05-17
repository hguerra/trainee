package br.com.orbetail.gettrainee.model;

import br.com.orbetail.gettrainee.model.security.Perfil;
import br.com.orbetail.gettrainee.model.security.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author heitor
 * @since 05/05/16.
 */
@Entity
@Table(name = "USR_USUARIO")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_ID")
    private Long id;

    @Column(name = "USR_NOME", unique = true, length = 40, nullable = false)
    private String nome;

    @Column(name = "USR_LOGIN", unique = true, length = 40, nullable = false)
    private String login;

    @Column(name = "USR_SENHA", length = 40, nullable = false)
    private String senha;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "USR_ENDERECO")
    private Endereco endereco;

    @Lob
    @Column(name = "USR_IMAGE", nullable = false, columnDefinition = "mediumblob")
    private byte[] image;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "USR_PERFILS")
    private Set<Perfil> perfils;

    /**
     * SpringData
     */

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = new HashSet<>();
        if (perfils != null) {
            perfils.forEach(perfil -> roles.addAll(perfil.getRoles()));
        }
        return roles;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Set<Perfil> getPerfils() {
        return perfils;
    }

    public void setPerfils(Set<Perfil> perfils) {
        this.perfils = perfils;
    }


}
