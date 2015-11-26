package net.rokefeler.sigac.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import net.rokefeler.sigac.modelo.RolLogin;
import net.rokefeler.sigac.modelo.Login;
import net.rokefeler.sigac.repositorio.LoginRepositorio;
import net.rokefeler.sigac.util.cdi.CDIServiceLocator;

public class AppUserDetailsService implements UserDetailsService{

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		LoginRepositorio loginRepositorio=CDIServiceLocator.getBean(LoginRepositorio.class);
		Login login = loginRepositorio.getbyEmailLogin(email);
		UsuarioSistema user = null;
		if(login!=null){
			user = new UsuarioSistema(login, getRoles(login));
		}
		return user;
	}

	private Collection<? extends GrantedAuthority> getRoles(Login login) {

		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

		for(RolLogin rol : login.getRoles()){
			authorities.add(new SimpleGrantedAuthority(rol.getNombre().toUpperCase()));
		}

		return authorities;
	}

}
