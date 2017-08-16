package gaf.controller;

import gaf.entity.Taller;
import gaf.service.TallerService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ViewScoped
@ManagedBean(name = "tallerController")
public class TallerController {

    private List<Taller> lstTalleres;
    private Taller taller;
    @EJB private TallerService tallerService;

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
