package br.com.orbetail.gettrainee.service;

import br.com.orbetail.gettrainee.model.Projeto;

import java.util.List;

/**
 * @author heitor
 * @since 19/05/16.
 */
public interface ProjetoService {

    Projeto buscarProjetoPorId(Long id);

    Projeto salvar(Projeto projeto);

    void excluir(Long id);

    List<Projeto> listarTodos();

    List<Projeto> buscarProjetosRecentesEmAberto();

    List<Projeto> buscarCincoProjetosRecentesEmAberto();

    List<Projeto> buscarProjetoPorNome(String termoBusca);

    List<Projeto> buscarProjetoPorDescricao(String descricao);
}
