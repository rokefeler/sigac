package net.rokefeler.sigac.modelo.tipos;

/**
 * Created by Jose Roque el 09/08/2015.
 * Descripción: Estados que tendrá Campos de Entidad
 * Email: rokefeler@gmail.com
 */
public enum TipoEstado {
    ANULADO("ANULADO"),
    VIGENTE("VIGENTE"),
    SUSPENDIDO("SUSPENDIDO");

    private String descripcion;

    //constructor
    TipoEstado(String descripcion){
        this.descripcion = descripcion;
    }

    //
    public String getDescripcion(){
        return descripcion;
    }
}
