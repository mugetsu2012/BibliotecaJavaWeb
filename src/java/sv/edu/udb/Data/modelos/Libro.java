/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.Data.modelos;

/**
 * Cambio prueba
 * @author Douglas
 */
public class Libro extends Item {

    
    public long id_libro;    
    public String nota;
    public String edicion;
    public String fecha_publicacion;
    public String lugar_publicacion;   
    public String nombreAutor;
    public String isbn;
    
    /**
     * @return the id_libro
     */
    public long getId_libro() {
        return id_libro;
    }

    /**
     * @param id_libro the id_libro to set
     */
    public void setId_libro(long id_libro) {
        this.id_libro = id_libro;
    }

    /**
     * @return the nota
     */
    public String getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(String nota) {
        this.nota = nota;
    }

    /**
     * @return the edicion
     */
    public String getEdicion() {
        return edicion;
    }

    /**
     * @param edicion the edicion to set
     */
    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    /**
     * @return the fecha_publicacion
     */
    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    /**
     * @param fecha_publicacion the fecha_publicacion to set
     */
    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    /**
     * @return the lugar_publicacion
     */
    public String getLugar_publicacion() {
        return lugar_publicacion;
    }

    /**
     * @param lugar_publicacion the lugar_publicacion to set
     */
    public void setLugar_publicacion(String lugar_publicacion) {
        this.lugar_publicacion = lugar_publicacion;
    }

    /**
     * @return the nombreAutor
     */
    public String getNombreAutor() {
        return nombreAutor;
    }

    /**
     * @param nombreAutor the nombreAutor to set
     */
    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    
    
}
