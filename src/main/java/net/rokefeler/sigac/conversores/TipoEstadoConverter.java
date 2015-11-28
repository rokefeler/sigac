package net.rokefeler.sigac.conversores;

import net.rokefeler.sigac.modelo.tipos.TipoEstadoRegistro;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = TipoEstadoRegistro.class, value = "tipoEstadoConverter")
public class TipoEstadoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
		TipoEstadoRegistro tipoEstado=null;
    	try {
			if (value != null )
				for(TipoEstadoRegistro t : TipoEstadoRegistro.values()){
					if(value.equals(t)){
						return t;
					}
				}
    	} catch (Exception e) {
			tipoEstado=null;
		}
        return tipoEstado;
    }
    
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && !value.equals("")) {
			TipoEstadoRegistro testado= (TipoEstadoRegistro) value;
			return testado.getDescripcion();
		}
		return null;
	}

}