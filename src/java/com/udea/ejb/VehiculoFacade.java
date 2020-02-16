
package com.udea.ejb;

import com.udea.entity.Vehiculo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class VehiculoFacade extends AbstractFacade<Vehiculo> implements VehiculoFacadeLocal {

    @PersistenceContext(unitName = "CarSalesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculoFacade() {
        super(Vehiculo.class);
    }

    @Override
    public boolean existID(int id) {
        Query q = em.createQuery("select a from Vehiculo a "
                + "where a.vehiculoPK.id=:id");

        q.setParameter("id", id);

        return q.getResultList().size() > 0;
    }
    
    @Override
    public boolean existPlaca(String placa) {
        Query q = em.createQuery("select a from Vehiculo a "
                + "where a.placa=:placa");

        q.setParameter("placa", placa);

        return q.getResultList().size() > 0;
    }
    
     @Override
    public boolean existMatricula(int matricula) {
        Query q = em.createQuery("select a from Vehiculo a "
                + "where a.vehiculoPK.matricula=:matricula");

        q.setParameter("matricula", matricula);

        return q.getResultList().size() > 0;
    }
}
