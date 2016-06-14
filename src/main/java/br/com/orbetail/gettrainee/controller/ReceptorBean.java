package br.com.orbetail.gettrainee.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

/**
 * @author heitor
 * @since 13/06/16.
 */
@ManagedBean
@RequestScoped
public class ReceptorBean {
    private ExternalContext context = FacesContext.getCurrentInstance()
            .getExternalContext();
    private Flash flash;

    public Object putInFlash(String key, Object value) {
        return getFlash().put(key, value);
    }

    public Object getFromFlash(Object key) {
        return getFlash().get(key);
    }

    public Flash getFlash() {
        if (flash == null)
            flash = context.getFlash();
        return flash;
    }

}
