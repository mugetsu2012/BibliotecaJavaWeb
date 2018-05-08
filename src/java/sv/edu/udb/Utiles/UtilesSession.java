/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.Utiles;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Douglas
 */
public class UtilesSession {
    
    //Retorna la session actual
    public static HttpSession getSession(){
        return (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }
    
    //Obtenemos el request actual
    public static HttpServletRequest getRequest(){
        return (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }
    
    public static String getUsuarioActual(){
        HttpSession session = getSession();
        if(session != null) {
            return session.getAttribute("usuario").toString();
        }        
        
        return null;        
    }
    
    public static String getRolActual(){
        HttpSession session = getSession();
        
        if(session != null){
            return session.getAttribute("rol").toString();
        }
        
        return null;        
    }
    
}
