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

/**
 *
 * @author Douglas
 */
@Named(value = "crudRevistasBean")
@ManagedBean
@RequestScoped
public class CrudRevistasBean implements Serializable {

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
    
    
    private final ItemsService itemsService;
    private final CatalogosService catalogosService;
    private List<Libro> libros;
    private List<Revista> revistas;
    private List<Categoria> categorias;
    private List<Estante> estantes;
    private Libro libroEdit;
    private Revista revistaEdit;
    private Map<String, Object> opcionesCategoria;
    private Map<String, Object> opcionesEstante;
    
    private int idCategoria;
    private String nombreBuscar;
    
    
    

    /**
     * Creates a new instance of CrudLibrosBean
     */
    public CrudRevistasBean() {
         this.itemsService = new ItemsService();
         this.catalogosService = new CatalogosService();
    }
    
    @PostConstruct
    public void init(){
        this.libros = itemsService.getListadoLibros("", null, "");
        this.revistas = itemsService.getListadoRevistas();
        this.categorias = catalogosService.getCategorias("");
        this.estantes = catalogosService.getEstantes(null);
        libroEdit = new Libro();
        revistaEdit = new Revista();
        construirOpcionesCategoria();
        construirOpcionesEstante();
    }
    
    public List<Libro> getLibros(){
        return libros;
    }
    
    public List<Revista> getRevistas(){
        return revistas;
    }
    
    public Libro getLibroEdit(){
        return libroEdit;
    }
    
    public Revista getRevistaEdit(){
        return revistaEdit;
    }
    
    public void agregarEditarLibro(){
        Libro libro = libroEdit;
        if(libroEdit.id_libro == 0){
            itemsService.insertarLibro(libro);
        }
        else {
            itemsService.editarLibro(libro);
        }
        
        this.libros = itemsService.getListadoLibros("",null,"");
    }
    
    public void agregarEditarRevista(){
        Revista revista = revistaEdit;
        if(revistaEdit.id_revista==0){
            itemsService.insertarRevista(revista);
        }
        else{
            itemsService.editarRevista(revista);
        }
        
        this.revistas = itemsService.getListadoRevistas();
    }
    
    public void buscarLibros(String nombre, String autores, int categoria){
        this.libros = itemsService.getListadoLibros(nombre, categoria, autores);
        this.libroEdit = null;
    }
    
    public void buscarRevistas(String nombre, int categoria){
        this.revistas=itemsService.getListadoRevistas(nombre, idCategoria);
        this.revistaEdit=null;
    }
    
    public void marcarEditarLibro(Libro libro){
        this.libroEdit = libro;        
    }
    
    public void marcarEditarRevista(Revista revista){
        this.revistaEdit=revista;
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
