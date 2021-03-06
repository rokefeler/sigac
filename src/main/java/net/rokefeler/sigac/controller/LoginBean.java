package net.rokefeler.sigac.controller;

import net.rokefeler.sigac.util.FacesUtil;
import org.hibernate.validator.constraints.Email;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;


	@Inject
    private HttpServletRequest request;
	@Inject
    private HttpServletResponse response;
	
	private String email;
	
	public void preRender(){
		if("true".equals(request.getParameter("invalid"))){
			FacesUtil.adicionarMensajeError("Email y/o Contraseña no es correcta");
		}
	}
	
	public void login() throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/j_spring_security_check");
		dispatcher.forward(request, response);

		//facesContext.responseComplete();
		FacesContext.getCurrentInstance().responseComplete();
	}

	@Email(message = "Ingrese una dirección electrónica válida")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
