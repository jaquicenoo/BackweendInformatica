/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import helper.MedicionJson;
import helper.MedicionTosave;
import helper.UserHelper;
import helper.sensorJson;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import jdk.nashorn.internal.parser.JSONParser;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import tablas.Estacion;
import tablas.Medicion;

/**
 * REST Web Service
 *
 * @author Tes America
 */
@Path("generic")
public class GenericResource {

    private UserHelper helper;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
        helper = new UserHelper();
    }

    /**
     * Retrieves representation of an instance of services.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
        @POST
    @Path("getAllMedicionesByEstacion")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMedicionesByEstacion(String idEstacion){
       Gson gson = new Gson();
        String json="";
        Type listType=null;
       HashMap<String,String[]> lm = null;
       try{
           lm = helper.getAllMedicionesByEstacion(Integer.parseInt(idEstacion));          
       }catch(Exception ex){
           ex.printStackTrace();
       }
       try{
         listType = new TypeToken<HashMap<String,String[]>>() {}.getType();
        json =gson.toJson(lm,listType); 
       }
       catch(JsonIOException ex){
          ex.printStackTrace(); 
       }
      
       return Response.ok(json).header("Access-Control-Allow-Origin", "*")
      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }
            @POST
    @Path("getUltimaMedicionByEstacion")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUltimaMedicionByEstacion(String idEstacion){
       Gson gson = new Gson();
        String json="";
        Type listType=null;
       HashMap<String,String> lm = null;
       try{
           lm = helper.getUltimaMedicionByEstacion(Integer.parseInt(idEstacion));          
       }catch(Exception ex){
           ex.printStackTrace();
       }
       try{
         listType = new TypeToken<HashMap<String,String>>() {}.getType();
        json =gson.toJson(lm,listType); 
       }
       catch(JsonIOException ex){
          ex.printStackTrace(); 
       }
      
       return Response.ok(json).header("Access-Control-Allow-Origin", "*")
      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }
        @POST
    @Path("saveMedicion")
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveMedicion(String data){
      Gson gson = new Gson();
      
      MedicionTosave me = gson.fromJson(data, MedicionTosave.class);

      try{
         helper.saveMedicion(me);
      }catch(Exception ex){
          ex.printStackTrace();
      }
      return Response.ok(me).header("Access-Control-Allow-Origin", "*")
      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
    }
      @GET
    @Path("getAllEstaciones")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEstaciones(){
       Gson gson = new Gson();
       Type listType=null;
       String json="";
      List<Estacion> lm = null;
       try{
           lm = helper.getAllEstaciones();
       }catch(Exception ex){
           ex.printStackTrace();
       }
        try{
         listType = new TypeToken<List<Estacion>>() {}.getType();
        json =gson.toJson(lm,listType); 
       }
       catch(JsonIOException ex){
          ex.printStackTrace(); 
       }
       return Response.ok(json).header("Access-Control-Allow-Origin", "*").build();
    }
          @GET
    @Path("getAllSensores")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSensores(){
       Gson gson = new Gson();
       Type listType=null;
       String json="";
      List<sensorJson> lm = null;
       try{
           lm = helper.getAllSensores();
       }catch(Exception ex){
           ex.printStackTrace();
       }
        try{
         listType = new TypeToken<List<sensorJson>>() {}.getType();
        json =gson.toJson(lm,listType); 
       }
       catch(JsonIOException ex){
          ex.printStackTrace(); 
       }
       return Response.ok(json).header("Access-Control-Allow-Origin", "*").build();
    }
}
