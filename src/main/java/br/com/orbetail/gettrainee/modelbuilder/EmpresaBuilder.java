package br.com.orbetail.gettrainee.modelbuilder;

import br.com.orbetail.gettrainee.model.Empresa;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author heitor
 * @since 10/05/16.
 */
public class EmpresaBuilder extends UsuarioBuilder {
    private Empresa empresa;

    public EmpresaBuilder() {
        this.empresa = new Empresa();
    }

    public EmpresaBuilder cnpj(String cnpj) {
        this.empresa.setCnpj(cnpj);
        return this;
    }

    public EmpresaBuilder descricao(String descricao) {
        this.empresa.setDescricao(descricao);
        return this;
    }

    public EmpresaBuilder especializacao(String... palavrasChave) {
        Set<String> especializacao = new HashSet<>();
        Collections.addAll(especializacao, palavrasChave);
        this.empresa.setEspecializacao(especializacao);
        return this;
    }


    public Empresa get() {
        this.empresa.setNome(usuario.getNome());
        this.empresa.setLogin(usuario.getLogin());
        this.empresa.setSenha(usuario.getSenha());
        this.empresa.setEndereco(usuario.getEndereco());
        this.empresa.setImage(usuario.getImage());
        this.empresa.setPerfils(usuario.getPerfils());
        this.empresa.setProjetos(usuario.getProjetos());
        return this.empresa;
    }
}
