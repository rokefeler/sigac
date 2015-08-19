package net.rokefeler.sigac.modelo;

import net.rokefeler.sigac.modelo.tipos.TipoEstado;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Jose Roque el 09/08/2015.
 * Email: rokefeler@gmail.com
 */
@Entity
@Table(name = "tsecurityrollogin")
public class RolLogin implements Serializable {

    private int Id;
    private String nombre;
    private TipoEstado estado;
    private Calendar fecha;

    @Id
    @GeneratedValue
    @Column(name = "id_RolLogin", nullable = false)
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @NotBlank
    @Column(name = "nombre_RolLogin", nullable = false, length = 60)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_RolLogin", nullable = false, length = 15)
    public TipoEstado getEstado() {
        return estado;
    }

    public void setEstado(TipoEstado estado) {
        this.estado = estado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_RolLogin", nullable = false)
    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolLogin rolLogin = (RolLogin) o;

        return Id == rolLogin.Id;
    }

    @Override
    public String toString() {
        return "RolLogin [Id=" + Id + ", nombreRol=" + nombre + "]";
    }

    @Override
    public int hashCode() {
        return Id;
    }
}
