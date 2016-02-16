package net.rokefeler.sigac.socket;

import org.primefaces.push.annotation.OnMessage;
import org.primefaces.push.annotation.PushEndpoint;
import org.primefaces.push.impl.JSONEncoder;

import javax.faces.application.FacesMessage;

/**
 * Created by José Roque on 13/02/2016.
 */
@PushEndpoint("/notify")
public class NotifyResource {

    @OnMessage(encoders = {JSONEncoder.class})
    public FacesMessage onMessage(FacesMessage message){
        return message;
    }

}
