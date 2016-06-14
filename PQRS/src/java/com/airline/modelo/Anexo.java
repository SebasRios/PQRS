/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author brian
 */
@Entity
@Table(name = "anexo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anexo.findAll", query = "SELECT a FROM Anexo a"),
    @NamedQuery(name = "Anexo.findByCodigo", query = "SELECT a FROM Anexo a WHERE a.anexoPK.codigo = :codigo"),
    @NamedQuery(name = "Anexo.findByTipoAnexo", query = "SELECT a FROM Anexo a WHERE a.tipoAnexo = :tipoAnexo"),
    @NamedQuery(name = "Anexo.findByCodigoRelacion", query = "SELECT a FROM Anexo a WHERE a.anexoPK.codigoRelacion = :codigoRelacion")})
public class Anexo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AnexoPK anexoPK;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "path")
    private byte[] path;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipoAnexo")
    private String tipoAnexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "mime")
    private String mime;

    public Anexo() {
    }

    public Anexo(AnexoPK anexoPK) {
        this.anexoPK = anexoPK;
    }

    public Anexo(AnexoPK anexoPK, byte[] path, String tipoAnexo) {
        this.anexoPK = anexoPK;
        this.path = path;
        this.tipoAnexo = tipoAnexo;
    }

    public Anexo(String codigo, String codigoRelacion) {
        this.anexoPK = new AnexoPK(codigo, codigoRelacion);
    }

    public AnexoPK getAnexoPK() {
        return anexoPK;
    }

    public void setAnexoPK(AnexoPK anexoPK) {
        this.anexoPK = anexoPK;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anexoPK != null ? anexoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anexo)) {
            return false;
        }
        Anexo other = (Anexo) object;
        if ((this.anexoPK == null && other.anexoPK != null) || (this.anexoPK != null && !this.anexoPK.equals(other.anexoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.airline.modelo.Anexo[ anexoPK=" + anexoPK + " ]";
    }
    
}
