package br.com.orbetail.gettrainee.service;

import br.com.orbetail.gettrainee.model.Aluno;
import br.com.orbetail.gettrainee.model.aluno.Curriculo;
import br.com.orbetail.gettrainee.model.aluno.Projeto;

import java.util.List;

/**
 * @author heitor
 * @since 18/05/16.
 */
public interface AlunoService {

    Aluno salvar(Aluno aluno);

    void excluir(Long id);

    List<Aluno> listarTodos();

    Aluno buscarAlunoPorId(Long id);

    Aluno buscarAlunoEagerCompetenciasPorId(Long id);

    Aluno buscarAlunoPorCpf(String cpf);

    Aluno buscarAlunoPorCurriculo(Curriculo curriculo);

    List<Aluno> buscarAlunosPorProjeto(Projeto projeto);

    List<Aluno> buscarAlunosPorCompetencias(String palavraChave);

    List<Aluno> buscarAlunosPorRecomendacoes(Integer nota);
}
