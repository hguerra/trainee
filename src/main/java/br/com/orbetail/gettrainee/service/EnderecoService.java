package br.com.orbetail.gettrainee.service;

import br.com.orbetail.gettrainee.model.endereco.Bairro;
import br.com.orbetail.gettrainee.model.endereco.Cidade;
import br.com.orbetail.gettrainee.model.endereco.Rua;

import java.util.List;

/**
 * @author heitor
 * @since 12/06/16.
 */
public interface EnderecoService {

    List<Cidade> listarCidadesEstado(Long estadoId);

    List<Bairro> listarBairrosCidade(Long cidadeId);

    Bairro buscarBairro(Long cidadeId, String bairro);

    Rua buscarRua(Long bairroId, String rua);
}
