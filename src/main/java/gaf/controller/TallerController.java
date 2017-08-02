package gaf.controller;

import gaf.entity.Estado;
import gaf.entity.Taller;
import gaf.service.EstadoService;
import gaf.service.TallerService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Model
public class TallerController implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Taller> lstTalleres;
    private Taller taller = new Taller();
    private Taller beforeEditTaller = null;
    private boolean editable;

    @Inject private FacesContext facesContext;
    @Inject private TallerService tallerService;
    @Inject private EstadoService estadoService;

    @Produces
    @Named
    private Taller newTaller;

    private List<Estado> estados;

    @PostConstruct
    public void init() {
        lstTalleres = tallerService.findAll();
    }

    public void add() {
        try {
            tallerService.create(taller);
            lstTalleres.add(taller);
            taller = new Taller();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resetAdd() {
        taller = new Taller();
    }

    public void edit(Taller taller) {
        beforeEditTaller = taller;
        this.taller = taller;
        editable = true;
    }

    public void cancelEdit() {
        this.taller = beforeEditTaller;
        this.taller = new Taller();
        editable = false;
    }

    public void guardarEdicion() {
        try {
            System.out.println("Guardando taller " + taller.toString());
            tallerService.update(taller);
            this.taller = new Taller();
            editable = false;
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Taller taller) throws IOException {
        tallerService.delete(taller);
        lstTalleres.remove(taller);
    }

    public List<Taller> getLstTalleres() {
        return lstTalleres;
    }

    public Taller getTaller() {
        return this.taller;
    }

    public boolean isEditable() {
        return this.editable;
    }
/*
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
*/
}
