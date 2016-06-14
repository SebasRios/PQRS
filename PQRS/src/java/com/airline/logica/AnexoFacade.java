/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.logica;

import com.airline.modelo.Anexo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author brian
 */
@Stateless
public class AnexoFacade extends AbstractFacade<Anexo> implements AnexoFacadeLocal {

    @PersistenceContext(unitName = "PQRSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnexoFacade() {
        super(Anexo.class);
    }

    @Override
    public List<Anexo> findByPQRS(String codigo) {
        return em.createNamedQuery("Anexo.findByCodigoRelacion").setParameter("codigoRelacion", codigo).getResultList();
    }
}
