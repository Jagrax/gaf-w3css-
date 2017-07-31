package gaf.controller;

import gaf.entity.Estado;
import gaf.entity.Taller;
import gaf.service.EstadoService;
import gaf.service.TallerService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Model
public class TallerController {

    @Inject
    private FacesContext facesContext;

    @Inject
    private TallerService tallerService;

    @Inject
    private EstadoService estadoService;

    @Produces
    @Named
    private Taller newTaller;

    private List<Estado> estados;

    @PostConstruct
    public void init() {
        newTaller = new Taller();
    }

    public void create() throws Exception {
        try {
            tallerService.create(newTaller);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
            facesContext.addMessage(null, m);
        } catch (Exception e) {
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Registration unsuccessful");
            facesContext.addMessage(null, m);
        }
    }

    public List<Estado> getEstados() {
        if (estados == null) {
            populateEstados();
        }
        return estados;
    }

    private void populateEstados() {
        try {
            estados = estadoService.findAll();
        } catch (Exception e) {
            System.err.println("Se produjo un error al buscar los estados. " + e.getMessage());
        }
    }

}
