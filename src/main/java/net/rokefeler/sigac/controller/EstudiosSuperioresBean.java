package net.rokefeler.sigac.controller;

import net.rokefeler.sigac.modelo.EstudiosSuperiores;
import net.rokefeler.sigac.modelo.Persona;
import net.rokefeler.sigac.repositorio.EstudiosSuperioresRepositorio;
import net.rokefeler.sigac.util.FacesUtil;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class EstudiosSuperioresBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EstudiosSuperioresRepositorio estudioSuperiorRepositorio;

	@Inject
	private FacesUtil messages;

	private List<EstudiosSuperiores> estudiosSuperioresFiltrados;
	private Persona personaSeleccionado;
    private EstudiosSuperiores estudioSuperiorSeleccionado;

	public EstudiosSuperioresBean(){
		personaSeleccionado= new Persona();
        estudioSuperiorSeleccionado = new EstudiosSuperiores();
        estudiosSuperioresFiltrados = new ArrayList<>();
	}

	public EstudiosSuperioresBean(Persona p){
		personaSeleccionado= p;
        estudiosSuperioresFiltrados = new ArrayList<>();
	}
    public EstudiosSuperioresBean(EstudiosSuperiores es){
        estudioSuperiorSeleccionado= es;
        estudiosSuperioresFiltrados = new ArrayList<>();
    }

    /**
     * Busca los Estudios Superiores de la Persona Seleccionada
     */
    public void buscarEstudiosSuperiores(){
		estudiosSuperioresFiltrados =
				estudioSuperiorRepositorio.getbyIdPersona(personaSeleccionado.getId());
    }

	public void eliminarEstudioSuperior(){
		estudioSuperiorRepositorio.deleteEstudiosSuperiores(estudioSuperiorSeleccionado.getId());
		estudiosSuperioresFiltrados.remove(estudioSuperiorSeleccionado);
		FacesUtil.adicionarMensajeInfo("Estudio Superior de la Institución "+ estudioSuperiorSeleccionado.getInstitucion() +" Fue Eliminado.");
	}

    public List<EstudiosSuperiores> getEstudiosSuperioresFiltrados() {
        return estudiosSuperioresFiltrados;
    }

    public void setEstudiosSuperioresFiltrados(List<EstudiosSuperiores> estudiosSuperioresFiltrados) {
        this.estudiosSuperioresFiltrados = estudiosSuperioresFiltrados;
    }

    public Persona getPersonaSeleccionado() {
        return personaSeleccionado;
    }

    public void setPersonaSeleccionado(Persona personaSeleccionado) {
        this.personaSeleccionado = personaSeleccionado;
    }

    public EstudiosSuperiores getEstudioSuperiorSeleccionado() {
        return estudioSuperiorSeleccionado;
    }

    public void setEstudioSuperiorSeleccionado(EstudiosSuperiores estudioSuperiorSeleccionado) {
        this.estudioSuperiorSeleccionado = estudioSuperiorSeleccionado;
    }
}
