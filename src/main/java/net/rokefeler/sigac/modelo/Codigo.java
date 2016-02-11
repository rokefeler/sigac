package net.rokefeler.sigac.modelo;

import net.rokefeler.sigac.modelo.tipos.TipoEstadoRegistro;
import org.hibernate.validator.constraints.NotBlank;
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
    @Id
    @Column(name="id_Codigo", nullable = false, length= 15)
    private String id;

    @NotBlank
    @ManyToOne(fetch= FetchType.LAZY,optional=false)
    @JoinColumn(name="idCodigoNumero_Codigo", nullable = false)
    private CodigoNumero codigoNumero;

    @Column(name="nombre_Codigo", nullable = false, length= 120)
    private String nombre;

    @Column(name="referencia_Codigo", nullable = true, length= 120)
    private String referencia;

    @Column(name="descrip_Codigo", nullable = true, length= 120)
    private String descripcion;

    @Column(name="num_Codigo", nullable = true)
    private int num;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="estado_Codigo", nullable=false)
    private TipoEstadoRegistro estado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_Codigo", nullable = false)
    private Calendar fecha;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public CodigoNumero getCodigoNumero() {
        return codigoNumero;
    }
    public void setCodigoNumero(CodigoNumero codigoNumero) {
        this.codigoNumero = codigoNumero;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReferencia() {
        return referencia;
    }
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }

    public TipoEstadoRegistro getEstado() {
        return estado;
    }
    public void setEstado(TipoEstadoRegistro estado) {
        this.estado = estado;
    }

    public Calendar getFecha() {
        return fecha;
    }
    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

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
