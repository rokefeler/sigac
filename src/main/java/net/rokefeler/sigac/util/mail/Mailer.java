package net.rokefeler.sigac.util.mail;

import javax.enterprise.context.RequestScoped;
import java.io.Serializable;

//import com.outjected.email.api.MailMessage;
//import com.outjected.email.api.SessionConfig;
//import com.outjected.email.impl.MailMessageImpl;

@RequestScoped
public class Mailer implements Serializable{

	private static final long serialVersionUID = 1L;

//	@Inject
//	private SessionConfig sessionConfig;
//	
//	public MailMessage nuevoEmail(){
//		return new MailMessageImpl(this.sessionConfig);
//	}
	
}
