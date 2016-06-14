/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.logica;

import com.airline.modelo.Estado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author brian
 */
@Local
public interface EstadoFacadeLocal {

    void create(Estado estado);

    void edit(Estado estado);

    void remove(Estado estado);

    Estado find(Object id);

    List<Estado> findAll();

    List<Estado> findRange(int[] range);

    int count();
    
    List<Estado> findByPQRS(String codigo);
    
}
