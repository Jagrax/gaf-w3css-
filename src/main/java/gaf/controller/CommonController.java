package gaf.controller;

import gaf.entity.Estado;
import gaf.service.EstadoService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "commonController")
public class CommonController {

    @EJB private EstadoService estadoService;

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

}
