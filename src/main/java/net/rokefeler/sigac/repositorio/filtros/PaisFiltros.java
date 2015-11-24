package net.rokefeler.sigac.repositorio.filtros;

import java.io.Serializable;

public class PaisFiltros implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;
	private String nombre;
	private String code;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}