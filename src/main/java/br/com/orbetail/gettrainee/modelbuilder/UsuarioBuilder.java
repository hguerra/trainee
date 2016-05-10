package br.com.orbetail.gettrainee.modelbuilder;

import br.com.orbetail.gettrainee.model.Endereco;
import br.com.orbetail.gettrainee.model.Universidade;
import br.com.orbetail.gettrainee.model.Usuario;
import br.com.orbetail.gettrainee.model.security.Perfil;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author heitor
 * @since 10/05/16.
 */
public abstract class UsuarioBuilder {
    protected Usuario usuario;

    public UsuarioBuilder() {
        this.usuario = new Usuario();
    }

    public UsuarioBuilder nome(String nome) {
        this.usuario.setNome(nome);
        return this;
    }

    public UsuarioBuilder login(String login) {
        this.usuario.setLogin(login);
        return this;
    }

    public UsuarioBuilder senha(String senha) {
        this.usuario.setSenha(senha);
        return this;
    }

    public UsuarioBuilder endereco(Endereco endereco) {
        this.usuario.setEndereco(endereco);
        return this;
    }

    public UsuarioBuilder image(byte[] image) {
        this.usuario.setImage(image);
        return this;
    }

    public UsuarioBuilder comPerfils(Perfil... perfil) {
        Set<Perfil> perfils = new HashSet<>();
        Collections.addAll(perfils, perfil);
        this.usuario.setPerfils(perfils);
        return this;
    }

    public EmpresaBuilder empresa() {
        return (EmpresaBuilder) this;
    }

    public UniversidadeBuilder universidade() {
        return (UniversidadeBuilder) this;
    }

    public AlunoBuilder aluno() {
        return (AlunoBuilder) this;
    }
}
