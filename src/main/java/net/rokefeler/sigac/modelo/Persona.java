package net.rokefeler.sigac.modelo;

import net.rokefeler.sigac.modelo.tipos.TipoEstado;
import net.rokefeler.sigac.modelo.tipos.TipoSexo;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Jose Roque el 09/08/2015.
 * Email: rokefeler@gmail.com
 */
@Entity(name="tpersona")
public class Persona implements Serializable {
    private String id;
    private String codanterior;
    private String apellidos;
    private String nombres;
    private Date fnac;
    private TipoSexo sexo;
    private String direccion;
    private String urbanizacion;
    private String referencia;
    private String fijo;
    private String movil;
    private String Email;
    private PaisIso paisIso;
    private UbigeoDistrito idDistrito;
    private String foto;
    private Codigo idcIden;
    private String nrodoc;
    private boolean esAlumno;
    private boolean esDocente;
    private boolean esEmpleado;
    private java.util.Calendar fecha;
    private String idLogin;
    private TipoEstado estado;
    private String razon;

    @Id
    @Column(name="id_Persona", nullable = false, length= 15)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id= id;
    }

    @Column(name="codanterior_Persona", nullable = true, length= 15)
    public String getCodanterior() {
        return codanterior;
    }

    public void setCodanterior(String codanterior) {
        this.codanterior = codanterior;
    }

    @Column(name="nombres_Persona", nullable = false, length= 120)
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Column(name="apellidos_Persona", nullable = false, length= 75)
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


    @Temporal(TemporalType.DATE)
    @Column(name = "fnac_Persona", nullable = true)
    public Date getFnac() {
        return fnac;
    }

    public void setFnac(Date fnac) {
        this.fnac = fnac;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="sexo_Persona", nullable=false, length = 10)
    public TipoSexo getSexo() {
        return sexo;
    }

    public void setSexo(TipoSexo sexo) {
        this.sexo = sexo;
    }

    @Column(name="direccion_Persona", nullable = false, length= 160)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(name="urbanizacion_Persona", nullable = true, length= 70)
    public String getUrbanizacion() {
        return urbanizacion;
    }

    public void setUrbanizacion(String urbanizacion) {
        this.urbanizacion = urbanizacion;
    }

    @Column(name="referencia_Persona", nullable = true, length= 120)
    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @Column(name="fijo_Persona", nullable = true, length= 15)
    public String getFijo() {
        return fijo;
    }

    public void setFijo(String fijo) {
        this.fijo = fijo;
    }

    @Column(name="movil_Persona", nullable = true, length= 15)
    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    @Column(name="email_Persona", nullable = true, length= 120)
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @ManyToOne
    @JoinColumn(name="idPaisIso_Persona", nullable = false)
    public PaisIso getPaisIso() {
        return paisIso;
    }

    public void setPaisIso(PaisIso paisIso) {
        this.paisIso = paisIso;
    }

    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name="idDistrito_Persona", nullable = true)
    public UbigeoDistrito getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(UbigeoDistrito idDistrito) {
        this.idDistrito = idDistrito;
    }

    @Column(name="foto_Persona", nullable = true, length= 256)
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @ManyToOne
    @JoinColumn(name = "idcIden_Persona", nullable = true)
    public Codigo getIdcIden() {
        return idcIden;
    }

    public void setIdcIden(Codigo idcIden) {
        this.idcIden = idcIden;
    }

    @Column(name="nrodoc_Persona", nullable = true, length= 25)
    public String getNrodoc() {
        return nrodoc;
    }

    public void setNrodoc(String nrodoc) {
        this.nrodoc = nrodoc;
    }

    @Column(name="esAlumno_Persona", nullable = true)
    public boolean isEsAlumno() {
        return esAlumno;
    }

    public void setEsAlumno(boolean esAlumno) {
        this.esAlumno = esAlumno;
    }

    @Column(name="esDocente_Persona", nullable = true)
    public boolean isEsDocente() {
        return esDocente;
    }

    public void setEsDocente(boolean esDocente) {
        this.esDocente = esDocente;
    }

    @Column(name="esEmpleado_Persona", nullable = true)
    public boolean isEsEmpleado() {
        return esEmpleado;
    }

    public void setEsEmpleado(boolean esEmpleado) {
        this.esEmpleado = esEmpleado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_Persona", nullable = false)
    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    @Column(name="idLogin_Persona", nullable = false)
    public String getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(String idLogin) {
        this.idLogin = idLogin;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="estado_Persona", nullable=false, length = 25)
    public TipoEstado getEstado() {
        return estado;
    }

    public void setEstado(TipoEstado estado) {
        this.estado = estado;
    }

    @Transient
    public String getRazon() {
        return razon;
    }

    @PostConstruct
    public void Persona(){

        try {
            this.razon = apellidos.concat(", ").concat(nombres);
        } catch (Exception e) {
            this.razon="";
        }

    }

    /****************************************/

}
