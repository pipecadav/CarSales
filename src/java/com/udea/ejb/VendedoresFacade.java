/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.entity.Vendedores;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jefry
 */
@Stateless
public class VendedoresFacade extends AbstractFacade<Vendedores> implements VendedoresFacadeLocal {

    @PersistenceContext(unitName = "CarSalesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VendedoresFacade() {
        super(Vendedores.class);
    }

    @Override
    public boolean checkLogin(String u, String p) {
        Query q = em.createQuery("select a from Vendedores a "
                + "where a.username=:u and a.password=:p");
        
        q.setParameter("u", u);
        q.setParameter("p", p);
        
        return q.getResultList().size()>0;
    }
    
    @Override
    public boolean existUsuario(String username) {
        Query q = em.createQuery("select a from Vendedores a "
                + "where a.username=:username");

        q.setParameter("username", username);

        return q.getResultList().size() > 0;
    }
    
    @Override
    public boolean existID(int id) {
        Query q = em.createQuery("select a from Vendedores a "
                + "where a.id=:id");

        q.setParameter("id", id);

        return q.getResultList().size() > 0;
    }
    
}
