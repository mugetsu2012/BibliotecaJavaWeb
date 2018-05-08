/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.Beans;

import javax.inject.Named;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import sv.edu.udb.Data.modelos.*;
import sv.edu.udb.Services.*;

/**
 *
 * @author Douglas
 */
@Named(value = "devolucionBean")
@ManagedBean
@SessionScoped
public class DevolucionBean {

    /**
     * @return the idPrestamoActual
     */
    public long getIdPrestamoActual() {
        return idPrestamoActual;
    }

    /**
     * @param idPrestamoActual the idPrestamoActual to set
     */
    public void setIdPrestamoActual(long idPrestamoActual) {
        this.idPrestamoActual = idPrestamoActual;
    }

    /**
     * @return the nombreItemActual
     */
    public String getNombreItemActual() {
        return nombreItemActual;
    }

    /**
     * @param nombreItemActual the nombreItemActual to set
     */
    public void setNombreItemActual(String nombreItemActual) {
        this.nombreItemActual = nombreItemActual;
    }

    /**
     * @return the moraCancelada
     */
    public double getMoraCancelada() {
        return moraCancelada;
    }

    /**
     * @param moraCancelada the moraCancelada to set
     */
    public void setMoraCancelada(double moraCancelada) {
        this.moraCancelada = moraCancelada;
    }

    /**
     * @return the moraActual
     */
    public BigDecimal getMoraActual() {
        if(prestamoInfo == null){
            return new BigDecimal(0);
        }
        
        return prestamosService.totalMora(prestamoInfo.id_prestamo);
    }

    /**
     * @param moraActual the moraActual to set
     */
    public void setMoraActual(BigDecimal moraActual) {
        this.moraActual = moraActual;
    }

    
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
    private String descripcionDevolucion;
    private String fechaDevolver;
    private boolean devolucionExitosa;
    private String mensajeDevolucion;
    private List<Prestamo> prestamos;
    private Map<String, Object> opcionesItems;
    private String fechaInicioFiltro;
    private String fechaFinFiltro;
    private String carneFiltro;
    private Prestamo prestamoInfo;
    private BigDecimal moraActual;
    private long idPrestamoActual;
    private String nombreItemActual;
    private double moraCancelada;
            
    
    @PostConstruct
    public void init(){
        filtrarPrestamo();  
       
    }
    
    /**
     * @return the mensajePrestamo
     */
    public String getMensajeDevolucion() {
        return mensajeDevolucion;
    }

    /**
     * @param mensajePrestamo the mensajePrestamo to set
     */
    public void setMensajeDevolucion(String mensajeDevolucion) {
        this.mensajeDevolucion = mensajeDevolucion;
    }

    /**
     * @return the prestamoExitoso
     */
    public boolean isDevolucionExitosa() {
        return devolucionExitosa;
    }

    /**
     * @param prestamoExitoso the prestamoExitoso to set
     */
    public void setDevolucionExitosa(boolean devolucionExitosa) {
        this.devolucionExitosa = devolucionExitosa;
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
    public String getDescripcionDevolucion() {
        return descripcionDevolucion;
    }

    /**
     * @param descripcionPrestamo the descripcionPrestamo to set
     */
    public void setDescripcionDevolucion(String descripcionDevolucion) {
        this.descripcionDevolucion = descripcionDevolucion;
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
    public DevolucionBean() {
        prestamosService = new PrestamosService();
        itemsService = new ItemsService();
        adminService = new AdminService();
    }
    
    public void realizarDevolucion(){
        boolean prestamoEnMora = prestamosService.prestamoEnMora(idPrestamoActual);
        //si el prestamo esta en mora
        moraActual = getMoraActual();
        if(prestamoEnMora && moraActual.compareTo( new BigDecimal(moraCancelada, MathContext.DECIMAL64)) != 0){
            //Habia mora y no se pago lo que se debe de mora >:v
            devolucionExitosa = false;
                mensajeDevolucion = "La mora para este prestamo es de " + moraActual.toString() +" pero se indico un valor de " + moraCancelada;
        }
        else {
            Devolucion devolucion = new Devolucion();
            devolucion.id_prestamo = idPrestamoActual;
            devolucion.descripcion = descripcionDevolucion;
            devolucion.mora_cancelada = moraActual;            
            prestamosService.realizarDevolucion(devolucion);
            init();
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                    try{
                        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
                    }
                    catch(Exception e){
                        System.out.println("Error: " + e.getMessage());
                    }
        }
        
    }
    
    public void filtrarPrestamo(){
        if(fechaInicioFiltro == null || fechaInicioFiltro.isEmpty() || fechaFinFiltro == null || fechaFinFiltro.isEmpty()){
            if(carneFiltro != null && !carneFiltro.isEmpty()){
                prestamos = prestamosService.getListaPrestamoFiltros("0001-01-01", "9999-01-01",carneFiltro);
            }
            else {
                prestamos = prestamosService.getListaPrestamo();
            }
            
        }
        else {
            prestamos = prestamosService.getListaPrestamoFiltros(fechaInicioFiltro, fechaFinFiltro,carneFiltro);
        }
        
        prestamos = prestamos.stream().filter(p -> p.fechaDevolucion == null).collect(Collectors.toList());
    }  
     
    public void marcarPrestamoInfo(Prestamo prestamo){
        idPrestamoActual = prestamo.id_prestamo;
        moraCancelada = 0;
        nombreItemActual = prestamo.nombreItem;
        prestamoInfo = new Prestamo();
        prestamoInfo = prestamo;
    }
    
}
