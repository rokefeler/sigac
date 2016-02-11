package net.rokefeler.sigac.controller;

import net.rokefeler.sigac.modelo.*;
import net.rokefeler.sigac.modelo.tipos.TipoEstadoCivil;
import net.rokefeler.sigac.modelo.tipos.TipoEstadoRegistro;
import net.rokefeler.sigac.modelo.tipos.TipoGrupoSanguineo;
import net.rokefeler.sigac.modelo.tipos.TipoSexo;
import net.rokefeler.sigac.repositorio.CodigoRepositorio;
import net.rokefeler.sigac.repositorio.PaisRepositorio;
import net.rokefeler.sigac.repositorio.UbigeoRepositorio;
import net.rokefeler.sigac.security.Seguridad;
import net.rokefeler.sigac.security.UsuarioSistema;
import net.rokefeler.sigac.service.PersonaService;
import net.rokefeler.sigac.util.FacesUtil;
import net.rokefeler.sigac.util.cdi.CDIServiceLocator;
import org.hibernate.validator.constraints.NotBlank;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@ViewScoped
public class RegistroPersonaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    //private static Log log = LogFactory.getLog(RegistroPersonaBean.class);
    private boolean IsFormLimpiadoRecientemente;
    @Inject
    private PersonaService personaService;

    @Inject
    private PaisRepositorio paisRepositorio;

    @Inject
    private UbigeoRepositorio ubigeoRepositorio;

    @Inject
    private CodigoRepositorio codigoRepositorio;

    @Inject
    private Seguridad seguridad;

    private Persona persona;

    //Almacena Departamento Seleccionado temporalmente
    private UbigeoDepartamento departamentoNacimiento;
    private UbigeoProvincia provinciaNacimiento;

    private UbigeoDepartamento departamentoDomicilio;
    private UbigeoProvincia provinciaDomicilio;

    private List<UbigeoDepartamento> departamentosNacimiento;
    private List<UbigeoProvincia> provinciasNacimiento;
    private List<UbigeoDistrito> distritosNacimiento;

    private List<UbigeoDepartamento> departamentosDomicilio;
    private List<UbigeoProvincia> provinciasDomicilio;
    private List<UbigeoDistrito> distritosDomicilio;

    //Carga de los Tipos de Documentos existentes en Tabla Codigos
    private List<Codigo> tipodocumentos;

    //Carga de los Tipos de Vías
    private List<Codigo> tipoVias;
    //Carga de los Tipos Zonas
    private List<Codigo> tipoZonas;

    public RegistroPersonaBean() {
        limpiarFormulario();
    }

    public void inicializar() {
        if (FacesUtil.isNotPostback()) {
            if(persona==null) {
                persona = new Persona();
                persona.setDireccion(new Direccion());
            }
            this.tipoVias = codigoRepositorio.getAllCodigobyTipo("TVIA");
            this.tipoZonas = codigoRepositorio.getAllCodigobyTipo("ZONA");
            this.tipodocumentos = codigoRepositorio.getAllCodigobyTipo("TDOC");
            this.departamentosDomicilio = ubigeoRepositorio.listarDepartamentos();
            //Copia
            //this.departamentosNacimiento = new ArrayList<>(departamentosDomicilio);
            this.departamentosNacimiento = ubigeoRepositorio.listarDepartamentos();

            if(this.persona.getDireccion()!=null) {
                if (this.persona.getDireccion().getIdDistritoDomicilio() != null) {
                    this.provinciaDomicilio = persona.getDireccion().getIdDistritoDomicilio().getUbigeoProvincia();
                    this.departamentoDomicilio = provinciaDomicilio.getUbigeoDepartamento();
                }
            }
            if(this.departamentoDomicilio !=null) {
                cargarProvinciasDomicilio();
            }

            //log.info("método inicializar, persona=" + this.persona.getIdDistrito().getId() + " - " + this.persona.getIdDistrito().getNombre());
            if(this.persona.getIdDistritoNacimiento()!=null ){
                this.provinciaNacimiento = persona.getIdDistritoNacimiento().getUbigeoProvincia();
                this.departamentoNacimiento = provinciaNacimiento.getUbigeoDepartamento();
                //log.info("[método inicializar 2 , persona="+this.distrito.getId() + "]");
            }
            if (this.departamentoNacimiento !=null) {
                cargarProvinciasNacimiento();
            }
            IsFormLimpiadoRecientemente=false;
        }
    }

    private void limpiarFormulario() {
        if(IsFormLimpiadoRecientemente) return;
        if(this.paisRepositorio==null)
            this.paisRepositorio= CDIServiceLocator.getBean(PaisRepositorio.class);
        this.persona = new Persona();
        this.persona.setDireccion(new Direccion());
        this.persona.setEstado(TipoEstadoRegistro.VIGENTE);
        this.persona.setGruposanguineo(TipoGrupoSanguineo.O_PLUS);
        Pais p = paisRepositorio.getbyIdPais("PER");
        if(this.seguridad==null)
            this.seguridad= CDIServiceLocator.getBean(Seguridad.class);
        if(ubigeoRepositorio==null)
            ubigeoRepositorio=CDIServiceLocator.getBean(UbigeoRepositorio.class);
        if(codigoRepositorio==null)
            codigoRepositorio=CDIServiceLocator.getBean(CodigoRepositorio.class);
        this.persona.setIdLogin(seguridad.getLogin().getIdLogin());
        this.persona.setFecha(new Date());
        this.persona.setIdcIden(codigoRepositorio.getbyIdCodigo("TDOC-0001")); //por defecto DNI
        //this.persona.setFechacreacion(new Date());

        this.persona.setPais(p);
        //this.departamentoNacimiento = null;
        UbigeoDepartamento departamentoPorDefecto =ubigeoRepositorio.obtenerDepartamento("04");
        this.departamentoDomicilio = departamentoPorDefecto;
        this.provinciasDomicilio = ubigeoRepositorio.listarProvincias("04");
        this.provinciaDomicilio = ubigeoRepositorio.obtenerProvincia("0401");
        this.distritosDomicilio = ubigeoRepositorio.listarDistritos("0401");
        UbigeoDistrito distritoPorDefecto = ubigeoRepositorio.obtenerDistrito("040101");
        this.persona.getDireccion().setIdDistritoDomicilio(distritoPorDefecto);


        try {
            this.departamentoNacimiento = (UbigeoDepartamento) departamentoPorDefecto.clone();
        } catch (CloneNotSupportedException e) {
            this.departamentoNacimiento = ubigeoRepositorio.obtenerDepartamento("04");
        }
        if(provinciasNacimiento == null)
            provinciasNacimiento=new ArrayList<>();
        else
            provinciasNacimiento.clear();



        provinciasNacimiento.addAll(provinciasDomicilio);

        if(distritosNacimiento == null)
            distritosNacimiento =  new ArrayList<>();
        else
            distritosNacimiento.clear();
        distritosNacimiento.addAll(distritosDomicilio);

        try {
            provinciaNacimiento = (UbigeoProvincia) provinciaDomicilio.clone();
        } catch (CloneNotSupportedException e) {
            provinciaNacimiento = ubigeoRepositorio.obtenerProvincia("0401");
        }

        try {
            persona.setIdDistritoNacimiento( (UbigeoDistrito) this.persona.getDireccion().getIdDistritoDomicilio().clone()) ;
        } catch (CloneNotSupportedException e) {
            persona.setIdDistritoNacimiento(ubigeoRepositorio.obtenerDistrito("040101"));
        }
        IsFormLimpiadoRecientemente=true;

/*
        this.provinciaNacimiento = null;
        departamentoDomicilio=null;
        provinciaDomicilio=null;

        provinciasNacimiento = new ArrayList<>();
        distritosNacimiento = new ArrayList<>();

        provinciasDomicilio = new ArrayList<>();
        distritosDomicilio = new ArrayList<>();
        */
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void registrarPersona() {
        this.persona = personaService.registrarPersona(this.persona);
        IsFormLimpiadoRecientemente=false;
        limpiarFormulario();
        FacesUtil.adicionarMensajeInfo("Los datos de la Persona se registró correctamente");
    }

    public UbigeoDepartamento getDepartamentoDomicilio() {
        return departamentoDomicilio;
    }

    public void setDepartamentoDomicilio(UbigeoDepartamento departamentoDomicilio) {
        this.departamentoDomicilio = departamentoDomicilio;
    }

    public UbigeoProvincia getProvinciaDomicilio() {
        return provinciaDomicilio;
    }

    public void setProvinciaDomicilio(UbigeoProvincia provinciaDomicilio) {
        this.provinciaDomicilio = provinciaDomicilio;
    }

    public UbigeoDepartamento getDepartamentoNacimiento() {
        return departamentoNacimiento;
    }

    public void setDepartamentoNacimiento(UbigeoDepartamento departamentoNacimiento) {
        this.departamentoNacimiento = departamentoNacimiento;
    }

    public UbigeoProvincia getProvinciaNacimiento() {
        return provinciaNacimiento;
    }

    public void setProvinciaNacimiento(UbigeoProvincia provinciaNacimiento) {
        this.provinciaNacimiento = provinciaNacimiento;
    }

    public boolean isEditando() {
        return this.persona.getId() != null;
    }

    public TipoSexo[] getTipoSexo() {
        return TipoSexo.values();
    }
    public TipoGrupoSanguineo[] getTipoGrupoSanguineo() {
        return TipoGrupoSanguineo.values();
    }
    public TipoEstadoCivil[] getTipoEstadoCivil() {
        return TipoEstadoCivil.values();
    }
    public TipoEstadoRegistro[] getTipoEstadoRegistro() {
        return TipoEstadoRegistro.values();
    }
    public List<UbigeoDepartamento> getDepartamentosNacimiento() {
        return departamentosNacimiento;
    }
    public List<UbigeoProvincia> getProvinciasNacimiento() {
        return provinciasNacimiento;
    }
    public List<UbigeoDistrito> getDistritosNacimiento() {
        return distritosNacimiento;
    }

    public List<UbigeoDepartamento> getDepartamentosDomicilio() {
        return departamentosDomicilio;
    }
    public List<UbigeoProvincia> getProvinciasDomicilio() {
        return provinciasDomicilio;
    }
    public List<UbigeoDistrito> getDistritosDomicilio() {
        return distritosDomicilio;
    }

    public List<Codigo> getTipodocumentos() {
        return tipodocumentos;
    }
    public List<Codigo> getTipoVias() {
        return tipoVias;
    }
    public List<Codigo> getTipoZonas() {
        return tipoZonas;
    }
/*
    public void addMessage() {
        String summary = "El Estado actual del Usuario es " + this.login.getEstado();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }*/
    /*********
     * Codigo que sirve para Interactuar con Dialogo de Búsqueda *********
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

    public void cargarProvinciasNacimiento() {
        //System.out.println(" método(cargar provincias) departamento seleccionado = " + departamento!=null ? departamento.getId() : "null" );
        if (departamentoNacimiento!=null) {
            //this.provinciasNacimiento.clear();
            this.provinciasNacimiento = ubigeoRepositorio.listarProvincias(departamentoNacimiento.getId() );
            cargarDistritosNacimiento();
        }
    }

    public void cargarDistritosNacimiento() {
        if (provinciaNacimiento!=null) {
            //this.distritosNacimiento.clear();
            this.distritosNacimiento = ubigeoRepositorio.listarDistritos(provinciaNacimiento.getId());
        }
    }

    public void cargarProvinciasDomicilio() {
        if (departamentoDomicilio!=null) {
            //this.provinciasDomicilio.clear();
            this.provinciasDomicilio = ubigeoRepositorio.listarProvincias(departamentoDomicilio.getId() );
            cargarDistritosDomicilio();
        }
    }

    public void cargarDistritosDomicilio() {
        if (provinciaDomicilio!=null) {
            //this.distritosDomicilio.clear();
            this.distritosDomicilio = ubigeoRepositorio.listarDistritos(provinciaDomicilio.getId());
        }
    }


}
