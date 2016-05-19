package br.com.orbetail.gettrainee.controller;

import br.com.orbetail.gettrainee.model.Universidade;
import br.com.orbetail.gettrainee.modelbuilder.UniversidadeBuilder;
import br.com.orbetail.gettrainee.service.UniversidadeService;
import br.com.orbetail.gettrainee.util.ValidadorCollection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;

/**
 * @author heitor
 * @since 18/05/16.
 */
@ManagedBean
public class UniversidadeController {
    private UniversidadeBuilder universidadeBuilder = new UniversidadeBuilder();
    private List<Universidade> universidades;

    @ManagedProperty(value = "#{universidadeService}")
    private UniversidadeService universidadeService;

    /**
     * @param universidadeService:UniversidadeService
     */
    public void setUniversidadeService(UniversidadeService universidadeService) {
        this.universidadeService = universidadeService;
    }

    public Universidade getUniversidade() {
        return universidadeBuilder.get();
    }

    public List<Universidade> getUniversidades() {
        if (ValidadorCollection.isListNotNullOrEmpty.validar(universidades))
            return universidades;
        universidades = universidadeService.listarTodos();
        return universidades;
    }
}
