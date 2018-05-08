/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.Beans;

import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import sv.edu.udb.Data.modelos.*;
import sv.edu.udb.Services.*;
import sv.edu.udb.Utiles.UtilesGenerales;
import sv.edu.udb.Utiles.UtilesSession;

/**
 *
 * @author Douglas
 */
@Named(value = "paramtrosBean")
@ManagedBean
@SessionScoped
public class ParamtrosBean {

    /**
     * @return the parametro
     */
    public Parametros getParametro() {
        return parametro;
    }

    /**
     * @param parametro the parametro to set
     */
    public void setParametro(Parametros parametro) {
        this.parametro = parametro;
    }

    private AdminService adminService;
    private Parametros parametro;
    /**
     * Creates a new instance of ParamtrosBean
     */
    public ParamtrosBean() {
        adminService = new AdminService();
    }
    
    @PostConstruct
    public void init(){
        setParametro(adminService.getParametros());
    }
    
    public void guardar(){
        adminService.editarParametros(getParametro());
    }
    
}
