package net.rokefeler.sigac.repositorio.filtros;

import java.io.Serializable;

public class PersonaFiltros implements Serializable{

	private static final long serialVersionUID = 1L;

	private String idPersona;
	private String razon;
	private String email;

	public String getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}

	public String getRazon() {
		return razon;
	}

	public void setRazon(String razon) {
		this.razon = razon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}