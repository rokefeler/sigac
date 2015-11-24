package net.rokefeler.sigac.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

public class FacesUtil implements Serializable {

	public static boolean isPostback(){

		return FacesContext.getCurrentInstance().isPostback();
	}

	public static boolean isNotPostback() {
		return !isPostback();
	}
	public static void adicionarMensajeError(String mensaje){
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, mensaje));	
	}
	
	public static void adicionarMensajeInfo(String mensaje){
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, mensaje));	
	}
}
