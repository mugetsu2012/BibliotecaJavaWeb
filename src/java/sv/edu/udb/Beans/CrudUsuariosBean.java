/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.Beans;

import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import sv.edu.udb.Data.modelos.*;
import sv.edu.udb.Services.*;
import java.util.stream.Collectors;

/**
 *
 * @author Douglas
 */
@Named(value = "crudUsuariosBean")
@ManagedBean
@SessionScoped
public class CrudUsuariosBean implements Serializable {

    /**
     * @return the carne
     */
    public String getCarne() {
        return carne;
    }

    /**
     * @param carne the carne to set
     */
    public void setCarne(String carne) {
        this.carne = carne;
    }

    /**
     * @return the idRol
     */
    public long getIdRol() {
        return idRol;
    }

    /**
     * @param idRol the idRol to set
     */
    public void setIdRol(long idRol) {
        this.idRol = idRol;
    }

    /**
     * @return the estado
     */
    public Integer getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    private final CatalogosService catalogosServices;
    private final AdminService adminService;
    private List<Usuario> usuarios;    
    private Usuario usuarioEdit;      
    private String carne;
    private long idRol;
    private Integer estado;
    
    public CrudUsuariosBean() {
        this.catalogosServices = new CatalogosService();
        this.adminService = new AdminService();
    }

    @PostConstruct
    public void init() {
        this.usuarios = adminService.getListaUsuarios(null, 0, null);
        usuarioEdit = new Usuario();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario getUsuarioEdit() {
        return usuarioEdit;
    }

    public void buscarUsuarios() {
        
        Integer estadoBsq = getEstado();
        String carneBsq = getCarne();
        long idRolBsq = getIdRol();
        
        estadoBsq = estadoBsq == 4 ? null: estadoBsq;
        carneBsq = carneBsq.isEmpty() ? null : carneBsq;
        this.usuarios = adminService.getListaUsuarios(carneBsq, idRolBsq, estadoBsq);
        this.usuarioEdit = null;
    }    

    public void agregarEditarUsuario() {
        Usuario usuario = usuarioEdit;
        
        DatosPersonales datosPersonales = new DatosPersonales();
        datosPersonales.id_datos_personales = usuarioEdit.id_datos_personales;
        datosPersonales.apellido = usuarioEdit.apellido;
        datosPersonales.direccion = usuarioEdit.direccion;
        datosPersonales.email = usuarioEdit.email;
        datosPersonales.genero = usuarioEdit.genero;
        datosPersonales.id_carne = usuarioEdit.id_carne;
        datosPersonales.nombre = usuarioEdit.nombre;
        datosPersonales.telefono = usuarioEdit.telefono;
        
        Usuario userProbar = adminService.getUsuario(usuario.id_carne);
        if (userProbar == null || userProbar.id_carne == null) {
            adminService.crearUsuario(usuario,datosPersonales);
        } else {
            adminService.editarUsuario(usuario);
            adminService.editarDatosPersonales(datosPersonales);
        }

        this.usuarios = adminService.getListaUsuarios(null, 0, null);
    }

    public void marcarEditarUsuario(Usuario usuario) {
        this.usuarioEdit = usuario;
    }   
}
