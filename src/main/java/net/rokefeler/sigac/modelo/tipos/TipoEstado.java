package net.rokefeler.sigac.modelo.tipos;

/**
 * Created by Jose Roque el 09/08/2015.
 * Descripción: Estados que tendrá Campos de Entidad
 * Email: rokefeler@gmail.com
 */
public enum TipoEstado {
    ANULADO("0 - Anulado - de baja"),
    VIGENTE("1 - Vigente/Activo"),
    SUSPENDIDO("2 - Suspendido");

    private String descripcion;

    TipoEstado(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}
