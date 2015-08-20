package net.rokefeler.sigac.repositorio.filtros;

import java.io.Serializable;

public class LoginFiltros implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String apellidos;
	private String nombres;
	private String email;

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {

		this.email = email;
	}
}
