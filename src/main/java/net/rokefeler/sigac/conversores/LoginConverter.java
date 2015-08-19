package net.rokefeler.sigac.conversores;

import net.rokefeler.sigac.modelo.Login;
import net.rokefeler.sigac.repositorio.LoginRepositorio;
import net.rokefeler.sigac.util.cdi.CDIServiceLocator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass=Login.class)
public class LoginConverter implements Converter{

	private LoginRepositorio loginRepositorio;

	public LoginConverter() {
		this.loginRepositorio = (LoginRepositorio) CDIServiceLocator.getBean(LoginRepositorio.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Login retorno = null;

		if (value != null) {
			retorno = this.loginRepositorio.buscarLoginporId(value);
		}

		return retorno;
	}
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value!=null){
			Login login= (Login) value;
			return login.getIdLogin() == null ? null :  login.getIdLogin().toString();
		}
		return "";
	}
}
