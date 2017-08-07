package gaf.controller;

import gaf.entity.Estado;
import gaf.entity.Estados;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import java.util.ArrayList;
import java.util.List;

@Model
public class EstadoController {

    private List<Estado> lstEstados;

    @PostConstruct
    public void init() {
        //lstEstados = estadoService.findAll();
        lstEstados = new ArrayList<>();
        for (Estados e : Estados.values()) {
            Estado estado = new Estado();
            estado.setId(e.getId());
            estado.setName(e.getName());
            estado.setColor(e.getColor());
            lstEstados.add(estado);
        }
    }

    public List<Estado> getLstEstados() {
        return lstEstados;
    }

    public void setLstEstados(List<Estado> lstEstados) {
        this.lstEstados = lstEstados;
    }
}
