/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.logica;

import com.airline.modelo.Pqrs;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author brian
 */
@Stateless
public class PqrsFacade extends AbstractFacade<Pqrs> implements PqrsFacadeLocal {

    @PersistenceContext(unitName = "PQRSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PqrsFacade() {
        super(Pqrs.class);
    }
    
    @Override
    public Pqrs consultar(String codigo) {
      List<Pqrs> p = em.createNamedQuery("Pqrs.findByCodigo", Pqrs.class)
              .setParameter("codigo", codigo)
              .getResultList();
      
      if (p.isEmpty()) {
        return null;
      } else {
        return p.get(0);
      }
    }
    
}
