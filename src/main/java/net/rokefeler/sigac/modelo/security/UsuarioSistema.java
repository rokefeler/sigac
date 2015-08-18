package net.rokefeler.sigac.modelo.security;

import net.rokefeler.sigac.modelo.Login;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UsuarioSistema extends User{

	private static final long serialVersionUID = 1L;
	
	private Login login;
	
	public UsuarioSistema(Login login, Collection<? extends GrantedAuthority> authorities) {
		super(login.getIdLogin() , login.getPwd(), authorities);
		this.login = login;
	}

	public Login getLogin() {
		return login;
	}

}
