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
public class Item {

    public long id_item;    
    public long id_categoria;
    public long id_estante;   
    public String nombre;   
    public String descripcion;
    public int unidades_para_prestar;
    public String nombreCategoria;
    
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
     * @return the id_categoria
     */
    public long getId_categoria() {
        return id_categoria;
    }

    /**
     * @param id_categoria the id_categoria to set
     */
    public void setId_categoria(long id_categoria) {
        this.id_categoria = id_categoria;
    }

    /**
     * @return the id_estante
     */
    public long getId_estante() {
        return id_estante;
    }

    /**
     * @param id_estante the id_estante to set
     */
    public void setId_estante(long id_estante) {
        this.id_estante = id_estante;
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
     * @return the unidades_para_prestar
     */
    public int getUnidades_para_prestar() {
        return unidades_para_prestar;
    }

    /**
     * @param unidades_para_prestar the unidades_para_prestar to set
     */
    public void setUnidades_para_prestar(int unidades_para_prestar) {
        this.unidades_para_prestar = unidades_para_prestar;
    }

    /**
     * @return the nombreCategoria
     */
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    /**
     * @param nombreCategoria the nombreCategoria to set
     */
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
    
    
    
    
}
