package br.com.orbetail.gettrainee.service;

import br.com.orbetail.gettrainee.model.endereco.Bairro;
import br.com.orbetail.gettrainee.model.endereco.Cidade;
import br.com.orbetail.gettrainee.model.endereco.Rua;
import br.com.orbetail.gettrainee.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author heitor
 * @since 12/06/16.
 */
@Service("enderecoService")
public class EnderecoServiceImpl implements EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public void setEnderecoRepository(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public List<Cidade> listarCidadesEstado(Long estadoId) {
        return enderecoRepository.findByEstado(estadoId);
    }

    @Override
    public Bairro buscarBairro(Long cidadeId, String bairro) {
        return enderecoRepository.findByBairro(cidadeId, bairro);
    }

    @Override
    public Rua buscarRua(Long bairroId, String rua) {
        return enderecoRepository.findByRua(bairroId, rua);
    }
}
