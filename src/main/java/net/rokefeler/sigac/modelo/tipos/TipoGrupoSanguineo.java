package net.rokefeler.sigac.modelo.tipos;

/**
 * Created by Jose Roque el 09/08/2015.
 * Email: rokefeler@gmail.com
 */
public enum TipoGrupoSanguineo {

    A_PLUS("A+"),
    A_MINUS("A-"),
    B_PLUS("B+"),
    B_MINUS("B-"),
    O_PLUS("O+"),
    O_MINUS("O-"),
    AB_PLUS("AB+"),
    AB_MINUS("AB-");
    private String descripcion;

    TipoGrupoSanguineo(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}