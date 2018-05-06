/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.Beans;

import javax.inject.Named;
import java.io.Serializable;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import sv.edu.udb.Data.modelos.Usuario;
import sv.edu.udb.Services.*;
import sv.edu.udb.Utiles.Enums;
import sv.edu.udb.Utiles.UtilesSession;
/**
 *
 * @author Douglas
 */
@Named(value = "loginBean")
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    /**
     * @return the usuarioActual
     */
    public String getUsuarioActual() {
        HttpSession session = UtilesSession.getSession();        
        return session.getAttribute("usuario") != null ? session.getAttribute("usuario").toString(): null;
    }

    /**
     * @param usuarioActual the usuarioActual to set
     */
    public void setUsuarioActual(String usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    /**
     * @return the rolActual
     */
    public Enums.Roles getRolActual() {
        String rolString = UtilesSession.getRolActual();
        int rolInt = Integer.parseInt(rolString);
        Enums.Roles rol = Enums.Roles.valueOf(rolInt);
        return rol;       
    }

    /**
     * @param rolActual the rolActual to set
     */
    public void setRolActual(Enums.Roles rolActual) {
        this.rolActual = rolActual;
    }

    /**
     * @return the estaLogueado
     */
    public boolean isEstaLogueado() {
        //Mando a sacar una session
        HttpSession session = UtilesSession.getSession();        
        return session.getAttribute("usuario") != null;
    }

    /**
     * @param estaLogueado the estaLogueado to set
     */
    public void setEstaLogueado(boolean estaLogueado) {
        this.estaLogueado = estaLogueado;
    }

    /**
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * @return the loginValido
     */
    public boolean isLoginValido() {
        return loginValido;
    }

    /**
     * @param loginValido the loginValido to set
     */
    public void setLoginValido(boolean loginValido) {
        this.loginValido = loginValido;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the passWord
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * @param passWord the passWord to set
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

     private final AdminService adminService;
     
     private boolean loginValido;
     private boolean estaLogueado;
     private String usuario;
     private String passWord;
     private String error;
     private Enums.Roles rolActual;
     private String usuarioActual;
     
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
        this.adminService = new AdminService();
    }
    
    public void validarLogin(){
        //Mando a probar si el login es valido
        loginValido = adminService.loginValido(usuario, passWord);
        if(loginValido){
            //entra aca si el login es valido
            
            //Extraigo el usuario de la base
            Usuario user = adminService.getUsuario(usuario);
            
            //Mando a sacar una session
            HttpSession session = UtilesSession.getSession();
            
            //Mando a setear las variables de session
            session.setAttribute("usuario", usuario);
            session.setAttribute("rol", user.id_catalogo_roles);
            
            //Intentamos redirigir a una pagina en concreto
            try{
                //Si es un alumno lo mandamos al libro
                if(user.id_catalogo_roles == Enums.Roles.Alumno.getValue()){
                    //Esto debe llevar a la pantalla de prestamos
                    FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
                }
                else{ //Sino al dashboard
                    FacesContext.getCurrentInstance().getExternalContext().redirect("libros.xhtml");
                }
                
            }
            catch (Exception e){
                error = "Ocurrio un terrible error: " + e.getMessage();
            }
            
        }
    }
    
    public void logOut(){
        
        HttpSession session = UtilesSession.getSession();
        session.invalidate();
        
        //Lo mandamos al login
            try{
                FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
            }
            catch (Exception e){
                error = "Ocurrio un terrible error: " + e.getMessage();
            }
        
    }       
    
}
