package net.rokefeler.sigac.controller;

import net.rokefeler.sigac.modelo.Login ;
import net.rokefeler.sigac.repositorio.LoginRepositorio;
import net.rokefeler.sigac.repositorio.filtros.LoginFiltros;
import net.rokefeler.sigac.util.FacesUtil;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class UsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private LoginRepositorio loginRepositorio;
	
	private List<Login> loginFiltrados;
	private LoginFiltros filtros;
	
	private Login loginSeleccionado;
	
	

	public UsuarioBean(){
		filtros = new LoginFiltros();
	}
	
	public void buscarUsuarioFiltros(){
		loginFiltrados = loginRepositorio.listarLoginsFiltrados(filtros);

	}

	public void eliminarUsuario(){

		loginRepositorio.deleteLogin(loginSeleccionado);
		loginFiltrados.remove(loginSeleccionado);
		FacesUtil.adicionarMensajeInfo("Usuario "+ loginSeleccionado.getRazon() +" no puede ser eliminado.");
	}	

	
	
	public Login getUsuarioSeleccionado() {

		return loginSeleccionado;
	}

	public void setUsuarioSeleccionado(Login loginSeleccionado){

		this.loginSeleccionado = loginSeleccionado;
	}
	
	public LoginFiltros getFiltros() {
		return filtros;
	}
	
	public List<Login> getUsuariosFiltrados() {

		return loginFiltrados;
	}
}
