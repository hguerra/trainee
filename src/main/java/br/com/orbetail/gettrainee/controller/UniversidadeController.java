package br.com.orbetail.gettrainee.controller;

import br.com.orbetail.gettrainee.model.Universidade;
import br.com.orbetail.gettrainee.modelbuilder.UniversidadeBuilder;
import br.com.orbetail.gettrainee.service.UniversidadeService;
import br.com.orbetail.gettrainee.util.JSFMensagens;
import br.com.orbetail.gettrainee.util.ValidadorCollection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * @author heitor
 * @since 18/05/16.
 */
@ManagedBean
public class UniversidadeController {
    private String termoBusca;
    private String tipoBusca;
    private List<Universidade> universidades;

    @ManagedProperty(value = "#{universidadeService}")
    private UniversidadeService universidadeService;

    /**
     * @param universidadeService:UniversidadeService
     */
    public void setUniversidadeService(UniversidadeService universidadeService) {
        this.universidadeService = universidadeService;
    }

    public void buscar() {
        if (tipoBusca.equals("TODOS")) {
            universidades = universidadeService.listarTodos();
        } else if (tipoBusca.equals("CURSO")) {
            try {
                universidades = universidadeService.buscarUniversidadePorCursoDescricao(tipoBusca);
            } catch (Exception e) {
                JSFMensagens.incluirMensagemErro("Erro ao buscar termo!");
                universidades = universidadeService.listarTodos();
            }
        }
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

    public List<Universidade> getUniversidades() {
        return universidades;
    }

    public void setUniversidades(List<Universidade> universidades) {
        this.universidades = universidades;
    }
}
