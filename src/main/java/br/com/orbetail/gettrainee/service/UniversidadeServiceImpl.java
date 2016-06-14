package br.com.orbetail.gettrainee.service;

import br.com.orbetail.gettrainee.model.Universidade;
import br.com.orbetail.gettrainee.model.universidade.Curso;
import br.com.orbetail.gettrainee.repository.UniversidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author heitor
 * @since 19/05/16.
 */
@Service("universidadeService")
public class UniversidadeServiceImpl implements UniversidadeService {

    @Autowired
    private UniversidadeRepository universidadeRepository;

    /**
     * @param universidadeRepository:UniversidadeRepository
     */
    public void setUniversidadeRepository(UniversidadeRepository universidadeRepository) {
        this.universidadeRepository = universidadeRepository;
    }

    @Transactional
    @Override
    public Universidade salvar(Universidade universidade) {
        return universidadeRepository.save(universidade);
    }

    @Transactional
    @Override
    public void excluir(Long id) {
        universidadeRepository.delete(id);
    }

    @Override
    public Universidade buscarUniversidadePorId(Long id) {
        return universidadeRepository.findById(id);
    }

    @Override
    public List<Universidade> listarTodos() {
        List<Universidade> todos = new ArrayList<>();
        for (Universidade universidade : universidadeRepository.findAll())
            todos.add(universidade);
        return todos;
    }

    @Override
    public Universidade buscarUniversidadePorCnpj(String cnpj) {
        return universidadeRepository.findByCnpj(cnpj);
    }

    @Override
    public List<Curso> buscarCursosFornecidosPorId(Long id) {
        return universidadeRepository.findAllCursos(id);
    }

    @Override
    public List<Universidade> buscarUniversidadePorCursoDescricao(String descricao) {
        Set<Curso> cursos = universidadeRepository.findCursosByDescricao(descricao.toUpperCase());
        return universidadeRepository.findByCursosIn(cursos);
    }
}
