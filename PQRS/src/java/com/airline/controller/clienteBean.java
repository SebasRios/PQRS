/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.controller;

import com.airline.logica.ClienteFacadeLocal;
import com.airline.logica.PqrsFacadeLocal;
import com.airline.modelo.Cliente;
import com.airline.modelo.ClientePK;
import com.airline.modelo.Pqrs;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author brian
 */
public class clienteBean implements Serializable {
	//Inyeccion

	@EJB
	private ClienteFacadeLocal clienteFacade;
	@EJB
	private PqrsFacadeLocal pqrsFacade;

	//Definición de atributos de la vista
	private String tipoDocumento;
	private String numeroDocumento;
	private String nombres;
	private String apellidos;
	private String telefono;
	private String paisResidencia;
	private String ciudadResidencia;
	private String nacionalidad;
	private String direccion;
	private String correoElectronico;
	private String contrasena;

	private String codigo;

	private List<Pqrs> pqrs;

	private Cliente cliente;

	// Manejo de errores
	private String error;

	// Internacionalizacion
	private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

	// Crear una nueva instancia de clienteBean
	public clienteBean() {
	}

	public ClienteFacadeLocal getClienteFacade() {
		return clienteFacade;
	}

	public void setClienteFacade(ClienteFacadeLocal clienteFacade) {
		this.clienteFacade = clienteFacade;
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

	public String getPaisResidencia() {
		return paisResidencia;
	}

	public void setPaisResidencia(String paisResidencia) {
		this.paisResidencia = paisResidencia;
	}

	public String getCiudadResidencia() {
		return ciudadResidencia;
	}

	public void setCiudadResidencia(String ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public List<Pqrs> getPqrs() {
		return pqrs;
	}

	public void setPqrs(List<Pqrs> pqrs) {
		this.pqrs = pqrs;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public void inicioSesion() {
		Cliente c = this.clienteFacade.login(correoElectronico);

		if (c != null) {
			if (c.getContraseña().equals(contrasena)) {
				cliente = c;

				pqrs = pqrsFacade.findAll();

				error = "";
			} else {
				error = "La contraseña no coincide.";
			}
		} else {
			error = "No existe el personal con ese correo electronico.";
		}
	}

	public void registro() {
		Cliente c = new Cliente();

		ClientePK cpk = new ClientePK();

		cpk.setTipoDocumento(tipoDocumento);
		cpk.setNumeroDocumento(numeroDocumento);

		c.setClientePK(cpk);
		c.setNombres(nombres);
		c.setApellidos(apellidos);
		c.setTelefono(telefono);
		c.setPaisResidencia(paisResidencia);
		c.setCiudadResidencia(ciudadResidencia);
		c.setNacionalidad(nacionalidad);
		c.setDireccion(direccion);
		c.setCorreoElectronico(correoElectronico);
		c.setContraseña(contrasena);

		this.clienteFacade.create(c);

		this.cliente = c;
	}

	public void cerrarSesion() {
		tipoDocumento = "";
		numeroDocumento = "";
		nombres = "";
		apellidos = "";
		telefono = "";
		paisResidencia = "";
		ciudadResidencia = "";
		nacionalidad = "";
		direccion = "";
		correoElectronico = "";
		contrasena = "";
		cliente = null;
		pqrs = null;
		codigo = "";
		error = "";
	}

	public void changeLanguage(String language) {
		locale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}
}
