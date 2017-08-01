package gaf.service;

import gaf.entity.Estado;
import gaf.entity.Taller;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class TallerService {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    public void create(Taller taller) throws Exception {
        log.info("Registering " + taller.getName());
        em.persist(taller);
    }

    public List<Taller> findTalleresDisponibles() {
        return em.createQuery("from Taller where estado = (select id from Estado where name = 'Disponible')").getResultList();
    }

    public void updateEstado(Long tallerId, Integer estadoId) {
        Taller taller = em.find(Taller.class, tallerId);
        taller.setEstadoId(estadoId);
        em.merge(taller);
    }
}
