package br.com.orbetail.gettrainee.controller;

import br.com.orbetail.gettrainee.model.Empresa;
import br.com.orbetail.gettrainee.modelbuilder.EmpresaBuilder;
import br.com.orbetail.gettrainee.service.EmpresaService;
import br.com.orbetail.gettrainee.util.ValidadorCollection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;

/**
 * @author heitor
 * @since 19/05/16.
 */
@ManagedBean
public class EmpresaController {
    private EmpresaBuilder empresaBuilder = new EmpresaBuilder();
    private List<Empresa> empresas;

    @ManagedProperty(value = "#{empresaService}")
    private EmpresaService empresaService;

    /**
     * @param empresaService:EmpresaService
     */
    public void setEmpresaService(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    public Empresa getEmpresa() {
        return empresaBuilder.get();
    }

    public List<Empresa> getEmpresas() {
        if (ValidadorCollection.isListNotNullOrEmpty.validar(empresas))
            return empresas;
        empresas = empresaService.listarTodos();
        return empresas;
    }
}
