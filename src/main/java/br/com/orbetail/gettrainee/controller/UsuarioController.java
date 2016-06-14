package br.com.orbetail.gettrainee.controller;

import br.com.orbetail.gettrainee.model.Endereco;
import br.com.orbetail.gettrainee.model.Usuario;
import br.com.orbetail.gettrainee.modelbuilder.EnderecoBuilder;
import br.com.orbetail.gettrainee.service.UsuarioService;
import br.com.orbetail.gettrainee.util.JSFMensagens;
import br.com.orbetail.gettrainee.util.ValidadorCollection;
import br.com.orbetail.gettrainee.util.ValidadorRegex;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @author heitor
 * @since 18/05/16.
 */
@ManagedBean
public class UsuarioController {
    private Usuario usuario = new Usuario();
    private EnderecoBuilder enderecoBuilder = new EnderecoBuilder();
    private List<Usuario> usuarios;

    @ManagedProperty(value = "#{usuarioService}")
    private UsuarioService usuarioService;

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
            String login = context.getExternalContext().getRequestParameterMap().get("usuarioLogin");
            Usuario usuario = usuarioService.buscarUsuarioPorLogin(login);

            InputStream stream = new ByteArrayInputStream(usuario.getImage());
            return new DefaultStreamedContent(stream);
        }

    }

    public String cadastrarUsuario() {
        boolean isloginExistente = usuarioService.isLoginExistente(usuario.getLogin());
        if (isloginExistente) {
            JSFMensagens.incluirMensagemErro("Login ja existente!");
            return null;
        }
        if (!ValidadorRegex.email.validar(usuario.getEmail())) {
            JSFMensagens.incluirMensagemErro("Não é um email valido!");
            return null;
        }
        try{
            usuarioService.salvar(usuario);
            return "/index?faces-redirect=true";
        }catch (Exception e){
            System.err.println(e);
            JSFMensagens.incluirMensagemErro("Falha em cadastrar novo usuário!");
        }
        return null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
