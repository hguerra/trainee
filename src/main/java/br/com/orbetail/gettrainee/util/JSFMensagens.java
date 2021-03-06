package br.com.orbetail.gettrainee.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * @author heitor
 * @since 18/05/16.
 */
public class JSFMensagens {
    public static void incluirMensagemErro(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem,
                mensagem));
    }

    public static void incluirMensagemAviso(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem,
                mensagem));
    }

    public static void incluirMensagemInfo(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem,
                mensagem));
    }

    public static String recuperarCausa(Throwable t) {
        Throwable causa = t;
        while (causa.getCause() != null) {
            causa = causa.getCause();
        }
        return causa.getMessage();
    }
}
