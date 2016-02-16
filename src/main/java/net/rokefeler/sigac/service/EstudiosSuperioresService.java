package net.rokefeler.sigac.service;

import net.rokefeler.sigac.modelo.EstudiosSuperiores;
import net.rokefeler.sigac.repositorio.EstudiosSuperioresRepositorio;
import net.rokefeler.sigac.util.jpa.Transaccion;

import javax.inject.Inject;
import java.io.Serializable;

public class EstudiosSuperioresService implements Serializable{
	private static final long serialVersionUID = 1L;

	@Inject
	private EstudiosSuperioresRepositorio estudiosSuperioresRepositorio;
	
	@Transaccion
	public EstudiosSuperiores registrar(EstudiosSuperiores estudiosSuperiores){
		EstudiosSuperiores estudioSupExistente;
        estudioSupExistente = estudiosSuperioresRepositorio.getbyIdEstudios(estudiosSuperiores.getId());
		if(estudioSupExistente!=null && !estudioSupExistente.equals(estudiosSuperiores)){
			throw new NegocioExcepciones("Ya existe Un Estudio Superior con ese Id, verificar");
		}
		return estudiosSuperioresRepositorio.addEstudiosPersonales(estudiosSuperiores);
	}
}
