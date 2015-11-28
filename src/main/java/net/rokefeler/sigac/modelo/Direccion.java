package net.rokefeler.sigac.modelo;

import org.hibernate.validator.constraints.NotBlank;
import org.jboss.logging.annotations.Message;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Jose Roque el 27/11/2015.
 * Email: rokefeler@gmail.com
 */
@Embeddable
public class Direccion implements Serializable {
    private static final long serialVersionUID = 1L;

    private Codigo idctipovia;
    private String nombrevia;
    private String numerovia;

    private String kmvia;
    private String mzvia;
    private String lotevia;
    private String intvia;
    private String nrodptovia;
    private String pisovia;
    private Codigo tipozona;
    private String nombrezona;
    private UbigeoDistrito ubigeodomicilio;


    @NotBlank
    @ManyToOne
    @JoinColumn(name="idcTipovia_Persona", nullable = false)
    public Codigo getIdctipovia() {
        return idctipovia;
    }

    public void setIdctipovia(Codigo idctipovia) {
        this.idctipovia = idctipovia;
    }

    @NotBlank @Size(min=3, max =80)
    @Column(name="nombrevia_Persona", nullable = false, length = 80)
    public String getNombrevia() {
        return nombrevia;
    }

    public void setNombrevia(String nombrevia) {
        this.nombrevia = nombrevia;
    }


    @Size(min=1, max=8)
    @Column(name="numerovia_Persona", nullable = true, length = 8)
    public String getNumerovia() {
        return numerovia;
    }

    public void setNumerovia(String numerovia) {
        this.numerovia = numerovia;
    }

    @Size(min=1, max=8)
    @Column(name="kmvia_Persona", nullable = true, length = 8)
    public String getKmvia() {
        return kmvia;
    }

    public void setKmvia(String kmvia) {
        this.kmvia = kmvia;
    }

    @Size(min=1, max=8)
    @Column(name="mzvia_Persona", nullable = true, length = 8)
    public String getMzvia() {
        return mzvia;
    }

    public void setMzvia(String mzvia) {
        this.mzvia = mzvia;
    }

    @Size(min=1, max=8)
    @Column(name="lotevia_Persona", nullable = true, length = 8)
    public String getLotevia() {
        return lotevia;
    }

    public void setLotevia(String lotevia) {
        this.lotevia = lotevia;
    }

    @Size(min=1, max=8)
    @Column(name="intvia_Persona", nullable = true, length = 8)
    public String getIntvia() {
        return intvia;
    }

    public void setIntvia(String intvia) {
        this.intvia = intvia;
    }

    @Size(min=1, max=8)
    @Column(name="nrodptovia_Persona", nullable = true, length = 8)
    public String getNrodptovia() {
        return nrodptovia;
    }

    public void setNrodptovia(String nrodptovia) {
        this.nrodptovia = nrodptovia;
    }

    @Size(min=1, max=8)
    @Column(name="pisovia_Persona", nullable = true, length = 8)
    public String getPisovia() {
        return pisovia;
    }

    public void setPisovia(String pisovia) {
        this.pisovia = pisovia;
    }

    @NotBlank @Message("Debe Seleccionar una Zona")
    @ManyToOne
    @JoinColumn(name="idcTipozona_Persona", nullable = false)
    public Codigo getTipozona() {
        return tipozona;
    }

    public void setTipozona(Codigo tipozona) {
        this.tipozona = tipozona;
    }


    @NotBlank @Size(min=3, max=80) @Message("Debe ingresar el nombre la Zona")
    @Column(name="nombrezona_Persona", nullable = false, length = 80)
    public String getNombrezona() {
        return nombrezona;
    }

    public void setNombrezona(String nombrezona) {
        this.nombrezona = nombrezona;
    }

    @ManyToOne(fetch=FetchType.EAGER) //si no es EAGER, no se selecciona el Distrito.
    @JoinColumn(name="idDistritoDomicilio_Persona", nullable = true)
    public UbigeoDistrito getUbigeodomicilio() {
        return ubigeodomicilio;
    }

    public void setUbigeodomicilio(UbigeoDistrito ubigeodomicilio) {
        this.ubigeodomicilio = ubigeodomicilio;
    }
}