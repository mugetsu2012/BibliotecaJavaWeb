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
 * @author Douglas
 */
@Named(value = "crudEstantesBean")
@ManagedBean
@SessionScoped
public class CrudEstantesBean implements Serializable {

    private final CatalogosService catalogosServices;
    private List<Estante> estantes;
    private Estante estanteEdit;
    private String input;
    
    
    public CrudEstantesBean() {
        this.catalogosServices = new CatalogosService();
    }
    
    @PostConstruct
    public void init(){
        this.estantes = catalogosServices.getEstantes(null);
        estanteEdit = new Estante();
    }
    
    public List<Estante> getEstantes(){
        return estantes;
    }
    
    public Estante getEstanteEdit(){
        return estanteEdit;
    }
    
    public void buscarTexto(String texto){
        /*this.estantes = this.estantes.stream()
                .filter(line -> line.nombre.contains(texto.toLowerCase()) || texto.isEmpty())
                .collect(Collectors.toList());*/
        this.estantes = catalogosServices.getEstantes(texto);
        this.estanteEdit = null;
    }
    
    public void submitBusqueda() {  
    buscarTexto(input);
  }
    
    public void agregarEditarEstante(){
        Estante estante = estanteEdit;
        if(estanteEdit.codigo == 0){
            catalogosServices.insertarEstante(estante);
        }
        else {
            catalogosServices.editarEstante(estante);
        }
        
        this.estantes = catalogosServices.getEstantes(null);
    }
    
    public void marcarEditarEstante(Estante estante){
        this.estanteEdit = estante;
    }

    public String getInput() {
    return input;
  }

    public void setInput(String input) {
    this.input = input;
  }
  
  
    
}
