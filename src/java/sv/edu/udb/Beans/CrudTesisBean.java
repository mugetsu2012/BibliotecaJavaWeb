/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.Beans;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import sv.edu.udb.Data.modelos.*;
import sv.edu.udb.Services.*;
import javax.annotation.PostConstruct;
import java.util.stream.Collectors;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author DavidMguel
 */
@Named(value = "crudTesisBean")
@ManagedBean
@RequestScoped


public class CrudTesisBean implements Serializable {
    
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * @param idCategoria the idCategoria to set
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * @return the nombreBuscar
     */
    public String getNombreBuscar() {
        return nombreBuscar;
    }

    /**
     * @param nombreBuscar the nombreBuscar to set
     */
    public void setNombreBuscar(String nombreBuscar) {
        this.nombreBuscar = nombreBuscar;
    }

    /**
     * @return the autoresBuscar
     */
    public String getAutoresBuscar() {
        return autoresBuscar;
    }

    /**
     * @param autoresBuscar the autoresBuscar to set
     */
    public void setAutoresBuscar(String autoresBuscar) {
        this.autoresBuscar = autoresBuscar;
    }
    
    
    
     
    private int idCategoria;
    private String nombreBuscar;
    private String autoresBuscar;
    private final ItemsService itemsService;
    private final CatalogosService catalogosService;
    private List<Tesis> tesis;
    private List<Categoria> categorias;
    private List<Estante> estantes;
    private Tesis tesisEdit;
    private Map<String, Object> opcionesCategoria;
    private Map<String, Object> opcionesEstante;
    
    
    
    public CrudTesisBean() {
         this.itemsService = new ItemsService();
         this.catalogosService = new CatalogosService();
    }
    
    @PostConstruct
    public void init(){
        this.tesis = itemsService.getListadoTesis();
        this.categorias = catalogosService.getCategorias("");
        this.estantes = catalogosService.getEstantes(null);
         tesisEdit = new Tesis();
        construirOpcionesCategoria();
        construirOpcionesEstante();
    }
    
    public List<Tesis> getTesis(){
        return tesis;
    }
    
    public Tesis getTesisEdit(){
        return  tesisEdit;
    }
    
    public void agregarEditarTesis(){
        Tesis Tesis = tesisEdit;
        if(tesisEdit.id_tesis == 0){
            itemsService.insertarTesis(Tesis);
        }
        else {
            itemsService.editarTesis(Tesis);
        }
        
        this.tesis = itemsService.getListadoTesis();
    }
    
    public void buscartesis(String nombre, String autores, int categoria){
        this.tesis = itemsService.getListadoTesis();
        this.tesisEdit = null;
    }
    
    public void marcarEditarTesis(Tesis tesis){
        this.tesisEdit = tesis;
    }
    
    public void construirOpcionesCategoria(){
        opcionesCategoria = new LinkedHashMap<String,Object>();
        for (Iterator<Categoria> i = categorias.iterator(); i.hasNext();) {
            Categoria item = i.next();           
            opcionesCategoria.put(item.nombre, item.codigo);
        }       
    }
    
    public void construirOpcionesEstante(){
        opcionesEstante = new LinkedHashMap<String,Object>();
        for (Iterator<Estante> i = estantes.iterator(); i.hasNext();) {
            Estante item = i.next();           
            opcionesEstante.put(item.nombre, item.codigo);
        }       
    }
    
    public Map<String, Object> getOpcionesCategoria(){
        return opcionesCategoria;
    }
    
    public Map<String, Object> getOpcionesEstante(){
        return opcionesEstante;
    }
}