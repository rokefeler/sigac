package net.rokefeler.sigac.modelo;

import net.rokefeler.sigac.modelo.tipos.TipoEstadoCivil;
import net.rokefeler.sigac.modelo.tipos.TipoEstadoRegistro;
import net.rokefeler.sigac.modelo.tipos.TipoGrupoSanguineo;
import net.rokefeler.sigac.modelo.tipos.TipoSexo;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
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
    private String id;
    private String codanterior;

    private String apepat;
    private String apemat;
    private String nombres;
    private TipoGrupoSanguineo gruposanguineo;
    private TipoEstadoCivil estadocivil; //
    private Date fnac;
    private TipoSexo sexo;
    /*
    private String direccion;
    private String urbanizacion;
    private String referencia;
    */
    private Direccion direccion;
    private String fijo;
    private String movil;
    private String email;
    private Pais pais; //Nacionalidad
    private UbigeoDistrito idDistritoNacimiento; //

    private String foto;
    private Codigo idcIden;
    private String nrodoc;
    private boolean esAlumno;
    private boolean esDocente;
    private boolean esEmpleado;
    private java.util.Date fecha;
    private String idLogin;
    private TipoEstadoRegistro estado;


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
/*
    @NotBlank
    @Column(name="nombres_Persona", nullable = false, length= 120)
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = StringUtils.upperCase( nombres );
    }*/

    @NotBlank @Size(max = 35)
    @Column(name="apepat_Persona", nullable = false, length= 35)
    public String getApepat() {
        return apepat;
    }

    public void setApepat(String apepat) {
        this.apepat=StringUtils.upperCase(apepat);
    }

    @NotBlank @Size(max = 35)
    @Column(name="apemat_Persona", nullable = false, length= 35)
    public String getApemat() {
        return apemat;
    }

    public void setApemat(String apemat) {
        this.apemat=StringUtils.upperCase(apemat);
    }

    @NotBlank @Size(max = 80)
    @Column(name="nombres_Persona", nullable = false, length= 80)
    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres=StringUtils.upperCase(nombres);
    }

    @NotNull @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name="gruposanguineo_Persona", nullable=false, length = 10)
    public TipoGrupoSanguineo getGruposanguineo() {
        return gruposanguineo;
    }

    public void setGruposanguineo(TipoGrupoSanguineo gruposanguineo) {
        this.gruposanguineo = gruposanguineo;
    }

    @NotNull @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name="estadoCivil_Persona", nullable=false, length = 10)
    public TipoEstadoCivil getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(TipoEstadoCivil estadocivil) {
        this.estadocivil = estadocivil;
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

    /*
    @Column(name="direccion_Persona", nullable = true, length= 160)
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
*/

    //campo embebido, vea Clase Direccion
    @Embedded
    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
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

    @Email
    @Column(name="email_Persona", nullable = true, length= 120)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotNull @NotBlank
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idPaisIso_Persona")
    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @NotNull //TODO verificar esto después
    @ManyToOne(fetch=FetchType.EAGER,optional=false) //si no es EAGER, no se selecciona el Distrito.
    @JoinColumn(name="idDistritoNacimiento_Persona", nullable = true)
    public UbigeoDistrito getIdDistritoNacimiento() {
        return idDistritoNacimiento;
    }

    public void setIdDistritoNacimiento(UbigeoDistrito idDistritoNacimiento) {
        this.idDistritoNacimiento = idDistritoNacimiento;
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
    @Column(name = "fecha_Persona", nullable = true)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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
    /*
    @PostConstruct
    public void Persona(){
try {
            this.razon = apellidos.concat(", ").concat(nombres);
        } catch (Exception e) {
            this.razon="";
        }
    }*/

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
