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
public class Tesis extends Item {
    public long id_tesis;
    public String fecha_publicacion;
    public String lugar_desarrollo;
    public String autores;
    
    /**
     * @param id_tesis the id_tesis to set
     */
    public void setId_tesis(long id_tesis) {
        this.id_tesis = id_tesis;
    }
    
    
    public long getId_tesis(){
        return id_tesis;
    }
    
    /**
     * @param fecha_publicacion the fecha_publicacion to set
     */
    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }
    
    
    public String getFecha_publicacion(){
        return fecha_publicacion;
    }
    
    /**
     * @param lugar_desarrollo the lugar_desarrollo to set
     */
    public void setLugar_desarrollo(String lugar_desarrollo) {
        this.lugar_desarrollo = lugar_desarrollo;
    }
    
    public String getLugar_desarrollo(){
        return lugar_desarrollo;
    }
    
    /**
     * @param autores the autores to set
     */
    public void setautores(String autores) {
        this.autores = autores;
    }
    public String getAutores(){
        return autores;
    }   
}
