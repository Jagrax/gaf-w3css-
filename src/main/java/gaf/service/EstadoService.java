package gaf.service;

import gaf.entity.Estado;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class EstadoService {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    public void create(Estado estado) throws Exception {
        log.info("Registering " + estado.getName());
        em.persist(estado);
    }

    public List<Estado> findAll() throws Exception {
        return em.createQuery("from Estado").getResultList();
    }

}
