/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.HashSet;
import java.util.Set;
import tablas.Estacion;
import tablas.Medicion;
import tablas.Tiposensor;

/**
 *
 * @author Tes America
 */
public class sensorJson {
     private int idSensor;
     private int idEstacion;
     private int idTipoSensor;
     private String nombre;
     private String unidades;
     private Set<Medicion> medicions = new HashSet<Medicion>(0);

    public sensorJson() {
    }

	
    public sensorJson(int idSensor) {
        this.idSensor = idSensor;
    }
    public sensorJson(int idSensor, int idEstacion, int idTipoSensor, String nombre, String unidades, Set<Medicion> medicions) {
       this.idSensor = idSensor;
       this.idEstacion = idEstacion;
       this.idTipoSensor = idTipoSensor;
       this.nombre = nombre;
       this.unidades = unidades;
       this.medicions = medicions;
    }
   
    public int getIdSensor() {
        return this.idSensor;
    }
    
    public void setIdSensor(int idSensor) {
        this.idSensor = idSensor;
    }
    public int getEstacion() {
        return this.idEstacion;
    }
    
    public void setEstacion(int estacion) {
        this.idEstacion = estacion;
    }
    public int getTiposensor() {
        return this.idTipoSensor;
    }
    
    public void setTiposensor(int tiposensor) {
        this.idTipoSensor = tiposensor;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getUnidades() {
        return this.unidades;
    }
    
    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }
    public Set<Medicion> getMedicions() {
        return this.medicions;
    }
    
    public void setMedicions(Set<Medicion> medicions) {
        this.medicions = medicions;
    }



    
}
