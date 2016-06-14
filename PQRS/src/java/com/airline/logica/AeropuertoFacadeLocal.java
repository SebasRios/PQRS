/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.logica;

import com.airline.modelo.Aeropuerto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author brian
 */
@Local
public interface AeropuertoFacadeLocal {

    void create(Aeropuerto aeropuerto);

    void edit(Aeropuerto aeropuerto);

    void remove(Aeropuerto aeropuerto);

    Aeropuerto find(Object id);

    List<Aeropuerto> findAll();

    List<Aeropuerto> findRange(int[] range);

    int count();
    
}
