/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.Beans;

import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import sv.edu.udb.Data.modelos.*;
import sv.edu.udb.Services.*;
import java.util.stream.Collectors;
/**
 *
 * @author DavidMguel
 */
@Named(value = "crudCdBean")
@ManagedBean
@SessionScoped
public class CrudCdBean implements Serializable{

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
    private List<Cd> cd;
    private List<Categoria> categorias;
    private List<Estante> estantes;
    private Cd cdEdit;
    private Map<String, Object> opcionesCategoria;
    private Map<String, Object> opcionesEstante;
    private final ItemsService itemsService;
    private final CatalogosService catalogosService;
    
public CrudCdBean() {
         this.itemsService = new ItemsService();
         this.catalogosService = new CatalogosService();
    }

    @PostConstruct
    public void init(){
        this.cdEdit= itemsService.getCd(idCategoria)
        this.categorias = catalogosService.getCategorias();
        this.estantes = catalogosService.getEstantes(null);
        cdEdit = new Cd();
        construirOpcionesCategoria();
        construirOpcionesEstante();
    }
    
    public List<Cd> getTesis(){
        return cd;
    }
    
    public Cd getTesisEdit(){
        return  cdEdit;
    }
    
    public void agregarEditarTesis(){
        Cd cd = cdEdit;
        if(cdEdit.id_cd== 0){
            itemsService.insertarCd(cd);
        }
        else {
            itemsService.editarCd(cd);
        }
        
        this.cd = itemsService.getListadoCds();
    }
    
}