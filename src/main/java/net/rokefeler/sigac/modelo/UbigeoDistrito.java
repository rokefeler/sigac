package net.rokefeler.sigac.modelo;

import net.rokefeler.sigac.service.NegocioExcepciones;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Jose Roque el 10/08/2015.
 * Email: rokefeler@gmail.com
 */
@Entity(name="TUbigeoDistrito")
public class UbigeoDistrito implements Serializable, Cloneable {
    @Id
    @Column(name="id_Distrito", nullable = false, length = 6)
    private String id;

    @NotNull @NotBlank
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="idProvincia_Distrito", nullable = false)
    UbigeoProvincia ubigeoProvincia;

    @NotBlank
    @Column(name="nombre_Distrito", nullable = false, length = 50)
    private String nombre;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public UbigeoProvincia getUbigeoProvincia() {
        return ubigeoProvincia;
    }
    public void setUbigeoProvincia(UbigeoProvincia ubigeoProvincia) {
        this.ubigeoProvincia = ubigeoProvincia;
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
        if (o == null) return false;

        if(!(o instanceof UbigeoDistrito)) //|| getClass() != o.getClass())
            return false;

        UbigeoDistrito that = (UbigeoDistrito) o;

        if (!id.equals(that.id)) return false;
        return nombre.equals(that.nombre);
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
