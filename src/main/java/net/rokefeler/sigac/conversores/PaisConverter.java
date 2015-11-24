package net.rokefeler.sigac.conversores;

import net.rokefeler.sigac.modelo.Pais;
import net.rokefeler.sigac.repositorio.PaisRepositorio;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(forClass = Pais.class, value = "paisConverter")
public class PaisConverter implements Converter {

	@Inject
	PaisRepositorio paisRepositorio;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
    	Pais pais= null;
    	
    	try {
			if (value != null) {
				pais=paisRepositorio.buscarporId(value);
			}
    	} catch (Exception e) {
			pais= null;
		}
        return pais;
    }
    
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && !value.equals("")) {
			Pais pais = (Pais) value;
			return pais.getId();
		}
		return null;
	}

}