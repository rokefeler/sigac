package net.rokefeler.sigac.modelo;

import net.rokefeler.sigac.modelo.tipos.TipoEstadoRegistro;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by Jose Roque el 09/08/2015.
 * Email: rokefeler@gmail.com
 */
@Entity
@Table(name = "tsecurityrollogin")
public class RolLogin implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_RolLogin", nullable = false)
    private int Id;

    @NotBlank
    @Column(name = "nombre_RolLogin", nullable = false, length = 60)
    private String nombre;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_RolLogin", nullable = false, length = 15)
    private TipoEstadoRegistro estado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_RolLogin", nullable = false)
    private Calendar fecha;


    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoEstadoRegistro getEstado() {
        return estado;
    }
    public void setEstado(TipoEstadoRegistro estado) {
        this.estado = estado;
    }

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
    public int hashCode() {
        return Id;
    }

    @Override
    public String toString() {
        return "RolLogin [Id=" + Id + ", nombreRol=" + nombre + "]";
    }
}
