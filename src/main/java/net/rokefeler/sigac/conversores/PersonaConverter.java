package net.rokefeler.sigac.conversores;

import net.rokefeler.sigac.modelo.Persona;
import net.rokefeler.sigac.repositorio.PersonaRepositorio;
import net.rokefeler.sigac.util.cdi.CDIServiceLocator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(forClass=Persona.class)
public class PersonaConverter implements Converter{

	private PersonaRepositorio personaRepositorio;

	public PersonaConverter(){
		personaRepositorio = CDIServiceLocator.getBean(PersonaRepositorio.class);
	}
	
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		Persona retorno = null;
		
		if(value!=null){
			retorno = this.personaRepositorio.getbyIdPersonaWithDistrito(value);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if(value!=null){
			Persona persona= (Persona) value;
			return persona.getId();
		}
		return "";
	}
}
