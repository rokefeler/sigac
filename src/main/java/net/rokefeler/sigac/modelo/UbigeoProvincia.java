package net.rokefeler.sigac.modelo;

import net.rokefeler.sigac.service.NegocioExcepciones;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jose Roque el 10/08/2015.
 * Email: rokefeler@gmail.com
 */
@Entity(name="TUbigeoProvincia")
public class UbigeoProvincia implements Serializable, Cloneable {

    @Id
    @Column(name="id_Provincia", nullable = false, length = 4)
    private String id;

    @NotNull @NotBlank
    @ManyToOne  //implicito, por defecto no jala datos del Departamento
    @JoinColumn(name="idDepartamento_Provincia", nullable = false)
    private UbigeoDepartamento ubigeoDepartamento;

    @NotBlank
    @Column(name="nombre_Provincia", nullable = false, length = 50)
    private String nombre;

    @OneToMany(mappedBy = "ubigeoProvincia")
    private List<UbigeoDistrito> distritos=new ArrayList<UbigeoDistrito>();



    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public UbigeoDepartamento getUbigeoDepartamento()
    {
        return ubigeoDepartamento;
    }
    public void setUbigeoDepartamento(UbigeoDepartamento ubigeoDepartamento) {
        this.ubigeoDepartamento = ubigeoDepartamento;
    }

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
        if (!(o instanceof UbigeoProvincia)) return false;
        UbigeoProvincia provincia = (UbigeoProvincia) o;
        return getId().equals(provincia.getId());
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object obj;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            throw new NegocioExcepciones(e.getMessage());
        }
        return obj;
    }
}
