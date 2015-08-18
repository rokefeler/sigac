package net.rokefeler.sigac.modelo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Jose Roque el 10/08/2015.
 * Email: rokefeler@gmail.com
 */
@Entity(name="TUbigeoDistrito")
public class UbigeoDistrito implements Serializable {
    private String id;
    UbigeoProvincia ubigeoProvincia;
    private String nombre;

    @Id
    @Column(name="id_Distrito", nullable = false, length = 6)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="idProvincia_Distrito", nullable = false)
    public UbigeoProvincia getUbigeoProvincia() {
        return ubigeoProvincia;
    }

    public void setUbigeoProvincia(UbigeoProvincia ubigeoProvincia) {
        this.ubigeoProvincia = ubigeoProvincia;
    }

    @Column(name="nombre_Distrito", nullable = false, length = 50)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
