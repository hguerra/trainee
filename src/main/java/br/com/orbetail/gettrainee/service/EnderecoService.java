package br.com.orbetail.gettrainee.service;

import br.com.orbetail.gettrainee.model.Endereco;

/**
 * @author heitor
 * @since 18/05/16.
 */
public interface EnderecoService {

    Endereco salvar(Endereco endereco);

    void excluir(Long id);


}
