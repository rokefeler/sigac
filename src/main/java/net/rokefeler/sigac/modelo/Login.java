package net.rokefeler.sigac.modelo;

import net.rokefeler.sigac.modelo.tipos.TipoEstado;

import javax.annotation.PostConstruct;
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

    private String idLogin;
    private Persona idPersona;
    private String avatar;
    private boolean esSuperUser;
    private TipoEstado estado;
    private List<RolLogin> roles = new ArrayList<RolLogin>();
    private String pwd;
    private Date fecha;
    private String razon;


    @Id
    @Column(name="id_Login", nullable = false, length= 15)
    public String getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(String idLogin) {
        this.idLogin = idLogin;
    }


    //Lazy, se recupera cuando se consulte, Eager, se recupera siempre que se recupere una instancia
    @ManyToOne
    @JoinColumn(name="idPersona_Login", nullable = false)
    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }


    @Column(name="avatar_Login", nullable=true, length = 256)
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Column(name="esSuperuser_Login", nullable = false, columnDefinition = "TINYINT", length = 1)
    public boolean isEsSuperUser() {
        return esSuperUser;
    }

    public void setEsSuperUser(boolean esSuperUser) {
        this.esSuperUser = esSuperUser;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="estado_Login", nullable=false, length = 25)
    public TipoEstado getEstado() {
        return estado;
    }

    public void setEstado(TipoEstado estado) {
        this.estado = estado;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tsecuritylogin_roles", joinColumns = @JoinColumn(name="id_Login"),
            inverseJoinColumns = @JoinColumn(name = "id_RolLogin"))
    public List<RolLogin> getRoles() {
        return roles;
    }
    public void setRoles(List<RolLogin> roles) {
        this.roles = roles;
    }


    @Column(name="pwd_Login", nullable = true, length =256)
    //@Lob @Basic(fetch= FetchType.EAGER) //probando campos byte
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_Login", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Transient
    public String getRazon() {
        return razon;
    }


    @PostConstruct
    public void Login(){
        this.razon = idPersona.getRazon();
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
