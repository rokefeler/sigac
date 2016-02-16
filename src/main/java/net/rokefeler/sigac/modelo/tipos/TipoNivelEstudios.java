package net.rokefeler.sigac.modelo.tipos;

/**
 * Created by Jose Roque el 12.Feb.2016.
 * Email: rokefeler@gmail.com
 */
public enum TipoNivelEstudios {

    PRIMARIA("Educación Primaria"),
    SECUNDARIA("Educación Secundaria"),
    TECNICO("Técnico"),
    UNIVERSITARIA("Universitario"),
    MAESTRIA("Maestría"),
    DOCTORADO("Doctorado"),
    POST_DOCTORADO("Post Doctorado");

    private String descripcion;

    TipoNivelEstudios(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}