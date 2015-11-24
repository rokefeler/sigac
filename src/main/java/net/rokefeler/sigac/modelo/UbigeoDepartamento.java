package net.rokefeler.sigac.modelo;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jose Roque el 09/08/2015.
 * Email: rokefeler@gmail.com
 */
@Entity(name="TUbigeoDepartamento")
public class UbigeoDepartamento implements Serializable {
    private String id;
    private String nombre;

    //private List<UbigeoProvincia> provincias=new ArrayList<>();

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

    @NotNull @NotBlank
    @Column(name="nombre_Departamento", nullable = false, length = 30)
    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

  /*
    @OneToMany(mappedBy = "ubigeoDepartamento")
    public List<UbigeoProvincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<UbigeoProvincia> provincias) {
        this.provincias = provincias;
    }*/

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
