package gaf.controller;

import gaf.entity.Taller;
import gaf.service.TallerService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class TestController {

    private List<Taller> lstTalleres;
    @Inject private TallerService tallerService;

    @PostConstruct
    public void init() {
        lstTalleres = tallerService.findAll();
    }

    public List<Taller> getLstTalleres() {
        return lstTalleres;
    }

    public void setLstTalleres(List<Taller> lstTalleres) {
        this.lstTalleres = lstTalleres;
    }
}
