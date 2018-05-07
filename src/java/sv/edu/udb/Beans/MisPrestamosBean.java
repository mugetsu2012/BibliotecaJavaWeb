/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.Beans;

import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import sv.edu.udb.Data.modelos.*;
import sv.edu.udb.Services.*;
import sv.edu.udb.Utiles.UtilesGenerales;
import sv.edu.udb.Utiles.UtilesSession;

/**
 *
 * @author Douglas
 */
@Named(value = "misPrestamosBean")
@ManagedBean
@SessionScoped
public class MisPrestamosBean implements Serializable {

    /**
     * @return the prestamoInfo
     */
    public Prestamo getPrestamoInfo() {
        return prestamoInfo;
    }

    /**
     * @param prestamoInfo the prestamoInfo to set
     */
    public void setPrestamoInfo(Prestamo prestamoInfo) {
        this.prestamoInfo = prestamoInfo;
    }

    /**
     * @return the carneFiltro
     */
    public String getCarneFiltro() {
        return carneFiltro;
    }

    /**
     * @param carneFiltro the carneFiltro to set
     */
    public void setCarneFiltro(String carneFiltro) {
        this.carneFiltro = carneFiltro;
    }

    /**
     * @return the fechaInicioFiltro
     */
    public String getFechaInicioFiltro() {
        return fechaInicioFiltro;
    }

    /**
     * @param fechaInicioFiltro the fechaInicioFiltro to set
     */
    public void setFechaInicioFiltro(String fechaInicioFiltro) {
        this.fechaInicioFiltro = fechaInicioFiltro;
    }

    /**
     * @return the fechaFinFiltro
     */
    public String getFechaFinFiltro() {
        return fechaFinFiltro;
    }

    /**
     * @param fechaFinFiltro the fechaFinFiltro to set
     */
    public void setFechaFinFiltro(String fechaFinFiltro) {
        this.fechaFinFiltro = fechaFinFiltro;
    }

    /**
     * @return the opcionesItems
     */
    public Map<String, Object> getOpcionesItems() {
        return opcionesItems;
    }

    /**
     * @param opcionesItems the opcionesItems to set
     */
    public void setOpcionesItems(Map<String, Object> opcionesItems) {
        this.opcionesItems = opcionesItems;
    }

    /**
     * @return the prestamos
     */
    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    /**
     * @param prestamos the prestamos to set
     */
    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

      
    
    private PrestamosService prestamosService;
    private ItemsService itemsService;
    private AdminService adminService;
    private String carnetSolicitante;
    private long codigoItemSolicitado;
    private String descripcionPrestamo;
    private String fechaDevolver;
    private boolean prestamoExitoso;
    private String mensajePrestamo;
    private List<Prestamo> prestamos;
    private Map<String, Object> opcionesItems;
    private String fechaInicioFiltro;
    private String fechaFinFiltro;
    private String carneFiltro;
    private Prestamo prestamoInfo;
    
    @PostConstruct
    public void init(){
       filtrarPrestamo();
    }
    
    /**
     * @return the mensajePrestamo
     */
    public String getMensajePrestamo() {
        return mensajePrestamo;
    }

    /**
     * @param mensajePrestamo the mensajePrestamo to set
     */
    public void setMensajePrestamo(String mensajePrestamo) {
        this.mensajePrestamo = mensajePrestamo;
    }

    /**
     * @return the prestamoExitoso
     */
    public boolean isPrestamoExitoso() {
        return prestamoExitoso;
    }

    /**
     * @param prestamoExitoso the prestamoExitoso to set
     */
    public void setPrestamoExitoso(boolean prestamoExitoso) {
        this.prestamoExitoso = prestamoExitoso;
    }
    
    /**
     * @return the fechaDevolver
     */
    public String getFechaDevolver() {
        return fechaDevolver;
    }

    /**
     * @param fechaDevolver the fechaDevolver to set
     */
    public void setFechaDevolver(String fechaDevolver) {
        this.fechaDevolver = fechaDevolver;
    }
    
    /**
     * @return the descripcionPrestamo
     */
    public String getDescripcionPrestamo() {
        return descripcionPrestamo;
    }

    /**
     * @param descripcionPrestamo the descripcionPrestamo to set
     */
    public void setDescripcionPrestamo(String descripcionPrestamo) {
        this.descripcionPrestamo = descripcionPrestamo;
    }
    
    /**
     * @return the carnetSolicitante
     */
    public String getCarnetSolicitante() {
        return carnetSolicitante;
    }

    /**
     * @param carnetSolicitante the carnetSolicitante to set
     */
    public void setCarnetSolicitante(String carnetSolicitante) {
        this.carnetSolicitante = carnetSolicitante;
    }

    /**
     * @return the codigoItemSolicitado
     */
    public long getCodigoItemSolicitado() {
        return codigoItemSolicitado;
    }

    /**
     * @param codigoItemSolicitado the codigoItemSolicitado to set
     */
    public void setCodigoItemSolicitado(long codigoItemSolicitado) {
        this.codigoItemSolicitado = codigoItemSolicitado;
    }

    
    /**
     * Creates a new instance of PrestamoBean
     */
    public MisPrestamosBean() {
        prestamosService = new PrestamosService();
        itemsService = new ItemsService();
        adminService = new AdminService();
    }
    
    
    
    public void filtrarPrestamo(){
        String carnet = UtilesSession.getUsuarioActual();
        if(fechaInicioFiltro == null || fechaInicioFiltro.isEmpty() || fechaFinFiltro == null || fechaFinFiltro.isEmpty()){
            prestamos = prestamosService.getListaPrestamoFiltros("0001-01-01", "9999-01-01",carnet);
            
        }
        else {
            prestamos = prestamosService.getListaPrestamoFiltros(fechaInicioFiltro, fechaFinFiltro,carnet);
        }
    }   
    
    public void marcarPrestamoInfo(Prestamo prestamo){
        this.prestamoInfo = prestamo;
    }
    
}
