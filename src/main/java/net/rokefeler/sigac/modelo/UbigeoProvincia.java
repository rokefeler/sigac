package net.rokefeler.sigac.modelo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Jose Roque el 10/08/2015.
 * Email: rokefeler@gmail.com
 */
@Entity(name="TUbigeoProvincia")
public class UbigeoProvincia implements Serializable {

    private String id;
    private UbigeoDepartamento ubigeoDepartamento;
    private String nombre;

    @Id
    @Column(name="id_Provincia", nullable = false, length = 4)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)  //implicito, por defecto jala datos del Departamento
    @JoinColumn(name="idDepartamento_Provincia", nullable = false)
    public UbigeoDepartamento getUbigeoDepartamento()
    {
        return ubigeoDepartamento;
    }

    public void setUbigeoDepartamento(UbigeoDepartamento ubigeoDepartamento) {
        this.ubigeoDepartamento = ubigeoDepartamento;
    }

    @Column(name="nombre_Provincia", nullable = false, length = 50)
    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
}
