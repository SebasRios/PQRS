/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.logica;

import com.airline.modelo.Anexo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author brian
 */
@Local
public interface AnexoFacadeLocal {

    void create(Anexo anexo);

    void edit(Anexo anexo);

    void remove(Anexo anexo);

    Anexo find(Object id);

    List<Anexo> findAll();

    List<Anexo> findRange(int[] range);

    int count();
    
    List<Anexo> findByPQRS(String codigo);
    
}
