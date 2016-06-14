package br.com.orbetail.gettrainee.controller;

import br.com.orbetail.gettrainee.model.Empresa;
import br.com.orbetail.gettrainee.modelbuilder.EmpresaBuilder;
import br.com.orbetail.gettrainee.service.EmpresaService;
import br.com.orbetail.gettrainee.util.JSFMensagens;
import br.com.orbetail.gettrainee.util.ValidadorCollection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author heitor
 * @since 19/05/16.
 */
@ManagedBean
public class EmpresaController {
    private String termoBusca;
    private String tipoBusca;
    private List<Empresa> empresas;

    @ManagedProperty(value = "#{empresaService}")
    private EmpresaService empresaService;


    public void buscar() {
        if (tipoBusca.equals("TODOS")) {
            empresas = empresaService.listarTodos();
        } else if (tipoBusca.equals("ESPECIALIZACAO")) {
            try {
                empresas = new ArrayList<>(empresaService.buscarEmpresasPorEspecializacao(termoBusca));
            } catch (Exception e) {
                JSFMensagens.incluirMensagemErro("Erro ao buscar termo!");
                empresas = empresaService.listarTodos();
            }
        }
    }

    /**
     * @param empresaService:EmpresaService
     */
    public void setEmpresaService(EmpresaService empresaService) {
        this.empresaService = empresaService;
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

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }
}
