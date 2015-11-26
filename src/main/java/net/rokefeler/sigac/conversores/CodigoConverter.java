package net.rokefeler.sigac.conversores;

import net.rokefeler.sigac.modelo.Codigo;
import net.rokefeler.sigac.repositorio.CodigoRepositorio;
import net.rokefeler.sigac.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Codigo.class, value = "codigoConverter")
public class CodigoConverter implements Converter {

    private CodigoRepositorio codigoRepositorio;

    public CodigoConverter() {
        this.codigoRepositorio = CDIServiceLocator.getBean(CodigoRepositorio.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
    	Codigo codigo= null;

    	try {
			if (value != null )
				codigo = codigoRepositorio.getbyIdCodigo(value);
    	} catch (Exception e) {
			codigo=null;
		}
        return codigo;
    }
    
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && !value.equals("")) {
			Codigo codigo = (Codigo) value;
			return codigo.getId();
		}
		return null;
	}

}