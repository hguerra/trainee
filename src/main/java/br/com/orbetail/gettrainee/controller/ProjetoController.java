package br.com.orbetail.gettrainee.controller;

import br.com.orbetail.gettrainee.model.Projeto;
import br.com.orbetail.gettrainee.service.ProjetoService;
import br.com.orbetail.gettrainee.util.ValidadorCollection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;

/**
 * @author heitor
 * @since 19/05/16.
 */
@ManagedBean
public class ProjetoController {
    private Projeto projeto = new Projeto();
    private List<Projeto> projetos;

    @ManagedProperty(value = "#{projetoService}")
    private ProjetoService projetoService;

    /**
     * @param projetoService:ProjetoService
     */
    public void setProjetoService(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    public List<Projeto> getProjetos() {
        if (ValidadorCollection.isListNotNullOrEmpty.validar(projetos))
            return projetos;
        projetos = projetoService.listarTodos();
        return projetos;
    }

    public Projeto salvar(Projeto projeto) {
        return projetoService.salvar(projeto);
    }

    public void excluir(Projeto projeto) {
        projetoService.excluir(projeto.getId());
    }

    public List<Projeto> getProjetosEmAberto() {
        return projetoService.buscarProjetosRecentesEmAberto();
    }

    public List<Projeto> getProjetosEmAbertosNovos() {
        return projetoService.buscarCincoProjetosRecentesEmAberto();
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
}
