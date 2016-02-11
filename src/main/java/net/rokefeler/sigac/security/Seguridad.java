package net.rokefeler.sigac.security;

import net.rokefeler.sigac.modelo.Login;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class Seguridad {

	@Inject
	private ExternalContext externalContext;
	
	public String getNombreUsuario(){
		String nombreUsuario = null;
		UsuarioSistema usuarioLogeado = getUsuarioLogeado();
		
		if(usuarioLogeado != null){
			nombreUsuario = usuarioLogeado.getLogin().getIdPersona().getRazon();
		}
		return nombreUsuario;
	}

	public Login getLogin(){
		Login login = null;
		UsuarioSistema usuarioLogeado = getUsuarioLogeado();

		if(usuarioLogeado != null){
			login = usuarioLogeado.getLogin();
		}
		return login;
	}

	@Produces @UsuarioLogeado
	public UsuarioSistema getUsuarioLogeado() {
		
		UsuarioSistema usuario = null;
		
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken)
				FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		if(auth!=null && auth.getPrincipal()!=null){
			usuario = (UsuarioSistema) auth.getPrincipal();
		}
		
		return usuario;
	}
	
	public boolean isEmitirPedidoPermitido(){
		return externalContext.isUserInRole("ADMINISTRADOR") ||
				externalContext.isUserInRole("ADMINISTRATIVO") ||
				externalContext.isUserInRole("SECRETARIA");
	}
	
	public boolean isCancelarPedidoPermitido(){
		return externalContext.isUserInRole("ADMINISTRADOR") ||
				externalContext.isUserInRole("ADMINISTRATIVO") ||
				externalContext.isUserInRole("SECRETARIA");
	}
}
