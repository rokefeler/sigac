package net.rokefeler.sigac.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Jose Roque el 10/08/2015.
 * Email: rokefeler@gmail.com
 */
@Entity(name="tcodigonumero")
public class CodigoNumero implements Serializable {
    private String id;
    private int numero;
    private String descripcion;


    @Id
    @Column(name="id_Numero", nullable = false, length = 6)
    public String getId() {
        return id;
    }

    public void setId(String tipo) {
        this.id = tipo;
    }

    @Column(name="numero_Numero", nullable = false)
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Column(name="descripcion_Numero", nullable = false, length = 80)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CodigoNumero)) return false;

        CodigoNumero that = (CodigoNumero) o;

        return !(getId() != null ? !getId().equals(that.getId()) : that.getId() != null);
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
