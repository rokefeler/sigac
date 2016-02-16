package net.rokefeler.sigac.modelo;

import net.rokefeler.sigac.modelo.tipos.TipoEstadoNivelEstudios;
import net.rokefeler.sigac.modelo.tipos.TipoMes;
import net.rokefeler.sigac.modelo.tipos.TipoNivelEstudios;
import net.rokefeler.sigac.util.FacesUtil;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

/**
 * Created by José Roque - rokefeler@gmail.com on 12/02/2016.
 */
@Entity(name="tEstudiosSuperiores")
public class EstudiosSuperiores implements Serializable {
    private Long id;
    private String institucion;
    private TipoNivelEstudios nivelEstudios;
    private Codigo idcAreaDeEstudios;
    private TipoEstadoNivelEstudios tipoEstadoNivelEstudios;
    private String periodoDe;
    private String periodoHasta;
    private String IdLogin;
    private Persona persona;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudios")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "institucion_estudios", nullable = false, length = 100)
    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    @Enumerated(EnumType.STRING)
    @Column(name="nivel_estudios", nullable=false, length = 13)
    public TipoNivelEstudios getNivelEstudios() {
        return nivelEstudios;
    }

    public void setNivelEstudios(TipoNivelEstudios nivelEstudios) {
        this.nivelEstudios = nivelEstudios;
    }

    @NotNull(message = "Seleccione un área de Estudios")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcarea_estudios", nullable = false)
    public Codigo getIdcAreaDeEstudios() {
        return idcAreaDeEstudios;
    }

    public void setIdcAreaDeEstudios(Codigo idcAreaDeEstudios) {
        this.idcAreaDeEstudios = idcAreaDeEstudios;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name="estadonivel_estudios", nullable=false)
    public TipoEstadoNivelEstudios getTipoEstadoNivelEstudios() {
        return tipoEstadoNivelEstudios;
    }

    public void setTipoEstadoNivelEstudios(TipoEstadoNivelEstudios tipoEstadoNivelEstudios) {
        this.tipoEstadoNivelEstudios = tipoEstadoNivelEstudios;
    }

    //Guarda en formato mm-yyyy
    @Column(name = "periodode_estudios", nullable = false, length = 7)
    public String getPeriodoDe() {
        return periodoDe;
    }

    public void setPeriodoDe(String periodoDe) {
        this.periodoDe = periodoDe;
    }


    //Guarda en formato mm-yyyy
    @Column(name = "periodohasta_estudios", nullable = false, length = 7)
    public String getPeriodoHasta() {
        return periodoHasta;
    }

    public void setPeriodoHasta(String periodoHasta) {
        this.periodoHasta = periodoHasta;
    }

    @NotNull
    @Column(name="idLogin_estudios", nullable = false, length = 15)
    public String getIdLogin() {
        return IdLogin;
    }
    public void setIdLogin(String idLogin) {
        IdLogin = idLogin;
    }

    @NotNull(message = "Debe tener una Persona relacionada")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPersona_estudios", nullable = false)
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EstudiosSuperiores)) return false;
        EstudiosSuperiores e = (EstudiosSuperiores) o;
        return Objects.equals(getId(), e.getId());
    }

    /****************************************/

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public EstudiosSuperiores () {
        this.setPeriodoDe("011920");
        this.setPeriodoHasta("019999");
    }

        @Transient
    public String getMesPeriodoDe(){
        String cMes = periodoDe.substring(1,2);
        int nMes = Integer.parseInt(cMes);
        cMes = FacesUtil.NombreDeMes(nMes);
        return cMes + "-" + periodoDe.substring(2,6);
    }

    @Transient
    public String getMesPeriodoHasta(){
        String cYear = periodoDe.substring(2,6);
        int year = Integer.parseInt(cYear);
        int yearActual = Calendar.getInstance().get(Calendar.YEAR);
        if(year>=yearActual)
            return "ACTUALMENTE";
        else {
            String cMes = periodoHasta.substring(1,2);
            int nMes = Integer.parseInt(cMes);
            cMes = FacesUtil.NombreDeMes(nMes);
            return cMes + "-" + periodoHasta.substring(2, 6);
        }
    }

    @Transient
    public boolean getIsPeriodoHastaEqualsActualmente(){
        String cYear = periodoDe.substring(2,6);
        int year = Integer.parseInt(cYear);
        int yearActual = Calendar.getInstance().get(Calendar.YEAR);
        return (year>=yearActual);
    }

}
