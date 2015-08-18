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
	
	private List<Login> usuariosFiltrados;
	private LoginFiltros filtros;
	
	private Login usuarioSeleccionado;
	
	

	public UsuarioBean(){
		filtros = new LoginFiltros();
	}
	
	public void buscarUsuarioFiltros(){
		usuariosFiltrados = loginRepositorio.listarLoginsFiltrados(filtros);

	}

	public void eliminarUsuario(){
		/*
		LoginRepositorio.removerUsuario(usuarioSeleccionado);
		usuariosFiltrados.remove(usuarioSeleccionado);
		*/
		FacesUtil.adicionarMensajeInfo("Usuario "+ usuarioSeleccionado.getRazon() +" no puede ser eliminado.");
	}	

	
	
	public Login getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(Login usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}
	
	public LoginFiltros getFiltros() {
		return filtros;
	}
	
	public List<Login> getUsuariosFiltrados() {
		return usuariosFiltrados;
	}
}
