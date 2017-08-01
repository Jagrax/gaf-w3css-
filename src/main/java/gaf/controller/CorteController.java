package gaf.controller;

import gaf.entity.Corte;
import gaf.entity.Taller;
import gaf.service.CorteService;
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
public class CorteController {

    @Inject
    private FacesContext facesContext;

    @Inject
    private CorteService corteService;

    @Inject
    private TallerService tallerService;

    @Produces
    @Named
    private Corte newCorte;

    private List<Taller> talleresDisponibles;

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

    public List<Taller> getTalleresDisponibles() {
        if (talleresDisponibles == null) {
            populateTalleresDisponibles();
        }
        return talleresDisponibles;
    }

    private void populateTalleresDisponibles() {
        try {
            talleresDisponibles = tallerService.findTalleresDisponibles();
        } catch (Exception e) {
            System.err.println("Se produjo un error al buscar los estados. " + e.getMessage());
        }
    }

}
