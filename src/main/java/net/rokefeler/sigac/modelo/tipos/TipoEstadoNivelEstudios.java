package net.rokefeler.sigac.modelo.tipos;

/**
 * Created by Jose Roque el 12.Feb.2016.
 * Email: rokefeler@gmail.com
 */
public enum TipoEstadoNivelEstudios {
//// NO MODIFICAR EL ORDEN, SE GUARDARA POR ORDEN NUMERICO
    CULMINADO("Culminado"),
    CURSANDO("Cursando"),
    ABANDONADO_APLAZADO("Abandonado/Aplazado");

    private String descripcion;

    TipoEstadoNivelEstudios(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}