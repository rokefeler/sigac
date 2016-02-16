package net.rokefeler.sigac.conversores;

import net.rokefeler.sigac.modelo.EstudiosSuperiores;
import net.rokefeler.sigac.repositorio.EstudiosSuperioresRepositorio;
import net.rokefeler.sigac.util.cdi.CDIServiceLocator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(forClass=EstudioSuperiorConverter.class, value = "estudioSuperiorConverter")
public class EstudioSuperiorConverter implements Converter{

	private EstudiosSuperioresRepositorio estudiosSuperioresRepositorio;

	public EstudioSuperiorConverter(){
		estudiosSuperioresRepositorio = CDIServiceLocator.getBean(EstudiosSuperioresRepositorio.class);
	}
	
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		EstudiosSuperiores retorno = null;
		
		if(value!=null){
			retorno = this.estudiosSuperioresRepositorio.getbyIdEstudios(Long.valueOf(value).longValue());
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if(value!=null){
			EstudiosSuperiores estudiosSuperiores= (EstudiosSuperiores) value;
			return estudiosSuperiores.getId().toString();
		}
		return "";
	}
}
