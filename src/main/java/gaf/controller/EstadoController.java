package gaf.controller;

import gaf.entity.Estado;
import gaf.service.EstadoService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ViewScoped
@ManagedBean(name = "estadoController")
public class EstadoController {

    private List<Estado> lstEstados;
    @EJB private EstadoService estadoService;

    @PostConstruct
    public void init() {
        lstEstados = estadoService.findAll();
    }

    public List<Estado> getLstEstados() {
        return lstEstados;
    }

    public void setLstEstados(List<Estado> lstEstados) {
        this.lstEstados = lstEstados;
    }
}
