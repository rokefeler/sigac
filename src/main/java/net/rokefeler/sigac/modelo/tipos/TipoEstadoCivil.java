package net.rokefeler.sigac.modelo.tipos;

/**
 * Created by Jose Roque el 09/08/2015.
 * Email: rokefeler@gmail.com
 */
public enum TipoEstadoCivil {

    SOLTERO("Soltero(a)"),
    CASADO("Casado(a)"),
    CONVIVIENTE("Conviviente"),
    VIUDO("Viudo(a)"),
    DIVORCIADO("Divorciado(a)"),
    FALLECIDO("Fallecido(a)");

    private String descripcion;

    TipoEstadoCivil(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}