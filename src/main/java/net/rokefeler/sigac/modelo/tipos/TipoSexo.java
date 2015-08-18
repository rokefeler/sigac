package net.rokefeler.sigac.modelo.tipos;

/**
 * Created by Jose Roque el 09/08/2015.
 * Email: rokefeler@gmail.com
 */
public enum TipoSexo {

    FEMENINO("Femenino"), MASCULINO("Masculino"), EMPRESA("Empresa");

    private String descripcion;

    TipoSexo(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}