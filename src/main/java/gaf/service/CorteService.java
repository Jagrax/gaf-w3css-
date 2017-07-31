package gaf.service;

import gaf.entity.Corte;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

@Stateless
public class CorteService {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    public void create(Corte corte) throws Exception {
        em.persist(corte);
        log.info("El corte '" + corte.getName() + "' ha sido registrado correctamente.");
    }

}
