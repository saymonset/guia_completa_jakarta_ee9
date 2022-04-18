package org.aguzman.webapp.jsf3;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.context.FacesContext;

@ApplicationScoped
public class ProducerResources {

    @Produces
    @RequestScoped
    /*Creamos el FacesContext para os mensajes tipo flash*/
    public FacesContext beanFacesContext() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().getFlash().setKeepMessages(true);
        return facesContext;
    }
}
