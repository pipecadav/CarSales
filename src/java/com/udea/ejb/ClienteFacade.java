
package com.udea.ejb;

import com.udea.entity.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeLocal {

    @PersistenceContext(unitName = "CarSalesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }
    
    @Override
    public boolean existID(int id) {
        Query q = em.createQuery("select a from Cliente a "
                + "where a.id=:id");
        
        q.setParameter("id", id);
        
        
        return q.getResultList().size()>0;
    }
    
}
