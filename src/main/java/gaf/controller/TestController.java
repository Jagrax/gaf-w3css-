package gaf.controller;

import gaf.entity.Estado;
import gaf.entity.Taller;
import gaf.service.EstadoService;
import gaf.service.TallerService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ViewScoped
@ManagedBean(name = "testController")
public class TestController {

    private List<Taller> lstTalleres;
    private Taller taller;

    @EJB
    private TallerService tallerService;

    @EJB
    private EstadoService estadoService;

    @PostConstruct
    public void init() {
        lstTalleres = tallerService.findAll();
        taller = new Taller();
    }

    public List<Taller> getLstTalleres() {
        return lstTalleres;
    }

    public void setLstTalleres(List<Taller> lstTalleres) {
        this.lstTalleres = lstTalleres;
    }

    public Taller getTaller() {
        return taller;
    }

    public void setTaller(Taller taller) {
        this.taller = taller;
    }

    public Estado getEstado(Integer id) {
        return estadoService.find(id);
    }

    public String getColorForRow() {
        StringBuilder result = new StringBuilder();
        String coma = "";
        for (Taller t : lstTalleres) {
            result.append(coma + "w3-" + estadoService.find(t.getEstadoId()).getColor());
            coma = ",";
        }
        return result.toString();
    }

    // CRUD Methods
    public void create() {
        tallerService.create(taller);
        lstTalleres.add(taller);
        taller = new Taller();
    }

    public void delete(Taller taller) {
        tallerService.delete(taller);
        lstTalleres.remove(taller);
    }
}
