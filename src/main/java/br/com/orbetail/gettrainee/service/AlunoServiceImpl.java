package br.com.orbetail.gettrainee.service;

import br.com.orbetail.gettrainee.model.Aluno;
import br.com.orbetail.gettrainee.model.Projeto;
import br.com.orbetail.gettrainee.model.aluno.Curriculo;
import br.com.orbetail.gettrainee.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heitor
 * @since 19/05/16.
 */
@Service("alunoService")
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    /**
     * @param alunoRepository:AlunoRepository
     */
    public void setAlunoRepository(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Transactional
    @Override
    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Transactional
    @Override
    public void excluir(Long id) {
        alunoRepository.delete(id);
    }

    @Override
    public List<Aluno> listarTodos() {
        List<Aluno> todos = new ArrayList<>();
        for (Aluno aluno : alunoRepository.findAll())
            todos.add(aluno);
        return todos;
    }

    @Override
    public Aluno buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id);
    }

    @Override
    public Aluno buscarAlunoEagerCompetenciasPorId(Long id) {
        return alunoRepository.findAlunoFetchCompetencias(id);
    }

    @Override
    public Aluno buscarAlunoPorCpf(String cpf) {
        return alunoRepository.findByCpf(cpf);
    }

    @Override
    public Aluno buscarAlunoPorCurriculo(Curriculo curriculo) {
        return alunoRepository.findByCurriculo(curriculo);
    }

    @Override
    public List<Aluno> buscarAlunosPorProjeto(Projeto projeto) {
        return alunoRepository.findByProjeto(projeto);
    }

    @Override
    public List<Aluno> buscarAlunosPorCompetencias(String palavraChave) {
        return alunoRepository.findByCompentecia(palavraChave);
    }

    @Override
    public List<Aluno> buscarAlunosPorRecomendacoes(Integer nota) {
        return alunoRepository.findByRecomendacao(nota);
    }
}
