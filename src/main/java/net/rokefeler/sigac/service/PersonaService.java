package net.rokefeler.sigac.service;

import net.rokefeler.sigac.modelo.Pais;
import net.rokefeler.sigac.modelo.Persona;
import net.rokefeler.sigac.repositorio.PersonaRepositorio;
import net.rokefeler.sigac.util.jpa.Transaccion;

import javax.inject.Inject;
import java.io.Serializable;

public class PersonaService implements Serializable{
	private static final long serialVersionUID = 1L;

	@Inject
	private PersonaRepositorio personaRepositorio;
	
	@Transaccion
	public Persona registrarPersona(Persona persona){
		Persona personaExistente = personaRepositorio.getbyIdPersona(persona.getId());

		if(personaExistente!=null && !personaExistente.equals(persona)){
			throw new NegocioExcepciones("Ya existe una Persona con ese Id, verificar");
		}
		return personaRepositorio.addPersona(persona);
	}
}
