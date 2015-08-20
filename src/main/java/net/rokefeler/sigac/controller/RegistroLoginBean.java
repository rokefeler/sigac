package net.rokefeler.sigac.controller;

import net.rokefeler.sigac.modelo.RolLogin;
import net.rokefeler.sigac.modelo.Login;
import net.rokefeler.sigac.repositorio.RolLoginRepositorio;
import net.rokefeler.sigac.service.RegistroLoginService;
import net.rokefeler.sigac.util.FacesUtil;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class RegistroLoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private RolLoginRepositorio grupoRepositorio;

	@Inject
	private RegistroLoginService loginService;

	private Login login;
	private List<RolLogin> roles = new ArrayList<>();
	private RolLogin rol;



	public RegistroLoginBean() {
		login = new Login();
	}

	public void inicializar() {
		if (!FacesUtil.isPostback()) {
			roles = grupoRepositorio.listarRolLogin();
		}
	}

	public Login getLogin() {
		return login;
	}

	/*public TipoPersona[] getTiposPersona() {
		return TipoPersona.values();
	}*/

	public void registrarUsuario() {
		this.login = loginService.registrarUsuario(this.login);
		limpiarFormulario();
		FacesUtil.adicionarMensajeInfo("El Usuario se registro correctamente");
	}

	private void limpiarFormulario() {
		login = new Login();

	}

	public void setLogin(Login login) {
		this.login = login;

	}

	public boolean isEditando() {
		return this.login.getIdLogin() != null;
	}

	public RolLogin getRol() {
		return rol;
	}

	public void setRol(RolLogin rol) {
		this.rol = rol;
	}

	public List<RolLogin> getRoles() {
		return roles;
	}

	public void eliminarRol() {

		List<RolLogin> rolesLogin = this.login.getRoles();
		if (!rolesLogin.isEmpty()) {

			if (rolesLogin.contains(rol)) {

				rolesLogin.remove(rol);
			}
		}

	}

	public void agregarRol() {

		List<RolLogin> rolesLogin = this.login.getRoles();

		if (rolesLogin.isEmpty()) {

			rolesLogin.add(rol);
		} else {
			if (!rolesLogin.contains(rol)) {

				rolesLogin.add(rol);
			}
		}

	}



    public void addMessage() {
        String summary = "El Estado actual del Usuario es " + this.login.getEstado();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }

}
