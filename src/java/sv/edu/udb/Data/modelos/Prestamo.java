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
public class Prestamo {

    /**
     * @return the id_prestamo
     */
    public long getId_prestamo() {
        return id_prestamo;
    }

    /**
     * @param id_prestamo the id_prestamo to set
     */
    public void setId_prestamo(long id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    /**
     * @return the id_item
     */
    public long getId_item() {
        return id_item;
    }

    /**
     * @param id_item the id_item to set
     */
    public void setId_item(long id_item) {
        this.id_item = id_item;
    }

    /**
     * @return the id_carne_autoriza
     */
    public String getId_carne_autoriza() {
        return id_carne_autoriza;
    }

    /**
     * @param id_carne_autoriza the id_carne_autoriza to set
     */
    public void setId_carne_autoriza(String id_carne_autoriza) {
        this.id_carne_autoriza = id_carne_autoriza;
    }

    /**
     * @return the id_carne_solicita
     */
    public String getId_carne_solicita() {
        return id_carne_solicita;
    }

    /**
     * @param id_carne_solicita the id_carne_solicita to set
     */
    public void setId_carne_solicita(String id_carne_solicita) {
        this.id_carne_solicita = id_carne_solicita;
    }

    /**
     * @return the fecha_prestamo
     */
    public String getFecha_prestamo() {
        return fecha_prestamo;
    }

    /**
     * @param fecha_prestamo the fecha_prestamo to set
     */
    public void setFecha_prestamo(String fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    /**
     * @return the fecha_pactada
     */
    public String getFecha_pactada() {
        return fecha_pactada;
    }

    /**
     * @param fecha_pactada the fecha_pactada to set
     */
    public void setFecha_pactada(String fecha_pactada) {
        this.fecha_pactada = fecha_pactada;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the fechaDevolucion
     */
    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * @param fechaDevolucion the fechaDevolucion to set
     */
    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * @return the moraCancelada
     */
    public double getMoraCancelada() {
        return moraCancelada;
    }

    /**
     * @param moraCancelada the moraCancelada to set
     */
    public void setMoraCancelada(double moraCancelada) {
        this.moraCancelada = moraCancelada;
    }

    /**
     * @return the nombreItem
     */
    public String getNombreItem() {
        return nombreItem;
    }

    /**
     * @param nombreItem the nombreItem to set
     */
    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    
    
    public long id_prestamo;
    public long id_item;
    public String id_carne_autoriza;
    public String id_carne_solicita;
    public String fecha_prestamo;
    public String fecha_pactada;
    public String descripcion;
    public String fechaDevolucion;
    public double moraCancelada;
    public String nombreItem;
    
    
    
    
}
