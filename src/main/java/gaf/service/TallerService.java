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

    public List<Taller> findAll() {
        List<Taller> result;
        try {
            result = em.createQuery("from Taller").getResultList();
        } catch (Exception e) {
            log.info("Se produjo un error al buscar todos los talleres. " + e.getMessage());
            result = new ArrayList<>();
        }
        return result;
    }

    public void delete(Taller taller) {
        log.info("Eliminando el taller " + taller.getName() + "[id=" + taller.getId() + "]");
        em.remove(em.contains(taller) ? taller : em.merge(taller));
    }

    public void update(Taller taller) {
        em.merge(taller);
    }
}
