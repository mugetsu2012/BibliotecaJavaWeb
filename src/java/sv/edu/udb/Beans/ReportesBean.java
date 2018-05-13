/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.Beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import sv.edu.udb.Data.modelos.ItemPrestado;
import sv.edu.udb.Services.ReportesService;

/**
 *
 * @author hilde
 */
@Named(value = "reportesBean")
@Dependent
public class ReportesBean {

    List<ItemPrestado> masPrestados;
    ReportesService reporteService;
    
    
    public ReportesBean() {
        this.masPrestados = new ArrayList<>();
        this.reporteService=new ReportesService();
    }

    @PostConstruct
    public void init(){
        masPrestados=reporteService.itemsMasPrestados();
    }

    public List<ItemPrestado> getMasPrestados() {
        return masPrestados;
    }
}
