package net.rokefeler.sigac.modelo.tipos;

/**
 * Created by Jose Roque el 09/08/2015.
 * Email: rokefeler@gmail.com
 */
public enum TipoDominioIdioma {

    LEE("Solo lee"),
    ESCRIBE("Solo escribe"),
    LEE_Y_ESCRIBE("Lee y escribe"),
    TRADUCE("Traduce");

    private String descripcion;

    TipoDominioIdioma(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}