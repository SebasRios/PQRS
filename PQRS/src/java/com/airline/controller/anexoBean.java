/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.controller;

import com.airline.logica.AeropuertoFacadeLocal;
import com.airline.logica.AnexoFacadeLocal;
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
public class anexoBean implements Serializable {
    //Inyección
    @EJB
    private PqrsFacadeLocal pqrsFacade;
    @EJB
    private PersonalFacadeLocal personalFacade;
    @EJB
    private EstadoFacadeLocal estadoFacade;
    @EJB
    private DepartamentoFacadeLocal departamentoFacade;
    @EJB
    private ClienteFacadeLocal clienteFacade;
    @EJB
    private AnexoFacadeLocal anexoFacade;
    @EJB
    private AeropuertoFacadeLocal aeropuertoFacade;

    //Definición de atributos de la vista
    private String codigo;
    private byte[] path; //Para guardar una imagen o un documento
    private String tipoAnexo; //Imagen o Documento
    private String codigoRelacion; //Dicta si el anexo pertenece a una PQRS o a un estado
                   
    // Crear una nueva instancia de anexoBean
    public anexoBean() {
    }

    public PqrsFacadeLocal getPqrsFacade() {
        return pqrsFacade;
    }

    public void setPqrsFacade(PqrsFacadeLocal pqrsFacade) {
        this.pqrsFacade = pqrsFacade;
    }

    public PersonalFacadeLocal getPersonalFacade() {
        return personalFacade;
    }

    public void setPersonalFacade(PersonalFacadeLocal personalFacade) {
        this.personalFacade = personalFacade;
    }

    public EstadoFacadeLocal getEstadoFacade() {
        return estadoFacade;
    }

    public void setEstadoFacade(EstadoFacadeLocal estadoFacade) {
        this.estadoFacade = estadoFacade;
    }

    public DepartamentoFacadeLocal getDepartamentoFacade() {
        return departamentoFacade;
    }

    public void setDepartamentoFacade(DepartamentoFacadeLocal departamentoFacade) {
        this.departamentoFacade = departamentoFacade;
    }

    public ClienteFacadeLocal getClienteFacade() {
        return clienteFacade;
    }

    public void setClienteFacade(ClienteFacadeLocal clienteFacade) {
        this.clienteFacade = clienteFacade;
    }

    public AnexoFacadeLocal getAnexoFacade() {
        return anexoFacade;
    }

    public void setAnexoFacade(AnexoFacadeLocal anexoFacade) {
        this.anexoFacade = anexoFacade;
    }

    public AeropuertoFacadeLocal getAeropuertoFacade() {
        return aeropuertoFacade;
    }

    public void setAeropuertoFacade(AeropuertoFacadeLocal aeropuertoFacade) {
        this.aeropuertoFacade = aeropuertoFacade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public byte[] getPath() {
        return path;
    }

    public void setPath(byte[] path) {
        this.path = path;
    }

    public String getTipoAnexo() {
        return tipoAnexo;
    }

    public void setTipoAnexo(String tipoAnexo) {
        this.tipoAnexo = tipoAnexo;
    }

    public String getCodigoRelacion() {
        return codigoRelacion;
    }

    public void setCodigoRelacion(String codigoRelacion) {
        this.codigoRelacion = codigoRelacion;
    }
    
    
    
    
}
