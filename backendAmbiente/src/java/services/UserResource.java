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
import helper.UserHelper;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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


/**
 * REST Web Service
 *
 * @author Tes America
 */
@Path("user")
public class UserResource {

    private UserHelper helper;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserResource
     */
    public UserResource() {
        helper = new UserHelper();
    }

    /**
     * Retrieves representation of an instance of services.UserResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of UserResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }


    @GET
    @Path("getMedicionFromFecha")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMedicionFromFecha(){
       Gson gson = new Gson();
//       List<Medicion> lm = null;
       try{
//           lm = new ArrayList(helper.getMedicionFromFecha(, fechafin));
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return "";
    }
    
    @GET
    @Path("getAllEstaciones")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllEstaciones(){
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
       return json;
    }
    
    @POST
    @Path("getAllMedicionesByEstacion")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllMedicionesByEstacion(String idEstacion){
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
      
       return "{\"user\":"+json+"}";
    }
    

  
}
