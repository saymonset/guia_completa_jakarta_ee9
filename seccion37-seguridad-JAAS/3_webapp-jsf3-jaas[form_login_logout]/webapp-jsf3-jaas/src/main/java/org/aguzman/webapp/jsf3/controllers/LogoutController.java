package org.aguzman.webapp.jsf3.controllers;

import jakarta.enterprise.inject.Model;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

@Model
public class LogoutController {

    @Inject
    private FacesContext facesContext;

    public String logout() throws ServletException {

        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        /*Con estos dos 100% cerramos la session*/
        /*Elimina todo lo que es http  relacionado a autenticacion*/
        request.logout();
        /*Aseguramos eliminar la session completa que se usa para carritos de compra o sessiones del usuario, eliminarlas*/
        request.getSession().invalidate();
        /*MENSAJE FLASH*/
        facesContext.addMessage(null, new FacesMessage("Haz cerrado sesión con éxito!"));
        return "login.xhtml";
    }
}
