package br.com.orbetail.gettrainee.controller;

import br.com.orbetail.gettrainee.model.Aluno;
import br.com.orbetail.gettrainee.model.Endereco;
import br.com.orbetail.gettrainee.model.Usuario;
import br.com.orbetail.gettrainee.modelbuilder.EnderecoBuilder;
import br.com.orbetail.gettrainee.service.UsuarioService;
import br.com.orbetail.gettrainee.util.ValidadorCollection;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @author heitor
 * @since 18/05/16.
 */
@ManagedBean
public class UsuarioController {
    private EnderecoBuilder enderecoBuilder = new EnderecoBuilder();
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


    public StreamedContent getImage() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        } else {
            // So, browser is requesting the image. Return a real StreamedContent with the image bytes;
            String nome = context.getExternalContext().getRequestParameterMap().get("usuarioNome");
            Usuario usuario = usuarioService.buscarUsuarioPorNome(nome);

            InputStream stream = new ByteArrayInputStream(usuario.getImage());
            return new DefaultStreamedContent(stream);
        }

    }
}
