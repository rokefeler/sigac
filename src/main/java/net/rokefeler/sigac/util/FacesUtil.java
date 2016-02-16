package net.rokefeler.sigac.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static java.util.Calendar.YEAR;

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

    public static String NombreDeMes(int n)
    {
        String cMes;
        switch (n)
        {
            case 1:
                cMes = "ENERO";
                break;
            case 2:
                cMes = "FEBRERO";
                break;
            case 3:
                cMes = "MARZO";
                break;
            case 4:
                cMes = "ABRIL";
                break;
            case 5:
                cMes = "MAYO";
                break;
            case 6:
                cMes = "JUNIO";
                break;
            case 7:
                cMes = "JULIO";
                break;
            case 8:
                cMes = "AGOSTO";
                break;
            case 9:
                cMes = "SETIEMBRE";
                break;
            case 10:
                cMes = "OCTUBRE";
                break;
            case 11:
                cMes = "NOVIEMBRE";
                break;
            case 12:
                cMes = "DICIEMBRE";
                break;
            default:
                cMes="ERROR";
                break;
        }
        return cMes;
    }

    public static List<String> getYearsPasados() {
        int year = (Calendar.getInstance ()).get(YEAR);
        List<String> years=new ArrayList<>();
        for(int i=1920; i<=year; i++)
            years.add(String.valueOf(i).toString());
        return years;
    }
}
