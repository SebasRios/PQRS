/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author brian
 */
@Entity
@Table(name = "pqrs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pqrs.findAll", query = "SELECT p FROM Pqrs p"),
    @NamedQuery(name = "Pqrs.findByCodigo", query = "SELECT p FROM Pqrs p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Pqrs.findByTipo", query = "SELECT p FROM Pqrs p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Pqrs.findByTipoDocCliente", query = "SELECT p FROM Pqrs p WHERE p.tipoDocCliente = :tipoDocCliente"),
    @NamedQuery(name = "Pqrs.findByNumeroDocCliente", query = "SELECT p FROM Pqrs p WHERE p.numeroDocCliente = :numeroDocCliente"),
    @NamedQuery(name = "Pqrs.findByFechaPQRS", query = "SELECT p FROM Pqrs p WHERE p.fechaPQRS = :fechaPQRS"),
    @NamedQuery(name = "Pqrs.findByFechaHechos", query = "SELECT p FROM Pqrs p WHERE p.fechaHechos = :fechaHechos"),
    @NamedQuery(name = "Pqrs.findByCodigoAeropuerto", query = "SELECT p FROM Pqrs p WHERE p.codigoAeropuerto = :codigoAeropuerto")})
public class Pqrs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigo")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 10)
    @Column(name = "tipoDocCliente")
    private String tipoDocCliente;
    @Size(max = 10)
    @Column(name = "numeroDocCliente")
    private String numeroDocCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaPQRS")
    @Temporal(TemporalType.DATE)
    private Date fechaPQRS;
    @Column(name = "fechaHechos")
    @Temporal(TemporalType.DATE)
    private Date fechaHechos;
    @Size(max = 10)
    @Column(name = "codigoAeropuerto")
    private String codigoAeropuerto;
    @NotNull
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;

    public Pqrs() {
    }

    public Pqrs(String codigo) {
        this.codigo = codigo;
    }

    public Pqrs(String codigo, String tipo, Date fechaPQRS) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.fechaPQRS = fechaPQRS;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoDocCliente() {
        return tipoDocCliente;
    }

    public void setTipoDocCliente(String tipoDocCliente) {
        this.tipoDocCliente = tipoDocCliente;
    }

    public String getNumeroDocCliente() {
        return numeroDocCliente;
    }

    public void setNumeroDocCliente(String numeroDocCliente) {
        this.numeroDocCliente = numeroDocCliente;
    }

    public Date getFechaPQRS() {
        return fechaPQRS;
    }

    public void setFechaPQRS(Date fechaPQRS) {
        this.fechaPQRS = fechaPQRS;
    }

    public Date getFechaHechos() {
        return fechaHechos;
    }

    public void setFechaHechos(Date fechaHechos) {
        this.fechaHechos = fechaHechos;
    }

    public String getCodigoAeropuerto() {
        return codigoAeropuerto;
    }

    public void setCodigoAeropuerto(String codigoAeropuerto) {
        this.codigoAeropuerto = codigoAeropuerto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pqrs)) {
            return false;
        }
        Pqrs other = (Pqrs) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.airline.modelo.Pqrs[ codigo=" + codigo + " ]";
    }
    
}
