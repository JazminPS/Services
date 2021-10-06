/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.readjson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author LIMOFUNA
 */
public class ReadJSON {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LeerJSON leerjson=new LeerJSON();
        //JSONArray serviciosarray= leerjson.ServiciosJSON();
        Hashtable<String, Servicio> hashtableservicios =leerjson.ServiciosJSON();
        
       System.out.println(""+hashtableservicios.get("ser1fecha"));
       System.out.println(""+hashtableservicios.get("ser1hora"));
       System.out.println(""+hashtableservicios.get("ser1cuantos"));
       System.out.println(""+hashtableservicios.get("ser1fin"));
       System.out.println(""+hashtableservicios.get("ser2crypt"));
       System.out.println(""+hashtableservicios.get("ser2cuantos"));
       System.out.println(""+hashtableservicios.get("ser2fin"));
       
////        Servicio x=hashtableservicios.get("ser1fecha");
////        x.getNameofservive();
////        
////        System.out.println(""+x.getNameofservive());
        
     
        
        
    
    

     
}
   
        
        
        }
