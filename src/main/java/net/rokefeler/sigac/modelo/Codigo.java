package net.rokefeler.sigac.modelo;

import net.rokefeler.sigac.modelo.tipos.TipoEstadoRegistro;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Jose Roque el 10/08/2015.
 * Email: rokefeler@gmail.com
 */
@Entity(name="tcodigo")
public class Codigo implements Serializable {
    private String id;
    private CodigoNumero codigoNumero;
    private String nombre;
    private String referencia;
    private String descripcion;
    private int num;
    private TipoEstadoRegistro estado;
    private Calendar fecha;

    @Id
    @Column(name="id_Codigo", nullable = false, length= 15)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Required
    @ManyToOne(fetch= FetchType.LAZY,optional=false)
    @JoinColumn(name="idCodigoNumero_Codigo", nullable = false)
    public CodigoNumero getCodigoNumero() {
        return codigoNumero;
    }

    public void setCodigoNumero(CodigoNumero codigoNumero) {
        this.codigoNumero = codigoNumero;
    }

    @Column(name="nombre_Codigo", nullable = false, length= 120)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name="referencia_Codigo", nullable = true, length= 120)
    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @Column(name="descrip_Codigo", nullable = true, length= 120)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name="num_Codigo", nullable = true)
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="estado_Codigo", nullable=false)
    public TipoEstadoRegistro getEstado() {
        return estado;
    }

    public void setEstado(TipoEstadoRegistro estado) {
        this.estado = estado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_Codigo", nullable = false)
    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Codigo codigo = (Codigo) o;

        if (num != codigo.num) return false;
        if (!id.equals(codigo.id)) return false;
        if (!codigoNumero.equals(codigo.codigoNumero)) return false;
        if (!nombre.equals(codigo.nombre)) return false;
        if (referencia != null ? !referencia.equals(codigo.referencia) : codigo.referencia != null) return false;
        if (descripcion != null ? !descripcion.equals(codigo.descripcion) : codigo.descripcion != null) return false;
        if (estado != codigo.estado) return false;
        return !(fecha != null ? !fecha.equals(codigo.fecha) : codigo.fecha != null);

    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Codigo)) return false;

        Codigo codigo = (Codigo) o;

        return getId().equals(codigo.getId());
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
