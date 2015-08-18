package net.rokefeler.sigac.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Jose Roque el 09/08/2015.
 * Email: rokefeler@gmail.com
 */
@Entity(name="TUbigeoDepartamento")
public class UbigeoDepartamento implements Serializable {
    private String id;
    private String nombre;

    @Id
    @Column(name="id_Departamento", nullable = false, length = 2)
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    @Column(name="nombre_Departamento", nullable = false, length = 30)
    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UbigeoDepartamento that = (UbigeoDepartamento) o;

        if (!id.equals(that.id)) return false;
        return nombre.equals(that.nombre);

    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }
}
