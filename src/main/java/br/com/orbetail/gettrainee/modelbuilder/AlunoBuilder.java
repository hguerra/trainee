package br.com.orbetail.gettrainee.modelbuilder;

import br.com.orbetail.gettrainee.model.Aluno;
import br.com.orbetail.gettrainee.model.aluno.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author heitor
 * @since 10/05/16.
 */
public class AlunoBuilder extends UsuarioBuilder {
    private Aluno aluno;

    public AlunoBuilder() {
        this.aluno = new Aluno();
    }

    public AlunoBuilder cpf(String numero) {
        this.aluno.setCpf(numero);
        return this;
    }

    public AlunoBuilder curriculo(Curriculo curriculo) {
        this.aluno.setCurriculo(curriculo);
        return this;
    }

    public AlunoBuilder competencias(Competencia... competecia) {
        Set<Competencia> competencias = new HashSet<>();
        Collections.addAll(competencias, competecia);
        this.aluno.setCompetencias(competencias);
        return this;
    }

    public AlunoBuilder publicacoes(Publicacao... publicacao) {
        Set<Publicacao> publicacoes = new HashSet<>();
        Collections.addAll(publicacoes, publicacao);
        this.aluno.setPublicacoes(publicacoes);
        return this;
    }

    public AlunoBuilder idiomas(Idioma... idioma) {
        Set<Idioma> idiomas = new HashSet<>();
        Collections.addAll(idiomas, idioma);
        this.aluno.setIdiomas(idiomas);
        return this;
    }

    public AlunoBuilder grupos(Grupo... grupo) {
        Set<Grupo> grupos = new HashSet<>();
        Collections.addAll(grupos, grupo);
        this.aluno.setGrupos(grupos);
        return this;
    }

    public AlunoBuilder recomendacoes(Recomendacao... recomedacao) {
        Set<Recomendacao> recomendacoes = new HashSet<>();
        Collections.addAll(recomendacoes, recomedacao);
        this.aluno.setRecomendacaoes(recomendacoes);
        return this;
    }

    public Aluno get() {
        this.aluno.setNome(usuario.getNome());
        this.aluno.setLogin(usuario.getLogin());
        this.aluno.setSenha(usuario.getSenha());
        this.aluno.setEndereco(usuario.getEndereco());
        this.aluno.setImage(usuario.getImage());
        this.aluno.setPerfils(usuario.getPerfils());
        this.aluno.setProjetos(usuario.getProjetos());
        return aluno;
    }
}
