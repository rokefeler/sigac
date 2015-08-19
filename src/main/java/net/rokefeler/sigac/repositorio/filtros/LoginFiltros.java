package net.rokefeler.sigac.repositorio.filtros;

import java.io.Serializable;

public class LoginFiltros implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String razon;
	private String email;
	
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
