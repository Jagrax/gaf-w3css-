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
import java.util.List;

@Model
public class EstadoController {

    @Inject
    private FacesContext facesContext;

    @Inject
    private EstadoService estadoService;

    @Produces
    @Named
    private Estado newEstado;
    private List<Estado> allEstados;

    @PostConstruct
    public void initNewEstado() {
        newEstado = new Estado();
    }

    public void create() throws Exception {
        try {
            estadoService.create(newEstado);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Estado '" + newEstado.getName() + "' creado correctamente.", "El estado " + newEstado.getName() + "(" + newEstado.getColor() + ") fue creado correctamente.");
            facesContext.addMessage(null, m);
            newEstado = new Estado();
            populateAllEstados();
        } catch (Exception e) {
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Registration unsuccessful");
            facesContext.addMessage(null, m);
        }
    }

    public void editEstado(Estado estado, boolean save) {
        try {
            if (save) {
                estadoService.update(newEstado);
                populateAllEstados();
            } else {
                newEstado = estado;
            }
        } catch (Exception e) {

        }
    }

    public void deleteEstado(Estado estado) throws Exception {
        try {
            estadoService.delete(estado);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Estado '" + estado.getName() + "' eliminado correctamente.", "El estado " + estado.getName() + "(" + estado.getId() + ") fue eliminado correctamente.");
            facesContext.addMessage(null, m);
            populateAllEstados();
        } catch (Exception e) {
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Registration unsuccessful");
            facesContext.addMessage(null, m);
        }
    }

    public List<Estado> getAllEstados() {
        if (allEstados == null) {
            populateAllEstados();
        }
        return allEstados;
    }

    private void populateAllEstados() {
        try {
            allEstados = estadoService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAllEstados(List<Estado> allEstados) {
        this.allEstados = allEstados;
    }
}
