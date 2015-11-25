package net.rokefeler.sigac.conversores;

import net.rokefeler.sigac.modelo.UbigeoDistrito;
import net.rokefeler.sigac.repositorio.UbigeoRepositorio;
import net.rokefeler.sigac.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = UbigeoDistrito.class, value = "distritoConverter")
public class DistritoConverter implements Converter {
	private UbigeoRepositorio ubigeoRepositorio;

	public DistritoConverter() {
		this.ubigeoRepositorio = CDIServiceLocator.getBean(UbigeoRepositorio.class);
	}

	@Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
    	UbigeoDistrito distrito= null;
    	try {
            //if(StringUtils.isEmpty(value))
            //    value="000000";
			if (value != null) {
				distrito=ubigeoRepositorio.obtenerDistrito(value);
			}
    	} catch (Exception e) {
			distrito= null;
		}
        return distrito;
    }
    
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && !value.equals("")) {
			UbigeoDistrito distrito = (UbigeoDistrito) value;
			return distrito.getId();
		}
		return null;
	}

}