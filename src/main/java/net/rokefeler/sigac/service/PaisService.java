package net.rokefeler.sigac.service;

import net.rokefeler.sigac.modelo.Pais;
import net.rokefeler.sigac.repositorio.PaisRepositorio;
import net.rokefeler.sigac.util.jpa.Transaccion;

import javax.inject.Inject;
import java.io.Serializable;

public class PaisService implements Serializable{
	private static final long serialVersionUID = 1L;

	@Inject
	private PaisRepositorio paisRepositorio;
	
	@Transaccion
	public Pais registrarPais(Pais pais){
		
		Pais paisExistente = paisRepositorio.getbyIdPais(pais.getId());
		if(paisExistente!=null && !paisExistente.equals(pais)){
			throw new NegocioExcepciones("Ya existe un País con ese Id, verificar");
		}
		return paisRepositorio.addPais(pais);
	}
}
