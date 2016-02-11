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
    @Id
    @GeneratedValue
    @Column(name="id_RolLoginPermiso", nullable=false, length=10)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "idRolLogin_RolLoginPermiso", nullable = false)
    private RolLogin idRolLogin;

    @ManyToOne()
    @JoinColumn(name = "IdEntidad_RolLoginPermiso", nullable = false)
    private Entidad identidad;

    @Column(name="derecho_RolLoginPermiso", nullable=false)
    private int derecho;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public RolLogin getIdRolLogin() {
        return idRolLogin;
    }
    public void setIdRolLogin(RolLogin idRolLogin) {
        this.idRolLogin = idRolLogin;
    }

    public Entidad getIdEntidad() {
        return identidad;
    }
    public void setIdEntidad(Entidad idEntidad) {
        identidad = idEntidad;
    }

    public int getDerecho() {
        return derecho;
    }
    public void setDerecho(int derecho) {
        this.derecho = derecho;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        if(!(o instanceof Permiso)) //|| getClass() != o.getClass())
            return false;

        Permiso that = (Permiso) o;

        return id==that.id;
    }

    @Override
    public int hashCode() {
        return getId();
    }
}
