package br.com.orbetail.gettrainee.service;

import br.com.orbetail.gettrainee.model.Universidade;
import br.com.orbetail.gettrainee.model.universidade.Curso;

import java.util.List;

/**
 * @author heitor
 * @since 18/05/16.
 */
public interface UniversidadeService {

    Universidade salvar(Universidade universidade);

    void excluir(Long id);

    Universidade buscarUniversidadePorId(Long id);

    List<Universidade> listarTodos();

    Universidade buscarUniversidadePorCnpj(String cnpj);

    List<Curso> buscarCursosFornecidosPorId(Long id);
}
