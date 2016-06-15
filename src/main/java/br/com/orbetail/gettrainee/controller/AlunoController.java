package br.com.orbetail.gettrainee.controller;

import br.com.orbetail.gettrainee.model.Aluno;
import br.com.orbetail.gettrainee.service.AlunoService;
import br.com.orbetail.gettrainee.service.EnderecoService;
import br.com.orbetail.gettrainee.util.JSFMensagens;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;

/**
 * @author heitor
 * @since 18/05/16.
 */
@ManagedBean
public class AlunoController {
    private String termoBusca;
    private String tipoBusca;
    private List<Aluno> alunos;


    @ManagedProperty(value = "#{alunoService}")
    private AlunoService alunoService;

    /**
     * @param alunoService:AlunoService
     */
    public void setAlunoService(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @ManagedProperty(value = "#{enderecoService}")
    private EnderecoService enderecoService;

    public void setEnderecoService(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }


    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void buscar() {
        if (tipoBusca.equals("TODOS")) {
            alunos = alunoService.listarTodos();
        } else if (tipoBusca.equals("RECOMENDACAO")) {
            try {
                alunos = alunoService.buscarAlunosPorRecomendacoes(Integer.valueOf(getTermoBusca()));
            } catch (Exception e) {
                JSFMensagens.incluirMensagemErro("Digite um valor numerico!");
                alunos = alunoService.listarTodos();
            }
        } else if (tipoBusca.equals("PALAVRA_CHAVE")) {
            alunos = alunoService.buscarAlunosPorCompetencias(getTermoBusca());
        }
    }

    public String getTipoBusca() {
        return tipoBusca;
    }

    public void setTipoBusca(String tipoBusca) {
        this.tipoBusca = tipoBusca;
    }

    public String getTermoBusca() {
        return termoBusca;
    }

    public void setTermoBusca(String termoBusca) {
        this.termoBusca = termoBusca;
    }
}
