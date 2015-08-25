package net.rokefeler.sigac.controller;

import net.rokefeler.sigac.modelo.Persona;
import net.rokefeler.sigac.repositorio.PersonaRepositorio;
import net.rokefeler.sigac.repositorio.filtros.PersonaFiltros;
import net.rokefeler.sigac.util.FacesUtil;
import org.primefaces.event.SelectEvent;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class PersonaBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private PersonaRepositorio personaRepositorio;

	@Inject
	private FacesUtil messages;

	private List<Persona> personaFiltrados;
	private PersonaFiltros filtros;
	private Persona personaSeleccionado;



	public PersonaBean(){
		filtros = new PersonaFiltros();
	}
	
	public void buscarPersonaFiltros(){
		personaFiltrados = personaRepositorio.listarPersonasFiltrados(filtros);
	}

	public void eliminarPersona(){

		personaRepositorio.removerPersona(personaSeleccionado);
		personaFiltrados.remove(personaSeleccionado);
		FacesUtil.adicionarMensajeInfo("Persona "+ personaSeleccionado.getRazon() +" no puede ser eliminado.");
	}

	public Persona getPersonaSeleccionado() {
		return personaSeleccionado;
	}

	public void setPersonaSeleccionado(Persona personaSeleccionado) {
		this.personaSeleccionado = personaSeleccionado;
	}

	public PersonaFiltros getFiltros() {
		return filtros;
	}
	
	public List<Persona> getPersonaFiltrados() {

		return personaFiltrados;
	}

	public void personaSelecionado(SelectEvent event) {
		Persona persona = (Persona) event.getObject();
		setPersonaSeleccionado(persona);
	}
}
