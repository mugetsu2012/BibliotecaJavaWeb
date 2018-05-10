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
public class Cd extends Item {

    /**
     * @param id_cd the id_cd to set
     */
    public void setId_cd(long id_cd) {
        this.id_cd = id_cd;
    }

    
    private long id_cd;
    private String capacidad;
    private String nota;
    
    /**
     * @return the capacidad
     */
    public String getCapacidad() {
        return capacidad;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
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
    
    
    public long getId_cd(){
        return id_cd;
    }   
    
}
