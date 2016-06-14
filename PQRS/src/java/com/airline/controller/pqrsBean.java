/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.controller;

import com.airline.logica.AeropuertoFacadeLocal;
import com.airline.logica.AnexoFacadeLocal;
import com.airline.logica.ClienteFacadeLocal;
import com.airline.logica.EstadoFacadeLocal;
import com.airline.logica.PqrsFacadeLocal;
import com.airline.modelo.Aeropuerto;
import com.airline.modelo.Anexo;
import com.airline.modelo.AnexoPK;
import com.airline.modelo.Estado;
import com.airline.modelo.Pqrs;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.el.ELContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author brian
 */
public class pqrsBean implements Serializable {

  //Inyeccion
  @EJB
  private AnexoFacadeLocal anexoFacade;
  @EJB
  private AeropuertoFacadeLocal aeropuertoFacade;
  @EJB
  private ClienteFacadeLocal clienteFacade;
  @EJB
  private PqrsFacadeLocal pqrsFacade;
  @EJB
  private EstadoFacadeLocal estadoFacade;  

  //Definición de atributos de la vista
  private String codigo;
  private String tipo; //Petición, queja, reclamo o sugerencia
  private String tipoDocCliente;
  private String numeroDocCliente;
  private Date fechaPQRS;
  private Date fechaHechos;
  private String codigoAeropuerto;
  private String descripcion;
  
  private List<UploadedFile> anexos;

  private String codigoBusqueda;
  private Pqrs selectedPqrs;
  private List<Anexo> selectedAnexos;
  private List<Estado> selectedEstados;
  private List<Aeropuerto> aeropuertos;

  // Manejo de errores
  private String error;
  @PersistenceContext(unitName = "PQRSPU")
  private EntityManager em;
  @Resource
  private javax.transaction.UserTransaction utx;

  // Crear una nueva instancia de pqrsBean
  public pqrsBean() {
  }

  public AeropuertoFacadeLocal getAeropuertoFacade() {
    return aeropuertoFacade;
  }

  public void setAeropuertoFacade(AeropuertoFacadeLocal aeropuertoFacade) {
    this.aeropuertoFacade = aeropuertoFacade;
  }

  public ClienteFacadeLocal getClienteFacade() {
    return clienteFacade;
  }

  public void setClienteFacade(ClienteFacadeLocal clienteFacade) {
    this.clienteFacade = clienteFacade;
  }

  public PqrsFacadeLocal getPqrsFacade() {
    return pqrsFacade;
  }

  public void setPqrsFacade(PqrsFacadeLocal pqrsFacade) {
    this.pqrsFacade = pqrsFacade;
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

  public String getCodigoBusqueda() {
    return codigoBusqueda;
  }

  public void setCodigoBusqueda(String codigoBusqueda) {
    this.codigoBusqueda = codigoBusqueda;
  }

  public List<Aeropuerto> getAeropuertos() {
    return aeropuertos;
  }

  public void setAeropuertos(List<Aeropuerto> aeropuertos) {
    this.aeropuertos = aeropuertos;
  }

  public Pqrs getSelectedPqrs() {
    return selectedPqrs;
  }

  public List<Anexo> getSelectedAnexos() {
    return selectedAnexos;
  }

  public void setSelectedAnexos(List<Anexo> selectedAnexos) {
    this.selectedAnexos = selectedAnexos;
  }

  public List<Estado> getSelectedEstados() {
    return selectedEstados;
  }

  public void setSelectedEstados(List<Estado> selectedEstados) {
    this.selectedEstados = selectedEstados;
  }

  public void setSelectedPqrs(Pqrs selectedPqrs) {
    this.selectedPqrs = selectedPqrs;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public List<UploadedFile> getAnexos() {
    return anexos;
  }

  public void setAnexos(List<UploadedFile> anexos) {
    this.anexos = anexos;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public List<Aeropuerto> consultarAeropuertos() {
    return aeropuertoFacade.findAll();
  }
  
  public void consultar() {
    Pqrs p = pqrsFacade.consultar(codigoBusqueda);
    
    if (p != null) {
      selectedPqrs = p;
      selectedAnexos = anexoFacade.findByPQRS(codigoBusqueda);
      selectedEstados = estadoFacade.findByPQRS(codigoBusqueda);

      error = "";
    } else {
      selectedPqrs = null;
      selectedAnexos = null;
      selectedEstados = null;
      
      error = "No se encontro la pqrs";
    }
  }

  public void registrar() throws ParseException {
    Pqrs p = new Pqrs();
    
    fechaPQRS = new Date();
    
    // p.setCodigo(codigo);
    p.setDescripcion(descripcion);
    p.setTipo(tipo);
    
    ELContext elContext = FacesContext.getCurrentInstance().getELContext();
    clienteBean _clienteBean = (clienteBean) elContext.getELResolver().getValue(elContext, null, "clienteBean");

    if (_clienteBean != null && _clienteBean.getCliente() != null) {
      p.setTipoDocCliente(_clienteBean.getCliente().getClientePK().getTipoDocumento());
      p.setNumeroDocCliente(_clienteBean.getCliente().getClientePK().getNumeroDocumento());
    }
    
    p.setFechaPQRS(fechaPQRS);
    p.setFechaHechos(fechaHechos);
    p.setCodigoAeropuerto(codigoAeropuerto);
    
    this.pqrsFacade.create(p);
    
    codigo = p.getCodigo();
    
    for (Iterator<UploadedFile> it = anexos.iterator(); it.hasNext();) {
      UploadedFile file = it.next();
      
      Anexo a = new Anexo();
      AnexoPK anexoPK = new AnexoPK();
      anexoPK.setCodigoRelacion(codigo);
      
      a.setPath(file.getContents());
      a.setTipoAnexo("pqrs");
      a.setName(file.getFileName());
      a.setMime(file.getContentType());
      a.setAnexoPK(anexoPK);
      
      this.anexoFacade.create(a);
    }
    
    if (_clienteBean != null && _clienteBean.getCliente() != null) {
      _clienteBean.setPqrs(pqrsFacade.findAll());
    }
  }
  
  public void subirAnexo(FileUploadEvent event) throws ParseException {
    UploadedFile file = event.getFile();

    if (anexos == null) {
      anexos = new ArrayList<UploadedFile>();
    }
    
    anexos.add(file);
  }

  public void persist(Object object) {
    try {
      utx.begin();
      em.persist(object);
      utx.commit();
    } catch (Exception e) {
      Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
      throw new RuntimeException(e);
    }
  }
  
  public StreamedContent descargar(Anexo anexo) {
    InputStream is = new ByteArrayInputStream(anexo.getPath());
    StreamedContent image = new DefaultStreamedContent(is, anexo.getMime(), anexo.getName());
    return image;
  }

}
