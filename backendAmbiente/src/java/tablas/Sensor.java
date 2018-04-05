package tablas;
// Generated 4/04/2018 02:40:15 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Sensor generated by hbm2java
 */
public class Sensor  implements java.io.Serializable {


     private int idSensor;
     private Estacion estacion;
     private Tiposensor tiposensor;
     private String nombre;
     private String unidades;
     private Set<Medicion> medicions = new HashSet<Medicion>(0);

    public Sensor() {
    }

	
    public Sensor(int idSensor) {
        this.idSensor = idSensor;
    }

    public Sensor(int idSensor, Estacion estacion, Tiposensor tiposensor, String nombre, String unidades) {
        this.idSensor = idSensor;
        this.estacion = estacion;
        this.tiposensor = tiposensor;
        this.nombre = nombre;
        this.unidades = unidades;
    }
    
    public Sensor(int idSensor, Estacion estacion, Tiposensor tiposensor, String nombre, String unidades, Set<Medicion> medicions) {
       this.idSensor = idSensor;
       this.estacion = estacion;
       this.tiposensor = tiposensor;
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
    public Estacion getEstacion() {
        return this.estacion;
    }
    
    public void setEstacion(Estacion estacion) {
        this.estacion = estacion;
    }
    public Tiposensor getTiposensor() {
        return this.tiposensor;
    }
    
    public void setTiposensor(Tiposensor tiposensor) {
        this.tiposensor = tiposensor;
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


