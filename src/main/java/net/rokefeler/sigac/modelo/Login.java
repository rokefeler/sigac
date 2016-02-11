package net.rokefeler.sigac.modelo;

import net.rokefeler.sigac.modelo.tipos.TipoEstadoRegistro;
import org.apache.commons.lang.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Jose Roque el 09/08/2015.
 * Email: rokefeler@gmail.com
 */
@Entity(name="tsecuritylogin")
public class Login implements Serializable {

    @Id @NotNull
    @Column(name="id_Login", nullable = false, length= 15)
    private String idLogin;

    //Lazy, se recupera cuando se consulte, Eager, se recupera siempre que se recupere una instancia
    @ManyToOne (fetch = FetchType.LAZY)//
    @JoinColumn(name="idPersona_Login", nullable = false)
    private Persona idPersona;

    @Column(name="avatar_Login", nullable=true, length = 256)
    private String avatar;

    @Column(name="esSuperuser_Login", nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean esSuperUser;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="estado_Login", nullable=false, length = 25)
    private TipoEstadoRegistro estado;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "tsecuritylogin_roles", joinColumns = @JoinColumn(name="id_Login"),
            inverseJoinColumns = @JoinColumn(name = "id_RolLogin"))
    private List<RolLogin> roles = new ArrayList<RolLogin>();

    @Column(name="pwd_Login", nullable = true, length =256)
    //@Lob @Basic(fetch= FetchType.EAGER) //probando campos byte
    private String pwd;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_Login", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date fecha;
    //private String razon;

    public String getIdLogin() {
        return idLogin;
    }
    public void setIdLogin(String idLogin) {
        this.idLogin = StringUtils.upperCase(idLogin);
    }

    public Persona getIdPersona() {
        return idPersona;
    }
    public void setIdPersona(Persona idpersona) {
        this.idPersona = idpersona;
    }

    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isEsSuperUser() {
        return esSuperUser;
    }
    public void setEsSuperUser(boolean esSuperUser) {
        this.esSuperUser = esSuperUser;
    }

    public TipoEstadoRegistro getEstado() {
        return estado;
    }
    public void setEstado(TipoEstadoRegistro estado) {
        this.estado = estado;
    }

    public List<RolLogin> getRoles() {
        return roles;
    }
    public void setRoles(List<RolLogin> roles) {
        this.roles = roles;
    }

    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Transient
    public String getRazon() {
        return idPersona.getRazon();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Login that = (Login) o;
        return !(idLogin != null ? !idLogin.equals(that.idLogin) : that.idLogin != null);
    }

    @Override
    public int hashCode() {
        return idLogin != null ? idLogin.hashCode() : 0;
    }
}
