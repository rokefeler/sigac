package net.rokefeler.sigac.modelo;

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
public class UbigeoProvincia implements Serializable {

    private String id;
    private UbigeoDepartamento ubigeoDepartamento;
    private String nombre;

    /*
    @OneToMany(mappedBy = "ubigeoProvincia")
    private List<UbigeoDistrito> distritos=new ArrayList<UbigeoDistrito>();
    */

    @Id
    @Column(name="id_Provincia", nullable = false, length = 4)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotNull @NotBlank
    @ManyToOne(fetch = FetchType.EAGER)  //implicito, por defecto no jala datos del Departamento
    @JoinColumn(name="idDepartamento_Provincia", nullable = false)
    public UbigeoDepartamento getUbigeoDepartamento()
    {
        return ubigeoDepartamento;
    }

    public void setUbigeoDepartamento(UbigeoDepartamento ubigeoDepartamento) {
        this.ubigeoDepartamento = ubigeoDepartamento;
    }

    @NotBlank
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
