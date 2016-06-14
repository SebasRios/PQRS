/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.controller;

import com.airline.logica.DepartamentoFacadeLocal;
import com.airline.logica.PersonalFacadeLocal;
import com.airline.logica.PqrsFacadeLocal;
import com.airline.modelo.Personal;
import com.airline.modelo.Pqrs;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author brian
 */
public class personalBean implements Serializable {
  //Inyeccion

  @EJB
  private DepartamentoFacadeLocal departamentoFacade;
  @EJB
  private PersonalFacadeLocal personalFacade;
  @EJB
  private PqrsFacadeLocal pqrsFacade;

  //Definición de atributos de la vista
  private String tipoDocumento;
  private String numeroDocumento;
  private String nombres;
  private String apellidos;
  private String telefono;
  private String correoElectronico;
  private String contrasena;
  private String codigoDepartamento;

  private String codigo;

  private List<Pqrs> pqrs;

  private Personal personal;

  // Manejo de errores
  private String error;

  // Crear una nueva instancia de personalBean
  public personalBean() {
  }

  public DepartamentoFacadeLocal getDepartamentoFacade() {
    return departamentoFacade;
  }

  public void setDepartamentoFacade(DepartamentoFacadeLocal departamentoFacade) {
    this.departamentoFacade = departamentoFacade;
  }

  public PersonalFacadeLocal getPersonalFacade() {
    return personalFacade;
  }

  public void setPersonalFacade(PersonalFacadeLocal personalFacade) {
    this.personalFacade = personalFacade;
  }

  public PqrsFacadeLocal getPqrsFacade() {
    return pqrsFacade;
  }

  public void setPqrsFacade(PqrsFacadeLocal pqrsFacade) {
    this.pqrsFacade = pqrsFacade;
  }

  public String getTipoDocumento() {
    return tipoDocumento;
  }

  public void setTipoDocumento(String tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
  }

  public String getNumeroDocumento() {
    return numeroDocumento;
  }

  public void setNumeroDocumento(String numeroDocumento) {
    this.numeroDocumento = numeroDocumento;
  }

  public String getNombres() {
    return nombres;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getCorreoElectronico() {
    return correoElectronico;
  }

  public void setCorreoElectronico(String correoElectronico) {
    this.correoElectronico = correoElectronico;
  }

  public String getContrasena() {
    return contrasena;
  }

  public void setContrasena(String contrasena) {
    this.contrasena = contrasena;
  }

  public String getCodigoDepartamento() {
    return codigoDepartamento;
  }

  public void setCodigoDepartamento(String codigoDepartamento) {
    this.codigoDepartamento = codigoDepartamento;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public List<Pqrs> getPqrs() {
    return pqrs;
  }

  public void setPqrs(List<Pqrs> prqs) {
    this.pqrs = prqs;
  }

  public Personal getPersonal() {
    return personal;
  }

  public void setPersonal(Personal personal) {
    this.personal = personal;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public void inicioSesion() {
    Personal p = this.personalFacade.login(correoElectronico);

    if (p != null) {
      if (p.getContraseña().equals(contrasena)) {
        personal = p;

        pqrs = pqrsFacade.findAll();

        error = "";
      } else {
        error = "La contraseña no coincide.";
      }
    } else {
      error = "No existe el personal con ese correo electronico.";
    }
  }

  public void cerrarSesion() {
    tipoDocumento = "";
    numeroDocumento = "";
    nombres = "";
    apellidos = "";
    telefono = "";
    correoElectronico = "";
    codigoDepartamento = "";
    personal = null;
    pqrs = null;
    codigo = "";
    error = "";
  }

}
