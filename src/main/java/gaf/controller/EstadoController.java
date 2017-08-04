package gaf.controller;

import gaf.entity.Estado;
import gaf.service.EstadoService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class EstadoController {

    private List<Estado> lstEstados;
    private Estado estado;
    @Inject private EstadoService estadoService;

    @PostConstruct
    public void init() {
        lstEstados = estadoService.findAll();
        estado = new Estado();
    }

    public List<Estado> getLstEstados() {
        return lstEstados;
    }

    public void setLstEstados(List<Estado> lstEstados) {
        this.lstEstados = lstEstados;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    // CRUD Methods
    public void create() {
        estadoService.create(estado);
        lstEstados.add(estado);
        estado = new Estado();
    }

    public void update() {

    }

    public void delete(Estado estado) {
        estadoService.delete(estado);
        lstEstados.remove(estado);
    }
}
