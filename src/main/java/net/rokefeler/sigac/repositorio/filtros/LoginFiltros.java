package net.rokefeler.sigac.repositorio.filtros;

import java.io.Serializable;

public class LoginFiltros implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String apepat;
	private String apemat;
	private String nombres;
	private String email;

	public String getApepat() {
		return apepat;
	}

	public void setApepat(String apepat) {
		this.apepat = apepat;
	}

	public String getApemat() {
		return apemat;
	}

	public void setApemat(String apemat) {
		this.apemat = apemat;
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
