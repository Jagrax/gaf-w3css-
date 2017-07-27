package gaf.service;

import gaf.entity.Estado;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

@Stateless
public class EstadoService {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    public void create(Estado estado) throws Exception {
        /*
        Estado estado = new Estado();
        estado.setName("En producción");
        estado.setColor("#FFA500");
        */
        log.info("Registering " + estado.getName());
        em.persist(estado);
    }

}
