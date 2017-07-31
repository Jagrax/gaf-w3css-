package gaf.controller;

import gaf.entity.Corte;
import gaf.service.CorteService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Model
public class CorteController {

    @Inject
    private FacesContext facesContext;

    @Inject
    private CorteService corteService;

    @Produces
    @Named
    private Corte newCorte;

    @PostConstruct
    public void init() {
        newCorte = new Corte();
    }

    public void create() throws Exception {
        try {
            corteService.create(newCorte);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
            facesContext.addMessage(null, m);
        } catch (Exception e) {
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Registration unsuccessful");
            facesContext.addMessage(null, m);
        }
    }

}
