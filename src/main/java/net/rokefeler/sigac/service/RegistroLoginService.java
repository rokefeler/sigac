package net.rokefeler.sigac.service;

import net.rokefeler.sigac.util.jpa.Transaccion;
import net.rokefeler.sigac.modelo.Login;
import net.rokefeler.sigac.repositorio.LoginRepositorio;

import javax.inject.Inject;
import java.io.Serializable;

public class RegistroLoginService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private LoginRepositorio loginRepositorio;
	
	@Transaccion
	public Login registrarUsuario(Login login){
		
		Login usuarioExistente = loginRepositorio.getbyEmailLogin(login.getIdPersona().getEmail());
		
		if(usuarioExistente!=null && !usuarioExistente.equals(login)){
			throw new NegocioExcepciones("Ya existe un login con ese Email, verificar");
		}
		
		return loginRepositorio.addLogin(login);
	}

}
