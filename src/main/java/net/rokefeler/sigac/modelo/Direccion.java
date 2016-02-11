package net.rokefeler.sigac.modelo;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Jose Roque el 27/11/2015.
 * Email: rokefeler@gmail.com
 */
@Embeddable
public class Direccion implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "Debe Seleccionar un Tipo de vía")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idcTipovia_Persona", nullable = false)
    private Codigo idctipovia;

    @NotEmpty @Size(min=3, max =80, message = "Nombre de via debe tener longitud de 3 a 80 caracteres")
    @Column(name="nombrevia_Persona", nullable = false, length = 80)
    private String nombrevia;

    //@Size(min=1, max=8)
    @Column(name="numerovia_Persona", nullable = true, length = 8)
    private String numerovia;

    //@Null @Size(min=1, max=8)
    @Column(name="kmvia_Persona", nullable = true, length = 8)
    private String kmvia;

    //@Null @Size(min=1, max=8)
    @Column(name="mzvia_Persona", nullable = true, length = 8)
    private String mzvia;

    //@Null @Size(min=1, max=8)
    @Column(name="lotevia_Persona", nullable = true, length = 8)
    private String lotevia;

    //@Null @Size(min=1, max=8)
    @Column(name="intvia_Persona", nullable = true, length = 8)
    private String intvia;

    //@Null @Size(min=1, max=8)
    @Column(name="nrodptovia_Persona", nullable = true, length = 8)
    private String nrodptovia;

    //@Null @Size(min=1, max=8)
    @Column(name="pisovia_Persona", nullable = true, length = 8)
    private String pisovia;

    @NotNull(message = "Debe Seleccionar un Tipo de Zona")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idcTipozona_Persona", nullable = false)
    private Codigo tipozona;

    @NotBlank(message = "Escriba el Nombre de su Zona, según el tipo Seleccionado") @Size(min=3, max=80)
    @Column(name="nombrezona_Persona", nullable = false, length = 80)
    private String nombrezona;

    @ManyToOne(fetch=FetchType.LAZY, optional = false) //si no es EAGER, no se selecciona el Distrito.
    @JoinColumn(name="idDistritoDomicilio_Persona", nullable = true)
    private UbigeoDistrito idDistritoDomicilio;

    public Codigo getIdctipovia() {
        return idctipovia;
    }
    public void setIdctipovia(Codigo idctipovia) {
        this.idctipovia = idctipovia;
    }


    public String getNombrevia() {
        return nombrevia;
    }
    public void setNombrevia(String nombrevia) {
        this.nombrevia = nombrevia;
    }

    public String getNumerovia() {
        return numerovia;
    }
    public void setNumerovia(String numerovia) {
        this.numerovia = numerovia;
    }

    public String getKmvia() {
        return kmvia;
    }
    public void setKmvia(String kmvia) {
        this.kmvia = kmvia;
    }

    public String getMzvia() {
        return mzvia;
    }
    public void setMzvia(String mzvia) {
        this.mzvia = mzvia;
    }

    public String getLotevia() {
        return lotevia;
    }
    public void setLotevia(String lotevia) {
        this.lotevia = lotevia;
    }

    public String getIntvia() {
        return intvia;
    }
    public void setIntvia(String intvia) {
        this.intvia = intvia;
    }

    public String getNrodptovia() {
        return nrodptovia;
    }
    public void setNrodptovia(String nrodptovia) {
        this.nrodptovia = nrodptovia;
    }

    public String getPisovia() {
        return pisovia;
    }
    public void setPisovia(String pisovia) {
        this.pisovia = pisovia;
    }

    public Codigo getTipozona() {
        return tipozona;
    }
    public void setTipozona(Codigo tipozona) {
        this.tipozona = tipozona;
    }

    public String getNombrezona() {
        return nombrezona;
    }
    public void setNombrezona(String nombrezona) {
        this.nombrezona = nombrezona;
    }

    public UbigeoDistrito getIdDistritoDomicilio() {
        return idDistritoDomicilio;
    }

    public void setIdDistritoDomicilio(UbigeoDistrito idDistritoDomicilio) {
        this.idDistritoDomicilio = idDistritoDomicilio;
    }
}