/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.logica;

import com.airline.modelo.Personal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author brian
 */
@Stateless
public class PersonalFacade extends AbstractFacade<Personal> implements PersonalFacadeLocal {

    @PersistenceContext(unitName = "PQRSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonalFacade() {
        super(Personal.class);
    }

    @Override
    public Personal login(String email) {
        List<Personal> p = em.createNamedQuery("Personal.findByCorreoElectronico", Personal.class)
                .setParameter("correoElectronico", email)
                .getResultList();
         
        if (p.isEmpty()) {
            return null;
        } else {
            return p.get(0);
        }
    }
}
