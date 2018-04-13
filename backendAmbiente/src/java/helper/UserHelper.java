/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import static jdk.nashorn.internal.runtime.regexp.joni.constants.AsmConstants.S;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import tablas.Estacion;
import tablas.Medicion;
import tablas.Sensor;
import tablas.Tiposensor;
import utility.HibernateUtil;

/**
 *
 * @author Tes America
 */

public class UserHelper {

    public UserHelper() {
    }
      
    public List getMedicionFromFecha(Date fechainicio , Date fechafin){
      Session sesion = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = sesion.beginTransaction();
      
      List<Medicion> l =null;
      
      String Query ="";
      
      Query q = sesion.createQuery(Query);
      l=q.list();
      tx.commit();
      sesion.close();
      
      return l;
    }
    
      public HashMap getAllMedicionesByEstacion(int idEstacion){
      Session sesion = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = sesion.beginTransaction();
      
      HashMap<String,String[]> datos = new HashMap<>();
      List<MedicionJson> ls = new ArrayList<>();
      List<String> sensores ;
      
      SQLQuery stq = sesion.createSQLQuery("call getAllTipoSensoresByEstaciones(:_idestacion)");
      stq.setInteger("_idestacion",idEstacion);
      sensores = stq.list();      
      SQLQuery stq2 = sesion.createSQLQuery("call getAllMedicionesByEstaciones(:_idestacion)");
      stq2.setInteger("_idestacion",idEstacion);
      stq2.setResultTransformer(Transformers.aliasToBean(MedicionJson.class));
      ls = stq2.list();
      String sp =";";
      for(String se : sensores){  
      List<MedicionJson> filter = (List<MedicionJson>)(ls.stream().filter(x->x.getTipoSensor().equals(se)).collect(Collectors.toList()));
      List<String> dt = new ArrayList<>();
      filter.forEach(x-> dt.add(x.getFecha()+sp+x.getHora()+sp+x.getDatoObtenido()+sp+x.getUnidades()) );
      datos.put(se, dt.toArray(new String[dt.size()]));
      }
      
      tx.commit();
      sesion.close();
      
      return datos;
    }
      public HashMap getUltimaMedicionByEstacion(int idEstacion){
      Session sesion = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = sesion.beginTransaction();
      
      HashMap<String,String> datos = new HashMap<>();
      List<MedicionJson> ls = new ArrayList<>();
      List<String> sensores ;
      
      SQLQuery stq = sesion.createSQLQuery("call getAllTipoSensoresByEstaciones(:_idestacion)");
      stq.setInteger("_idestacion",idEstacion);
      sensores = stq.list();      
      SQLQuery stq2 = sesion.createSQLQuery("call getAllMedicionesByEstaciones(:_idestacion)");
      stq2.setInteger("_idestacion",idEstacion);
      stq2.setResultTransformer(Transformers.aliasToBean(MedicionJson.class));
      ls = stq2.list();
      String sp =";";
      for(String se : sensores){  
      List<MedicionJson> filter = (List<MedicionJson>)(ls.stream().filter(x->x.getTipoSensor().equals(se)).collect(Collectors.toList()));
      List<String> dt = new ArrayList<>();
      MedicionJson max =filter.stream()
      .max(Comparator.comparing(MedicionJson::getFechayHora))
      .orElseThrow(NoSuchElementException::new);
      
      datos.put(se,max.getFecha()+sp+max.getHora()+sp+max.getDatoObtenido()+sp+max.getUnidades());
      }
      
      tx.commit();
      sesion.close();
      
      return datos;
    }
      public List<Estacion> getAllEstaciones(){ 
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        List<Estacion> est ;
        SQLQuery stq2 = sesion.createSQLQuery("select * from estacion");
        stq2.setResultTransformer(Transformers.aliasToBean(Estacion.class));
        est = stq2.list();  
        tx.commit();
         sesion.close();
        return est;         
      }
      public List<sensorJson> getAllSensores(){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();
        List<sensorJson> est ;
        SQLQuery stq2 = sesion.createSQLQuery("select * from sensor");
        stq2.setResultTransformer(Transformers.aliasToBean(sensorJson.class));
        est = stq2.list();  
        tx.commit();
        sesion.close();
        return est;  
      }
      
      public void saveMedicion(MedicionTosave me ) throws ParseException{
         Session sesion = HibernateUtil.getSessionFactory().openSession();
         Medicion Med = new Medicion();
         Transaction tx = sesion.beginTransaction();
         SQLQuery q2 =sesion.createSQLQuery("Select max(idMedicion) FROM medicion");
         SQLQuery q3 =sesion.createSQLQuery("Select * FROM sensor AS E where E.idSensor="+me.getidSensor());
         q3.setResultTransformer(Transformers.aliasToBean(sensorJson.class));
         if(q3.list().isEmpty()){
         tx.commit();
         sesion.close();  
         return;             
         }
         sensorJson sj =(sensorJson)q3.list().get(0);
         Estacion est = (Estacion)sesion.createSQLQuery("Select * FROM estacion AS E where E.idEstacion="+sj.getEstacion()).setResultTransformer(Transformers.aliasToBean(Estacion.class)).list().get(0);
         String tps=(String)sesion.createSQLQuery("Select TipoSensor FROM tiposensor AS E where E.idTipoSensor="+sj.getTiposensor()).list().get(0);
         Sensor sen = new Sensor(sj.getIdSensor(),est,new Tiposensor(sj.getTiposensor(),tps),sj.getNombre(),sj.getUnidades());
         int id = (Integer)q2.list().get(0);
         Med.setIdMedicion(id+1);  
         Med.setDatoObtenido(me.getDatoObtenido());
         Med.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse(me.getFecha()));
         Med.setHora(new SimpleDateFormat("HH:mm:ss").parse(me.getHora()));
         Med.setSensor(sen);
         sesion.save(Med);
         tx.commit();
         sesion.close();         
      }
      

}
