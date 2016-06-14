package br.com.orbetail.gettrainee.controller;

import br.com.orbetail.gettrainee.model.Projeto;
import br.com.orbetail.gettrainee.service.ProjetoService;
import br.com.orbetail.gettrainee.util.JSFMensagens;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.time.LocalDate;
import java.util.List;

/**
 * @author heitor
 * @since 19/05/16.
 */
@ManagedBean
public class ProjetoController {
    private String termoBusca;
    private String tipoBusca;
    private String data;
    private Projeto projeto = new Projeto();
    private List<Projeto> projetos;

    @ManagedProperty(value = "#{projetoService}")
    private ProjetoService projetoService;


    @ManagedProperty(value = "#{receptorBean}")
    private ReceptorBean receptorBean;

    public void buscar() {
        if (tipoBusca.equals("TODOS")) {
            projetos = projetoService.listarTodos();
        } else if (tipoBusca.equals("NOME")) {
            projetos = projetoService.buscarProjetoPorNome(termoBusca);
        } else if (tipoBusca.equals("DESCRICAO")) {
            projetos = projetoService.buscarProjetoPorDescricao(termoBusca);
            {
            }
        } else if (tipoBusca.equals("ABERTO")) {
            projetos = projetoService.buscarProjetosRecentesEmAberto();
        }
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }


    public String salvar(Projeto projeto) {
        try {
            LocalDate dataInicio = LocalDate.parse(data, projeto.getFormatter());
            projeto.setDataInicio(dataInicio);
        } catch (Exception e) {
            JSFMensagens.incluirMensagemErro("Data invalida! (ex: 12/08/1994)");
            return null;
        }
        projetoService.salvar(projeto);
        return "/publico/buscarProjetos?faces-redirect=true";
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

    /**
     * @param projetoService:ProjetoService
     */
    public void setProjetoService(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    public void setReceptorBean(ReceptorBean receptorBean) {
        this.receptorBean = receptorBean;
    }

    public String getTermoBusca() {
        return termoBusca;
    }

    public void setTermoBusca(String termoBusca) {
        this.termoBusca = termoBusca;
    }

    public String getTipoBusca() {
        return tipoBusca;
    }

    public void setTipoBusca(String tipoBusca) {
        this.tipoBusca = tipoBusca;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
