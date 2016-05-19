package br.com.orbetail.gettrainee.service;

import br.com.orbetail.gettrainee.model.Projeto;
import br.com.orbetail.gettrainee.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public Projeto salvar(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    @Override
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
}
