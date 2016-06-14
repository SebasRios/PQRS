/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.services;

import com.airline.logica.EstadoFacadeLocal;
import com.airline.modelo.Estado;
import com.airline.modelo.EstadoPK;
import java.util.Date;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author santiago
 */
@WebService(serviceName = "EstadoWS")
public class EstadoWS {

  @EJB
  private EstadoFacadeLocal estadoFacade;

  @WebMethod(operationName = "IngresarEstado") //Se va a relacionar inmediatamente
  //con la exposición de ese método en el descriptor
  public String IngresarEstado(@WebParam(name = "estado") String estado, @WebParam(name = "numeroDocPersonal") String numeroDocPersonal, @WebParam(name = "tipoDocPersonal") String tipoDocPersonal, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "codigoPQRS") String codigoPQRS) {
    EstadoPK estadoPK= new EstadoPK(null, numeroDocPersonal,tipoDocPersonal,codigoPQRS);
    Estado e= new Estado(estadoPK,estado,new Date(),descripcion);
    estadoFacade.create(e);
    return "Estado Ingresado";
  }
}
