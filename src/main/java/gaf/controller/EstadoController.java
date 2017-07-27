package gaf.controller;

import gaf.entity.Estado;
import gaf.service.EstadoService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Model
public class EstadoController {

    @Inject
    private FacesContext facesContext;

    @Inject
    private EstadoService estadoService;

    @Produces
    @Named
    private Estado newEstado;

    @PostConstruct
    public void initNewEstado() {
        newEstado = new Estado();
    }

    public void create() throws Exception {
        try {
            estadoService.create(newEstado);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
            facesContext.addMessage(null, m);
        } catch (Exception e) {
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Registration unsuccessful");
            facesContext.addMessage(null, m);
        }
    }

}
