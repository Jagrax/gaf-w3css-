package gaf.controller;

import gaf.entity.Estado;
import gaf.service.EstadoService;
import gaf.util.Estados;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@ManagedBean(name = "commonController")
public class CommonController {

    @EJB private EstadoService estadoService;
    private List<Estado> lstAllEstados;
    private List<Estado> lstTalleresEstados;
    private List<Estado> lstCortesAllEstados;

    @PostConstruct
    public void init() {
        lstAllEstados = new ArrayList<>();
        for (Estados estados : Estados.values()) {
            Estado e = new Estado();
            e.setId(estados.getId());
            e.setName(estados.getName());
            e.setColor(estados.getColor());
            lstAllEstados.add(e);
        }

        lstTalleresEstados = new ArrayList<>();
        for (Estados estados : Estados.values()) {
            if (estados.getEntity().equals("TALLER")) {
                Estado e = new Estado();
                e.setId(estados.getId());
                e.setName(estados.getName());
                e.setColor(estados.getColor());
                lstTalleresEstados.add(e);
            }
        }

        lstCortesAllEstados = new ArrayList<>();
        for (Estados estados : Estados.values()) {
            if (estados.getEntity().equals("CORTE")) {
                Estado e = new Estado();
                e.setId(estados.getId());
                e.setName(estados.getName());
                e.setColor(estados.getColor());
                lstCortesAllEstados.add(e);
            }
        }
    }

    /**
     * Devuelve un object Estado correspondiente al id
     */
    public Estado getEstado(Integer id) {
        return estadoService.find(id);
    }

    /**
     * Devuelve los estilos para generar una caja con los colores
     * correspondientes al estado del taller/corte
     */
    public String getStyleClassForEstado(Integer idEstado) {
        Estado e = estadoService.find(idEstado);
        if (e != null) {
            return "w3-block w3-center w3-" + e.getColor();
        }
        return "";
    }

    public List<Estado> getLstAllEstados() {
        return lstAllEstados;
    }

    public List<Estado> getLstTalleresEstados() {
        return lstTalleresEstados;
    }

    public List<Estado> getLstCortesAllEstados() {
        return lstCortesAllEstados;
    }
}
