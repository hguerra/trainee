package br.com.orbetail.gettrainee.controller;

import br.com.orbetail.gettrainee.model.Endereco;
import br.com.orbetail.gettrainee.model.Usuario;
import br.com.orbetail.gettrainee.modelbuilder.EnderecoBuilder;
import br.com.orbetail.gettrainee.service.UsuarioService;
import br.com.orbetail.gettrainee.util.ValidadorCollection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;

/**
 * @author heitor
 * @since 18/05/16.
 */
@ManagedBean
public class UsuarioController {
    EnderecoBuilder enderecoBuilder = new EnderecoBuilder();
    private List<Usuario> usuarios;

    @ManagedProperty(value = "#{usuarioService}")
    private UsuarioService usuarioService;

    /**
     * @param usuarioService:UsuarioService
     */
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public Endereco getEndereco() {
        return enderecoBuilder.get();
    }

    public List<Usuario> getUsuarios() {
        if (ValidadorCollection.isListNotNullOrEmpty.validar(usuarios))
            return usuarios;
        usuarios = usuarioService.listarTodos();
        return usuarios;
    }
}
