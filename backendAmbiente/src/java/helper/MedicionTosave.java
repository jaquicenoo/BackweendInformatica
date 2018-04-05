/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Tes America
 */
public class MedicionTosave {
       private int idSensor;
    
    private String TipoSensor;
    
    private String Fecha;
    
    private BigDecimal datoObtenido;
    
    private String Hora;
    
    private String Unidades;

    /**
     * Get the value of Unidades
     *
     * @return the value of Unidades
     */
    public String getUnidades() {
        return Unidades;
    }

    /**
     * Set the value of Unidades
     *
     * @param Unidades new value of Unidades
     */
    public void setUnidades(String Unidades) {
        this.Unidades = Unidades;
    }


    public MedicionTosave() {
    }

    public MedicionTosave(int idSensor, String TipoSensor, String Fecha, BigDecimal datoObtenido, String Hora, String Unidades) {
        this.idSensor = idSensor;
        this.TipoSensor = TipoSensor;
        this.Fecha = Fecha;
        this.datoObtenido = datoObtenido;
        this.Hora = Hora;
        this.Unidades = Unidades;
    }


    

    /**
     * Get the value of hora
     *
     * @return the value of hora
     */
    public String getHora() {
        return Hora;
    }

    /**
     * Set the value of hora
     *
     * @param hora new value of hora
     */
    public void setHora(String hora) {
        this.Hora = hora;
    }


    /**
     * Get the value of datoObtenido
     *
     * @return the value of datoObtenido
     */
    public BigDecimal getDatoObtenido() {
        return datoObtenido;
    }

    /**
     * Set the value of datoObtenido
     *
     * @param datoObtenido new value of datoObtenido
     */
    public void setDatoObtenido(BigDecimal datoObtenido) {
        this.datoObtenido = datoObtenido;
    }


    /**
     * Get the value of fecha
     *
     * @return the value of fecha
     */
    public String getFecha() {
        return this.Fecha;
    }

    /**
     * Set the value of fecha
     *
     * @param fecha new value of fecha
     */
    public void setFecha(String fecha) {
        this.Fecha = fecha;
    }


    /**
     * Get the value of relacionsensorestacion
     *
     * @return the value of relacionsensorestacion
     */
    public String getTipoSensor() {
        return TipoSensor;
    }

    /**
     * Set the value of relacionsensorestacion
     *
     * @param relacionsensorestacion new value of relacionsensorestacion
     */
    public void setTipoSensor(String TipoSensor) {
        this.TipoSensor = TipoSensor;
    }


    /**
     * Get the value of idEstacion
     *
     * @return the value of idEstacion
     */
    public int getidSensor() {
        return idSensor;
    }

    /**
     * Set the value of idEstacion
     *
     * @param idEstacion new value of idEstacion
     */
    public void setidSensor(int idEstacion) {
        this.idSensor = idEstacion;
    }

    
}
