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
    private final ItemsService itemsServices;
    private final CatalogosService catalogosService;
    private List<Cd> cds;
    private Cd CdEdit;
    private String input;
    private List<Categoria> categorias;
    private Map<String, Object> opcionesCategoria;
    
    public CrudCdBean(){
        this.itemsServices = new ItemsService();
        this.catalogosService = new CatalogosService();
    }
    
    @PostConstruct
    public void init(){
        this.cds = itemsServices.getListadoCds();
        this.categorias = catalogosService.getCategorias(null);
        CdEdit = new Cd();
        construirOpcionesCategoria();
    }
    
    public List<Cd> getCd(){
        return cds;
    }
    
    public Cd getCdEdit(){
        return CdEdit;
    }
    public void BuscarTexto(String texto){
        //this.cds = itemsServices.getCd(Long.parseLong(texto));
        this.CdEdit = null;
    }
    
    public void submitBusqueda(){
        BuscarTexto(input);
    }
    
    public void agregarEditarCd(){
        Cd cd_ = CdEdit;
        if(CdEdit.getId_cd() == 0){
            itemsServices.insertarCd(cd_);
        }
        else{
            itemsServices.editarCd(cd_);
        }
        this.cds = itemsServices.getListadoCds();
    }
    
    public void marcarEditarCd(Cd cd_){
        this.CdEdit = cd_;
    }
    public String getInput(){
        return input;
    }
    public void setInput(String input){
        this.input = input;
    }
    
    public void construirOpcionesCategoria(){
        opcionesCategoria = new LinkedHashMap<String,Object>();
        for (Iterator<Categoria> i = categorias.iterator(); i.hasNext();) {
            Categoria item = i.next();           
            opcionesCategoria.put(item.getNombre(), item.getCodigo());
        }       
    }
    
    public Map<String, Object> getOpcionesCategoria(){
        return opcionesCategoria;
    }
}
