package net.rokefeler.sigac.conversores;

import net.rokefeler.sigac.modelo.UbigeoDepartamento;
import net.rokefeler.sigac.repositorio.UbigeoRepositorio;
import net.rokefeler.sigac.util.cdi.CDIServiceLocator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = UbigeoDepartamento.class, value = "departamentoConverter")
public class DepartamentoConverter implements Converter {

    private UbigeoRepositorio ubigeoRepositorio;

    public DepartamentoConverter() {
        this.ubigeoRepositorio = CDIServiceLocator.getBean(UbigeoRepositorio.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
    	UbigeoDepartamento departamento= null;

    	try {
            //if(StringUtils.isEmpty(value))
            //    value="00";
			if (value != null ) //&& !value.equals("")
				departamento = ubigeoRepositorio.obtenerDepartamento(value);
    	} catch (Exception e) {
			departamento=null;
		}
        return departamento;
    }
    
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && !value.equals("")) {
			UbigeoDepartamento departamento = (UbigeoDepartamento) value;
			return departamento.getId();
		}
		return null;
	}

}