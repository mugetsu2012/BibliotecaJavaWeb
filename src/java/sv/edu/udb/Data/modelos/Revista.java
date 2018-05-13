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
public class Revista extends Item {
    public long id_revista;
    public String edicion;
    public String editorial;
    public String lugar_publicacion;
    public String fecha_publicacion;
    
    public long getId_revista(){
        return id_revista;
    }        

    public void setId_revista(long id_revista) {
        this.id_revista = id_revista;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setLugar_publicacion(String lugar_publicacion) {
        this.lugar_publicacion = lugar_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }
    
    public String getEdicion(){
        return edicion;
    }
    
    public String getEditorial(){
        return editorial;
    }
    
    public String getLugar_publicacion(){
        return lugar_publicacion;
    }
    public String getFecha_publicacion(){
        return fecha_publicacion;
    }    
    
    
}
