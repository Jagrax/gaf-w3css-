package gaf.service;

import gaf.entity.Corte;
import gaf.entity.Estado;

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

    @Inject
    private TallerService tallerService;

    public void create(Corte corte) throws Exception {
        Estado enProduccion = (Estado) em.createQuery("from Estado where name = 'En produccion'").getSingleResult();
        Integer estadoId = enProduccion.getId();
        if (estadoId == null) estadoId = 0;
        corte.setEstadoId(estadoId);
        // Inicialmente, no se entrego ninguna prenda
        corte.setClothesDelivered(0);
        em.persist(corte);
        log.info("El corte '" + corte.getName() + "' ha sido registrado correctamente.");

        // Una vez que el corte fue dado de alta, tengo que poner al taller en estado 'En produccion'
        tallerService.updateEstado(corte.getTallerId(), estadoId);
    }

}
