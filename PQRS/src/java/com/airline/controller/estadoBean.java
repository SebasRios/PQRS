/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.controller;

import com.airline.logica.AeropuertoFacadeLocal;
import com.airline.logica.ClienteFacadeLocal;
import com.airline.logica.DepartamentoFacadeLocal;
import com.airline.logica.EstadoFacadeLocal;
import com.airline.logica.PersonalFacadeLocal;
import com.airline.logica.PqrsFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author brian
 */
public class estadoBean implements Serializable {
    //Inyeccion
    @EJB
    private PqrsFacadeLocal pqrsFacade;
    @EJB
    private AeropuertoFacadeLocal aeropuertoFacade;
    @EJB
    private DepartamentoFacadeLocal departamentoFacade;
    @EJB
    private PersonalFacadeLocal personalFacade;
    @EJB
    private ClienteFacadeLocal clienteFacade;
    @EJB
    private EstadoFacadeLocal estadoFacade;

    //Definición de atributos de la vista
    private String codigo;
    private String estado;
    private String [] fecha;
    private String numeroDocPersonal;
    private String tipoDocPersonal;
    private String descripcion;
    private String codigoPQRS;
    // Crear una nueva instancia de estadoBean
    public estadoBean() {
    }

    public PqrsFacadeLocal getPqrsFacade() {
        return pqrsFacade;
    }

    public void setPqrsFacade(PqrsFacadeLocal pqrsFacade) {
        this.pqrsFacade = pqrsFacade;
    }

    public AeropuertoFacadeLocal getAeropuertoFacade() {
        return aeropuertoFacade;
    }

    public void setAeropuertoFacade(AeropuertoFacadeLocal aeropuertoFacade) {
        this.aeropuertoFacade = aeropuertoFacade;
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

    public ClienteFacadeLocal getClienteFacade() {
        return clienteFacade;
    }

    public void setClienteFacade(ClienteFacadeLocal clienteFacade) {
        this.clienteFacade = clienteFacade;
    }

    public EstadoFacadeLocal getEstadoFacade() {
        return estadoFacade;
    }

    public void setEstadoFacade(EstadoFacadeLocal estadoFacade) {
        this.estadoFacade = estadoFacade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String[] getFecha() {
        return fecha;
    }

    public void setFecha(String[] fecha) {
        this.fecha = fecha;
    }

    public String getNumeroDocPersonal() {
        return numeroDocPersonal;
    }

    public void setNumeroDocPersonal(String numeroDocPersonal) {
        this.numeroDocPersonal = numeroDocPersonal;
    }

    public String getTipoDocPersonal() {
        return tipoDocPersonal;
    }

    public void setTipoDocPersonal(String tipoDocPersonal) {
        this.tipoDocPersonal = tipoDocPersonal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoPQRS() {
        return codigoPQRS;
    }

    public void setCodigoPQRS(String codigoPQRS) {
        this.codigoPQRS = codigoPQRS;
    }
    
}
