/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.Data.modelos;

/**
 *
 * @author Douglas
 */
public class Usuario {

    /**
     * @return the id_carne
     */
    public String getId_carne() {
        return id_carne;
    }

    /**
     * @param id_carne the id_carne to set
     */
    public void setId_carne(String id_carne) {
        this.id_carne = id_carne;
    }

    /**
     * @return the id_catalogo_roles
     */
    public long getId_catalogo_roles() {
        return id_catalogo_roles;
    }

    /**
     * @param id_catalogo_roles the id_catalogo_roles to set
     */
    public void setId_catalogo_roles(long id_catalogo_roles) {
        this.id_catalogo_roles = id_catalogo_roles;
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

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the nombreRol
     */
    public String getNombreRol() {
        return nombreRol;
    }

    /**
     * @param nombreRol the nombreRol to set
     */
    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    /**
     * @return the genero
     */
    public int getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(int genero) {
        this.genero = genero;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the id_datos_personales
     */
    public long getId_datos_personales() {
        return id_datos_personales;
    }

    /**
     * @param id_datos_personales the id_datos_personales to set
     */
    public void setId_datos_personales(long id_datos_personales) {
        this.id_datos_personales = id_datos_personales;
    }

    
    
    public String id_carne;
    public long id_catalogo_roles;
    public String passWord;
    public int estado;
    public String nombre;
    public String apellido;
    public String nombreRol;
    public int genero;
    public String email;
    public String telefono;
    public String direccion;
    public long id_datos_personales;
    
    
    
}
