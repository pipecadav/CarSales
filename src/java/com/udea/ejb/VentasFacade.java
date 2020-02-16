/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.entity.Ventas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jefry
 */
@Stateless
public class VentasFacade extends AbstractFacade<Ventas> implements VentasFacadeLocal {

    @PersistenceContext(unitName = "CarSalesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentasFacade() {
        super(Ventas.class);
    }
    
    @Override
    public boolean existID(int id) {
        Query q = em.createQuery("select a from Ventas a "
                + "where a.id=:id");
        
        q.setParameter("id", id);
        
        
        return q.getResultList().size()>0;
    }
    
}
