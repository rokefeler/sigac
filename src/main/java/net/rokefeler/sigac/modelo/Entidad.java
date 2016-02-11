package net.rokefeler.sigac.modelo;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Jose Roque el 09/08/2015.
 * Email: rokefeler@gmail.com
 */
@Entity
@Table(name = "tsecurityentidad")
public class Entidad  implements Serializable{

    @Id
    @GeneratedValue
    @Column(name="id_Entidad", nullable = false)
    private int id;

    @NotBlank
    @Column(name="nombre_Entidad", nullable=false, length = 35)
    private String nombre;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entidad entidad = (Entidad) o;
        return id == entidad.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
