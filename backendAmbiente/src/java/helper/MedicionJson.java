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
public class MedicionJson {
    
    private int idSensor;
    
    private String TipoSensor;
    
    private Date Fecha;
    
    private BigDecimal datoObtenido;
    
    private Date Hora;
    
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


    public MedicionJson() {
    }

    public MedicionJson(int idSensor, String TipoSensor, Date Fecha, BigDecimal datoObtenido, Date Hora, String Unidades) {
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
    public Date getHora() {
        return Hora;
    }

    /**
     * Set the value of hora
     *
     * @param hora new value of hora
     */
    public void setHora(Date hora) {
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(Fecha);
    }

    /**
     * Set the value of fecha
     *
     * @param fecha new value of fecha
     */
    public void setFecha(Date fecha) {
        this.Fecha = fecha;
    }
    
    public Date getFechayHora(){       
        return new Date(this.Fecha.getTime() + this.Hora.getTime());
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
    public int getIdEstacion() {
        return idSensor;
    }

    /**
     * Set the value of idEstacion
     *
     * @param idEstacion new value of idEstacion
     */
    public void setIdEstacion(int idEstacion) {
        this.idSensor = idEstacion;
    }

}
