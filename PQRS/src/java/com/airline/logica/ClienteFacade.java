/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.logica;

import com.airline.modelo.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author brian
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeLocal {

    @PersistenceContext(unitName = "PQRSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

  @Override
  public Cliente login(String email) {
    List<Cliente> p = em.createNamedQuery("Cliente.findByCorreoElectronico", Cliente.class)
                .setParameter("correoElectronico", email)
                .getResultList();
         
        if (p.isEmpty()) {
            return null;
        } else {
            return p.get(0);
        }
  }
    
}
