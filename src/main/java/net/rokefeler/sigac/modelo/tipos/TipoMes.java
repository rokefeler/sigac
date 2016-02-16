package net.rokefeler.sigac.modelo.tipos;

/**
 * Created by Jose Roque el 15/02/2016.
 * Email: rokefeler@gmail.com
 */
public enum TipoMes {
    ENERO("Enero"),
    FEBRERO("Febrero"),
    MARZO("Marzo"),
    ABRIL("Abril"),
    MAYO("Mayo"),
    JUNIO("Junio"),
    JULIO("Julio"),
    AGOSTO("Agosto"),
    SETIEMBRE("Setiembre"),
    OCTUBRE("Octubre"),
    NOVIEMBRE("Noviembre"),
    DICIEMBRE("Diciembre");

    private String descripcion;

    TipoMes(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}