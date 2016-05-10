package br.com.orbetail.gettrainee.modelbuilder;

import br.com.orbetail.gettrainee.model.Universidade;
import br.com.orbetail.gettrainee.model.universidade.Curso;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author heitor
 * @since 10/05/16.
 */
public class UniversidadeBuilder extends UsuarioBuilder {
    private Universidade universidade;

    public UniversidadeBuilder() {
        this.universidade = new Universidade();
    }

    public UniversidadeBuilder cnpj(String cnpj) {
        this.universidade.setCnpj(cnpj);
        return this;
    }

    public UniversidadeBuilder cursos(Curso... curso) {
        Set<Curso> cursos = new HashSet<>();
        Collections.addAll(cursos, curso);
        this.universidade.setCursos(cursos);
        return this;
    }

    public Universidade get() {
        this.universidade.setNome(usuario.getNome());
        this.universidade.setLogin(usuario.getLogin());
        this.universidade.setSenha(usuario.getSenha());
        this.universidade.setEndereco(usuario.getEndereco());
        this.universidade.setImage(usuario.getImage());
        this.universidade.setPerfils(usuario.getPerfils());
        return universidade;
    }
}
