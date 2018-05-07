/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.Beans;

import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import sv.edu.udb.Data.modelos.*;
import sv.edu.udb.Services.*;
import java.util.stream.Collectors;
/**
 *
 * @author yuuta
 */
@Named(value = "crudCategoriasBean")
@ManagedBean
@SessionScoped
public class CrudCategoriasBean implements Serializable {
    
    private final CatalogosService catalogosServices;
    private List<Categoria> categorias;
    private Categoria categoriaEdit;
    private String input;
    
    public CrudCategoriasBean(){
        this.catalogosServices = new CatalogosService();
    }
    
    @PostConstruct
    public void init(){
        this.categorias = catalogosServices.getCategorias();
        categoriaEdit = new Categoria();
    }
    
    public List<Categoria> getCategoria(){
        return categorias;
    }
    
    public Categoria getCategoriaEdit(){
        return categoriaEdit;
    }
    
    public void BuscarTexto(String texto){
        this.categorias = catalogosServices.getCategorias();
        this.categoriaEdit = null;
    }
    
    public void submitBusqueda(){
        BuscarTexto(input);
    }
    
    public void agregarEditarCategoria(){
        Categoria categoria = categoriaEdit;
        if(categoriaEdit.getCodigo() == 0){
            catalogosServices.insertarCategoria(categoria);
        }
        else{
            catalogosServices.editarCategoria(categoria);
        }
        this.categorias = catalogosServices.getCategorias();
    }
    
    public void marcarEditarCategoria(Categoria categoria){
        this.categoriaEdit = categoria;
    }
    
    public String getInput(){
        return input;
    }
    
    public void setInput(String input){
        this.input = input;
    }
    
}
