package br.com.orbetail.gettrainee.service;

import br.com.orbetail.gettrainee.model.Empresa;

import java.util.List;
import java.util.Set;

/**
 * @author heitor
 * @since 17/05/16.
 */
public interface EmpresaService {
    Empresa salvar(Empresa empresa);

    void excluir(Long id);

    List<Empresa> listarTodos();

    Empresa buscarEmpresaPorCnpj(String cnpj);

    Set<Empresa> buscarEmpresasPorEspecializacao(String...especializacao);
}
