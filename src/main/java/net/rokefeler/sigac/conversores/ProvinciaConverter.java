package net.rokefeler.sigac.conversores;

import net.rokefeler.sigac.modelo.UbigeoProvincia;
import net.rokefeler.sigac.repositorio.UbigeoRepositorio;
import net.rokefeler.sigac.util.cdi.CDIServiceLocator;
import org.apache.commons.lang.StringUtils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(forClass = UbigeoProvincia.class, value="provinciaConverter")
public class ProvinciaConverter implements Converter {

	private UbigeoRepositorio ubigeoRepositorio;

	public ProvinciaConverter() {
		this.ubigeoRepositorio = CDIServiceLocator.getBean(UbigeoRepositorio.class);
	}

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
    	UbigeoProvincia provincia= null;
    	
    	try {
			if(StringUtils.isEmpty(value))
				value="0000";
			if (value != null) {
				provincia=ubigeoRepositorio.obtenerProvincia(value);
			}
    	} catch (Exception e) {
			provincia= null;
		}
        return provincia;
    }
    
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && !value.equals("")) {
			UbigeoProvincia provincia = (UbigeoProvincia) value;
			return provincia.getId();
		}
		return null;
	}

}