package net.rokefeler.sigac.conversores;

import net.rokefeler.sigac.modelo.Login;
import net.rokefeler.sigac.repositorio.LoginRepositorio;
import net.rokefeler.sigac.repositorio.RolLoginRepositorio;
import net.rokefeler.sigac.util.cdi.CDIServiceLocator;
import net.rokefeler.sigac.modelo.RolLogin;
import net.rokefeler.sigac.util.cdi.CDIServiceLocator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(forClass=RolLogin.class)
public class RolLoginConverter implements Converter{


	private RolLoginRepositorio rolLoginRepositorio;

	public RolLoginConverter()
	{
		rolLoginRepositorio = CDIServiceLocator.getBean(RolLoginRepositorio.class);
	}
	
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		RolLogin retorno = null;
		
		if(value!=null){
			int id = new Integer(value);
			retorno = this.rolLoginRepositorio.obtenerGrupo(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if(value!=null){
			RolLogin grupo = (RolLogin) value;
			return grupo.getId() == 0 ? null :  String.valueOf(grupo.getId());
		}
		
		return "";
	}

}
