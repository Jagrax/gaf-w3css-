package gaf.controller;

import gaf.entity.Estado;
import gaf.entity.Taller;
import gaf.service.EstadoService;
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
    private List<Estado> lstEstados;
    private Taller taller;
    @EJB private TallerService tallerService;
    @EJB private EstadoService estadoService;

    @PostConstruct
    public void init() {
        lstTalleres = tallerService.findAll();
        lstEstados = estadoService.findAll();
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

    public String getColor(Taller taller) {
        Estado e = estadoService.find(taller.getEstadoId());
        if (e != null) {
            return "w3-block w3-center w3-" + e.getColor();
        }
        return "";
    }

    public List<Estado> getLstEstados() {
        return lstEstados;
    }

    public void setLstEstados(List<Estado> lstEstados) {
        this.lstEstados = lstEstados;
    }

    // CRUD Methods
    public void create() {
        tallerService.create(taller);
        lstTalleres.add(taller);
        taller = new Taller();
    }

    public void update() {

    }

    public void delete(Taller taller) {
        tallerService.delete(taller);
        lstTalleres.remove(taller);
    }
}
