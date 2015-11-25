package net.rokefeler.sigac.controller;

import net.rokefeler.sigac.modelo.*;
import net.rokefeler.sigac.modelo.tipos.TipoSexo;
import net.rokefeler.sigac.repositorio.CodigoRepositorio;
import net.rokefeler.sigac.repositorio.PaisRepositorio;
import net.rokefeler.sigac.repositorio.UbigeoRepositorio;
import net.rokefeler.sigac.service.PersonaService;
import net.rokefeler.sigac.util.FacesUtil;
import org.hibernate.validator.constraints.NotBlank;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class RegistroPersonaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private PersonaService personaService;

    @Inject
    private PaisRepositorio paisRepositorio;

    @Inject
    private UbigeoRepositorio ubigeoRepositorio;

    @Inject
    private CodigoRepositorio codigoRepositorio;

    private Persona persona;

    private UbigeoDepartamento departamento;
    private UbigeoProvincia provincia;

    private List<UbigeoDepartamento> departamentos;
    private List<UbigeoProvincia> provincias;
    private List<UbigeoDistrito> distritos;
    private List<Codigo> tipodocumentos;

    public RegistroPersonaBean() {
        limpiarFormulario();
    }

    public void inicializar() {
        if (FacesUtil.isNotPostback()) {
            this.tipodocumentos = codigoRepositorio.getAllbyTipo("TDOC");
            this.departamentos = ubigeoRepositorio.listarDepartamentos();

            if(this.persona.getIdDistrito()!=null ){
                this.provincia = persona.getIdDistrito().getUbigeoProvincia();
                //this.provincias = departamento.getProvincias();
                this.departamento = provincia.getUbigeoDepartamento();
                //this.departamento = ubigeoRepositorio.obtenerDepartamento(this.persona.getIdDistrito().getId().substring(0,2));
                //this.provincia = ubigeoRepositorio.obtenerProvincia(this.persona.getIdDistrito().getId().substring(0,4));
                //System.out.println("departamento seleccionado = " + departamento!=null ? departamento.getId() : "null" );
                //System.out.println("provincia seleccionada = " + provincia!=null ? provincia.getId() : "null" );
            }
            if (this.departamento !=null) {
                cargarProvincias();
            }

        }
    }

    private void limpiarFormulario() {
        persona = new Persona();
        departamento = null;
        provincia = null;
        provincias = new ArrayList<>();
        distritos = new ArrayList<>();
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void registrarPersona() {
        this.persona = personaService.registrarPersona(this.persona);
        limpiarFormulario();
        FacesUtil.adicionarMensajeInfo("Los datos de la Persona se registró correctamente");
    }


    public UbigeoDepartamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(UbigeoDepartamento departamento) {
        this.departamento = departamento;
    }



    public UbigeoProvincia getProvincia() {
        return provincia;
    }

    public void setProvincia(UbigeoProvincia provincia) {
        this.provincia = provincia;
    }


    public boolean isEditando() {
        return this.persona.getId() != null;
    }

    public TipoSexo[] getTipoSexo() {
        return TipoSexo.values();
    }

    public List<UbigeoDepartamento> getDepartamentos() {
        return departamentos;
    }

    public List<UbigeoProvincia> getProvincias() {
        return provincias;
    }

    public List<UbigeoDistrito> getDistritos() {
        return distritos;
    }

    public List<Codigo> getTipodocumentos() {
        return tipodocumentos;
    }
/*
    public void addMessage() {
        String summary = "El Estado actual del Usuario es " + this.login.getEstado();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }*/


    /*********
     * Codigo que sirve para Interactuar con Dialogo de Busqueda *********
     */
    //Viene de Dialog de Búsqueda de Personas
    /*
    public void personaSelecionada(SelectEvent event) {
        Persona persona= (Persona) event.getObject();
         login.setIdPersona(persona); //pasar la persona
    }*/
    @NotBlank
    public String getNombrePersona() {
        String ret = null;
        try {
            ret = persona.getRazon();
        } catch (Exception ex) {
            ret = null;
        }
        return ret;
    }

    public List<Pais> sugerirPaises(String consulta) {
        List<Pais> paisesSugeridos = new ArrayList<>();
        paisesSugeridos = paisRepositorio.sugerirPaises(consulta);
        return paisesSugeridos;
    }

    public void cargarProvincias() {
        //System.out.println(" metodo(cargar provincias) departamento seleccionado = " + departamento!=null ? departamento.getId() : "null" );
        if (departamento!=null) {
            this.provincias.clear();
            this.provincias = ubigeoRepositorio.listarProvincias(departamento.getId() );
            //provincia=provincias.get(0);
            cargarDistritos();
        }
    }

    public void cargarDistritos() {
        //System.out.println("metodo (cargarDistritos) provincia seleccionada" + provincia!=null ? provincia.getId() : "null" );
        if (provincia!=null) {
            this.distritos = ubigeoRepositorio.listarDistritos(provincia.getId());
        }
    }

    /*
	public List<UbigeoDepartamento> sugerirDepartamento(String consulta) {
		List<UbigeoDepartamento> departamentosSugeridos = new ArrayList<>();
		departamentosSugeridos = ubigeoRepositorio.sugerirDepartamentos(consulta);
		return departamentosSugeridos;
	}

    public List<UbigeoDepartamento> listarDepartamentos() {
		List<UbigeoDepartamento> departamentos= new ArrayList<>();
		departamentos= ubigeoRepositorio.listarDepartamentos();
		return departamentos;
    }

	public List<UbigeoProvincia> listarProvincias() {
        List<UbigeoProvincia> provincias = new ArrayList<>();
        provincias = ubigeoRepositorio.listarProvincias (departamento.getId());
        return provincias;
	}

	public List<UbigeoProvincia> sugerirProvincia(String consulta, String idDepartamento) {
		List<UbigeoProvincia> provinciasSugeridos = new ArrayList<>();
		provinciasSugeridos = ubigeoRepositorio.sugerirProvincias(consulta,idDepartamento);
		return provinciasSugeridos;
	}

	public List<UbigeoDistrito> sugerirDistrito(String consulta, String idProvincia) {
		List<UbigeoDistrito> distritosSugeridos = new ArrayList<>();
		distritosSugeridos = ubigeoRepositorio.sugerirDistritos(consulta, idProvincia);
		return distritosSugeridos;
	}*/
}
