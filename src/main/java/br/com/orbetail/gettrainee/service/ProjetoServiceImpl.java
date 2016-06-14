package br.com.orbetail.gettrainee.service;

import br.com.orbetail.gettrainee.model.Projeto;
import br.com.orbetail.gettrainee.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heitor
 * @since 19/05/16.
 */
@Service("projetoService")
public class ProjetoServiceImpl implements ProjetoService {
    private final Pageable MAX_PAGE = new PageRequest(0, 5);

    @Autowired
    private ProjetoRepository projetoRepository;

    /**
     * @param projetoRepository: ProjetoRepository
     */
    public void setProjetoRepository(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    @Override
    public Projeto buscarProjetoPorId(Long id) {
        return projetoRepository.findById(id);
    }

    @Override
    @Transactional
    public Projeto salvar(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    @Override
    @Transactional
    public void excluir(Long id) {
        projetoRepository.delete(id);
    }

    @Override
    public List<Projeto> listarTodos() {
        List<Projeto> todos = new ArrayList<>();
        for (Projeto p : projetoRepository.findAll())
            todos.add(p);
        return todos;
    }

    @Override
    public List<Projeto> buscarProjetosRecentesEmAberto() {
        return projetoRepository.findProjetosRecentesAbertos();
    }

    @Override
    public List<Projeto> buscarCincoProjetosRecentesEmAberto() {
        return projetoRepository.findProjetosRecentesAbertos(MAX_PAGE);
    }

    @Override
    public List<Projeto> buscarProjetoPorNome(String termoBusca) {
        return projetoRepository.findByNome(termoBusca);
    }

    @Override
    public List<Projeto> buscarProjetoPorDescricao(String descricao) {
        return projetoRepository.findByDescricaoContainingIgnoreCase(descricao);
    }
}
