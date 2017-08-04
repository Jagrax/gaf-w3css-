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

    public void create(Estado estado) {
        log.info("Registering " + estado.getName());
        em.persist(estado);
    }

    public List<Estado> findAll() {
        return em.createQuery("from Estado").getResultList();
    }

    public void delete(Estado estado) {
        log.info("Deleting " + estado.getName());
        em.remove(em.contains(estado) ? estado : em.merge(estado));
    }

    public void update(Estado estado) {
        em.merge(estado);
    }

    public Estado find(Integer estadoId) {
        return em.find(Estado.class, estadoId);
    }
}
