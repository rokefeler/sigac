package net.rokefeler.sigac.repositorio.filtros;

import java.io.Serializable;

public class PersonaFiltros implements Serializable{

	private static final long serialVersionUID = 1L;

	private String idPersona;
	private String apellidos;
	private String nombres;
	private String email;


	public String getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
}