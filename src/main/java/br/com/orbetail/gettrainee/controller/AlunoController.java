package br.com.orbetail.gettrainee.controller;

import br.com.orbetail.gettrainee.model.Aluno;
import br.com.orbetail.gettrainee.modelbuilder.AlunoBuilder;
import br.com.orbetail.gettrainee.service.AlunoService;
import br.com.orbetail.gettrainee.util.ValidadorCollection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;

/**
 * @author heitor
 * @since 18/05/16.
 */
@ManagedBean
public class AlunoController {
    private AlunoBuilder alunoBuilder = new AlunoBuilder();
    private List<Aluno> alunos;

    @ManagedProperty(value = "#{alunoService}")
    private AlunoService alunoService;

    /**
     * @param alunoService:AlunoService
     */
    public void setAlunoService(AlunoService alunoService) {
        this.alunoService = alunoService;
    }


    public Aluno getAluno() {
        return alunoBuilder.get();
    }

    public List<Aluno> getAlunos() {
        if (ValidadorCollection.isListNotNullOrEmpty.validar(alunos))
            return alunos;
        alunos = alunoService.listarTodos();
        return alunos;
    }
}
