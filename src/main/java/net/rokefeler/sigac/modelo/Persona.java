package net.rokefeler.sigac.modelo;

import net.rokefeler.sigac.modelo.tipos.TipoEstadoCivil;
import net.rokefeler.sigac.modelo.tipos.TipoEstadoRegistro;
import net.rokefeler.sigac.modelo.tipos.TipoGrupoSanguineo;
import net.rokefeler.sigac.modelo.tipos.TipoSexo;
import net.rokefeler.sigac.security.Seguridad;
import net.rokefeler.sigac.util.cdi.CDIServiceLocator;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.inject.Inject;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Jose Roque el 09/08/2015.
 * Email: rokefeler@gmail.com
 */
@Entity(name="tpersona")
public class Persona implements Serializable {

    @Id
    @Column(name="id_Persona", nullable = false, length= 15)
    private String id;

    @Column(name="codanterior_Persona", nullable = true, length= 15)
    private String codanterior;

    @NotBlank(message = "Ingrese Ap. Paterno, si no lo tiene, digite un guión -") @Size(max = 35)
    @Column(name="apepat_Persona", nullable = false, length= 35)
    private String apepat;

    @NotBlank(message = "Ingrese Ap. Materno") @Size(max = 35)
    @Column(name="apemat_Persona", nullable = false, length= 35)
    private String apemat;

    @NotBlank @Size(max = 80)
    @Column(name="nombres_Persona", nullable = false, length= 80)
    private String nombres;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="gruposanguineo_Persona", nullable=false, length = 10)
    private TipoGrupoSanguineo gruposanguineo;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="estadoCivil_Persona", nullable=false, length = 10)
    private TipoEstadoCivil estadocivil;

    @Temporal(TemporalType.DATE)
    @Column(name = "fnac_Persona", nullable = true)
    private Date fnac;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="sexo_Persona", nullable=false, length = 10)
    private TipoSexo sexo;

    @Embedded @Valid
    private Direccion direccion;

    @Column(name="fijo_Persona", nullable = true, length= 15)
    private String fijo;

    @Column(name="movil_Persona", nullable = true, length= 15)
    private String movil;

    @Email
    @Column(name="email_Persona", nullable = true, length= 120)
    private String email;

    @NotNull(message = "Debe Seleccionar un País de Origen")
    @ManyToOne(fetch=FetchType.LAZY )
    @JoinColumn(name="idPaisIso_Persona")
    private Pais pais; //Nacionalidad

    @ManyToOne(fetch=FetchType.LAZY,optional=false) //si no es EAGER, no se selecciona el Distrito.
    @JoinColumn(name="idDistritoNacimiento_Persona", nullable = true)
    private UbigeoDistrito idDistritoNacimiento; //

    @Column(name="foto_Persona", nullable = true, length= 256)
    private String foto;

    @NotNull(message = "Seleccione Tipo de Doc.Identidad")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcIden_Persona", nullable = false)
    private Codigo idcIden;

    @Column(name="nrodoc_Persona", nullable = true, length= 25)
    private String nrodoc;

    @Column(name="esAlumno_Persona", nullable = true)
    private boolean esAlumno;

    @Column(name="esDocente_Persona", nullable = true)
    private boolean esDocente;

    @Column(name="esEmpleado_Persona", nullable = true)
    private boolean esEmpleado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechacreacion_Persona", nullable = true)
    private java.util.Date fechacreacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_Persona", nullable = true)
    private java.util.Date fecha;

    @NotNull
    @Column(name="idLogin_Persona", nullable = false)
    private String idLogin;

    @NotNull(message = "Estado de Registro no puede ser NULO o Vacio")
    @Enumerated(EnumType.STRING)
    @Column(name="estado_Persona", nullable=false, length = 25)
    private TipoEstadoRegistro estado;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id= id;
    }

    public String getCodanterior() {
        return codanterior;
    }
    public void setCodanterior(String codanterior) {
        this.codanterior = codanterior;
    }

    public String getApepat() {
        return apepat;
    }
    public void setApepat(String apepat) {
        this.apepat=StringUtils.upperCase(apepat);
    }

    public String getApemat() {
        return apemat;
    }
    public void setApemat(String apemat) {
        this.apemat=StringUtils.upperCase(apemat);
    }

    public String getNombres() {
        return this.nombres;
    }
    public void setNombres(String nombres) {
        this.nombres=StringUtils.upperCase(nombres);
    }


    public TipoGrupoSanguineo getGruposanguineo() {
        return gruposanguineo;
    }
    public void setGruposanguineo(TipoGrupoSanguineo gruposanguineo) {
        this.gruposanguineo = gruposanguineo;
    }


    public TipoEstadoCivil getEstadocivil() {
        return estadocivil;
    }
    public void setEstadocivil(TipoEstadoCivil estadocivil) {
        this.estadocivil = estadocivil;
    }

    public Date getFnac() {
        return fnac;
    }
    public void setFnac(Date fnac) {
        this.fnac = fnac;
    }

    public TipoSexo getSexo() {
        return sexo;
    }
    public void setSexo(TipoSexo sexo) {
        this.sexo = sexo;
    }

    //campo embebido, vea Clase Direccion
    public Direccion getDireccion() {
        return direccion;
    }
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }


    public String getFijo() {
        return fijo;
    }
    public void setFijo(String fijo) {
        this.fijo = fijo;
    }

    public String getMovil() {
        return movil;
    }
    public void setMovil(String movil) {
        this.movil = movil;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public Pais getPais() {
        return pais;
    }
    public void setPais(Pais pais) {
        this.pais = pais;
    }


    public UbigeoDistrito getIdDistritoNacimiento() {
        return idDistritoNacimiento;
    }
    public void setIdDistritoNacimiento(UbigeoDistrito idDistritoNacimiento) {
        this.idDistritoNacimiento = idDistritoNacimiento;
    }


    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }


    public Codigo getIdcIden() {
        return idcIden;
    }
    public void setIdcIden(Codigo idcIden) {
        this.idcIden = idcIden;
    }


    public String getNrodoc() {
        return nrodoc;
    }
    public void setNrodoc(String nrodoc) {
        this.nrodoc = nrodoc;
    }

    public boolean isEsAlumno() {
        return esAlumno;
    }
    public void setEsAlumno(boolean esAlumno) {
        this.esAlumno = esAlumno;
    }

    public boolean isEsDocente() {
        return esDocente;
    }
    public void setEsDocente(boolean esDocente) {
        this.esDocente = esDocente;
    }

    public boolean isEsEmpleado() {
        return esEmpleado;
    }
    public void setEsEmpleado(boolean esEmpleado) {
        this.esEmpleado = esEmpleado;
    }


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getIdLogin() {
        return idLogin;
    }
    public void setIdLogin(String idLogin) {
        this.idLogin = idLogin;
    }


    public TipoEstadoRegistro getEstado() {
        return estado;
    }
    public void setEstado(TipoEstadoRegistro estado) {
        this.estado = estado;
    }

    @Transient
    public String getRazon() {
        String razon=" ";
        try {
            if(!this.apepat.equals("-"))
                razon = this.apepat;
            if(!this.apemat.equals("-"))
                razon = razon.concat(" ").concat(this.apemat);
            razon = razon.concat(", ").concat(this.nombres);
        } catch (Exception e) {
            razon=null;
        }
        return StringUtils.trim(razon);
    }
    @PrePersist
    @PreUpdate
    public void ActualizaModificacion() {
        //prueba 11.02.16
        Seguridad seguridad;
        this.setFecha(new Date());
            seguridad= CDIServiceLocator.getBean(Seguridad.class);
        this.setIdLogin(seguridad.getLogin().getIdLogin());

        if (this.fechacreacion == null) {
            this.fechacreacion = new Date();
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false;
        Persona persona = (Persona) o;
        return Objects.equals(getId(), persona.getId()) &&
                Objects.equals(getEmail(), persona.getEmail());
    }

    /****************************************/

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
