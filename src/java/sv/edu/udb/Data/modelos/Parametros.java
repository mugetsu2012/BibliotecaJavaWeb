/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.Data.modelos;

import java.math.BigDecimal;

/**
 *
 * @author Douglas
 */
public class Parametros {

    /**
     * @return the id_parametros
     */
    public long getId_parametros() {
        return id_parametros;
    }

    /**
     * @param id_parametros the id_parametros to set
     */
    public void setId_parametros(long id_parametros) {
        this.id_parametros = id_parametros;
    }

    /**
     * @return the mora_por_dia
     */
    public BigDecimal getMora_por_dia() {
        return mora_por_dia;
    }

    /**
     * @param mora_por_dia the mora_por_dia to set
     */
    public void setMora_por_dia(BigDecimal mora_por_dia) {
        this.mora_por_dia = mora_por_dia;
    }

    /**
     * @return the dias_prestar_profesor
     */
    public int getDias_prestar_profesor() {
        return dias_prestar_profesor;
    }

    /**
     * @param dias_prestar_profesor the dias_prestar_profesor to set
     */
    public void setDias_prestar_profesor(int dias_prestar_profesor) {
        this.dias_prestar_profesor = dias_prestar_profesor;
    }

    /**
     * @return the dias_prestar_alumno
     */
    public int getDias_prestar_alumno() {
        return dias_prestar_alumno;
    }

    /**
     * @param dias_prestar_alumno the dias_prestar_alumno to set
     */
    public void setDias_prestar_alumno(int dias_prestar_alumno) {
        this.dias_prestar_alumno = dias_prestar_alumno;
    }

    /**
     * @return the cantidad_prestar_alumno
     */
    public int getCantidad_prestar_alumno() {
        return cantidad_prestar_alumno;
    }

    /**
     * @param cantidad_prestar_alumno the cantidad_prestar_alumno to set
     */
    public void setCantidad_prestar_alumno(int cantidad_prestar_alumno) {
        this.cantidad_prestar_alumno = cantidad_prestar_alumno;
    }

    /**
     * @return the cantidad_prestar_profesor
     */
    public int getCantidad_prestar_profesor() {
        return cantidad_prestar_profesor;
    }

    /**
     * @param cantidad_prestar_profesor the cantidad_prestar_profesor to set
     */
    public void setCantidad_prestar_profesor(int cantidad_prestar_profesor) {
        this.cantidad_prestar_profesor = cantidad_prestar_profesor;
    }
    public long id_parametros;
    public BigDecimal mora_por_dia;
    public int dias_prestar_profesor;
    public int dias_prestar_alumno;
    public int cantidad_prestar_alumno;
    public int cantidad_prestar_profesor;
    
       
}
