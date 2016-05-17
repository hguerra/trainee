package br.com.orbetail.gettrainee.service;

import br.com.orbetail.gettrainee.model.Empresa;

import java.util.Set;

/**
 * @author heitor
 * @since 17/05/16.
 */
public interface EmpresaService {
    Empresa salvar(Empresa empresa);

    void excluir(Long id);

    Empresa findByCnpj(String cnpj);

    Set<Empresa> findByEspecializacao(String...especializacao);
}
