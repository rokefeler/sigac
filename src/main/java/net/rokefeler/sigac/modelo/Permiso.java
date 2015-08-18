package net.rokefeler.sigac.modelo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Jose Roque el 09/08/2015.
 * Email: rokefeler@gmail.com
 */
@Entity
@Table(name = "tsecurityrolLoginpermiso")
public class Permiso implements Serializable{
    private int id;
    private RolLogin idRolLogin;
    private Entidad identidad;
    private int derecho;

    @javax.persistence.Id
    @GeneratedValue
    @Column(name="id_RolLoginPermiso", nullable=false, length=10)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne()
    @JoinColumn(name = "idRolLogin_RolLoginPermiso", nullable = false)
    public RolLogin getIdRolLogin() {
        return idRolLogin;
    }

    public void setIdRolLogin(RolLogin idRolLogin) {
        this.idRolLogin = idRolLogin;
    }

    @ManyToOne()
    @JoinColumn(name = "IdEntidad_RolLoginPermiso", nullable = false)
    public Entidad getIdEntidad() {
        return identidad;
    }

    public void setIdEntidad(Entidad idEntidad) {
        identidad = idEntidad;
    }

    @Column(name="derecho_RolLoginPermiso", nullable=false)
    public int getDerecho() {
        return derecho;
    }

    public void setDerecho(int derecho) {
        this.derecho = derecho;
    }
}
