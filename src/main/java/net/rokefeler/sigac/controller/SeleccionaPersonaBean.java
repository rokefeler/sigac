package net.rokefeler.sigac.controller;

import net.rokefeler.sigac.modelo.Persona;
import net.rokefeler.sigac.repositorio.PersonaRepositorio;
import net.rokefeler.sigac.repositorio.filtros.PersonaFiltros;
import org.primefaces.context.RequestContext;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@ViewScoped
public class SeleccionaPersonaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PersonaRepositorio personaRepositorio;

	@Inject
	private PersonaFiltros personaFiltros;

	private List<Persona> personasFiltradas;

	public void buscar() {
		personasFiltradas = personaRepositorio.listarPersonasFiltrados(personaFiltros);
	}

	public void abrirDialogo() {
		Map<String, Object> opciones = new HashMap<>();
		opciones.put("modal", true);
		opciones.put("resizable", false);
		opciones.put("contentHeight", 450);

		RequestContext.getCurrentInstance().openDialog("seleccionapersona", opciones, null);
	}

	public void selecionar(Persona persona) {
		RequestContext.getCurrentInstance().closeDialog(persona);
	}

	public PersonaFiltros getPersonaFiltros() {
		return personaFiltros;
	}

	public void setPersonaFiltros(PersonaFiltros personaFiltros) {
		this.personaFiltros = personaFiltros;
	}

	public List<Persona> getPersonasFiltradas() {
		return personasFiltradas;
	}
}