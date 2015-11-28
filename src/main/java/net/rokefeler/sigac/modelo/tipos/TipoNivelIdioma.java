package net.rokefeler.sigac.modelo.tipos;

/**
 * Created by Jose Roque el 09/08/2015.
 * Email: rokefeler@gmail.com
 */
public enum TipoNivelIdioma {

    BASICO("BASICO"),
    REGULAR("REGULAR"),
    AVANZADO("AVANZADO");

    private String descripcion;

    TipoNivelIdioma(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}