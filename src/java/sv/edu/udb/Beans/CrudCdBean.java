/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.Beans;

import javax.inject.Named;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import sv.edu.udb.Data.modelos.*;
import sv.edu.udb.Services.*;
import java.util.stream.Collectors;
import javax.faces.convert.LongConverter;
/**
 *
 * @author yuuta
 */
@Named(value = "crudCdBean")
@ManagedBean
@SessionScoped
public class CrudCdBean implements Serializable{
    /**
     * @return the idCategoria
     */
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
    
    private final ItemsService itemsService;
    private final CatalogosService catalogosService;
    private List<Cd> cds;
    private List<Categoria> categorias;
    private List<Estante> estantes;
    private Cd cdEdit;
    private Map<String, Object> opcionesCategoria;
    private Map<String, Object> opcionesEstante;
    
    private int idCategoria;
    private String nombreBuscar;
    private String autoresBuscar;
    
    

    /**
     * Creates a new instance of CrudLibrosBean
     */
    public CrudCdBean() {
         this.itemsService = new ItemsService();
         this.catalogosService = new CatalogosService();
    }
    
    @PostConstruct
    public void init(){
        this.cds = itemsService.getListadoCds();
        this.categorias = catalogosService.getCategorias("");
        this.estantes = catalogosService.getEstantes(null);
        cdEdit = new Cd();
        construirOpcionesCategoria();
        construirOpcionesEstante();
    }
    
    public List<Cd> getCds(){
        return cds;
    }
    
    public Cd getCdEdit(){
        return cdEdit;
    }
    
    public void agregarEditarCd(){
        Cd cd = cdEdit;        
        if(cdEdit.id_cd == 0){
            itemsService.insertarCd(cd);
        }
        else {
            itemsService.editarCd(cd);
        }
        
        this.cds = itemsService.getListadoCds();
    }
    
    public void buscarCds(String nombre, int categoria){
        this.cds = itemsService.getListadoCds(nombre,categoria);
        this.cdEdit = null;
    }
    
    public void marcarEditarCd(Cd cd){
        this.cdEdit = cd;        
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
