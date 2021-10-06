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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author LIMOFUNA
 */
public class LeerJSON {
    //Esta parte lee el archivo JSON
   Hashtable<String, Servicio> hashtableservicios = new Hashtable<String, Servicio>(); 
   Hashtable<String, Servicio> hasthtableservidor1 = new Hashtable<String, Servicio>(); 
   Hashtable<Integer, Servicio> hasthtableservidor2 = new Hashtable<Integer, Servicio>(); 
   
     public Hashtable<String, Servicio> ServiciosJSON(){
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("servicios.JSON"));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("Archivo JSON: " + jsonObject);
            JSONObject dictdist =(JSONObject) jsonObject.get("dictdist");
            JSONArray services = (JSONArray) dictdist.get("services");
            System.out.println("");

            JSONObject servicios = (JSONObject) services.get(0);
            hashtableservicios.put("ser1fecha",new Servicio((long)servicios.get("port"), 
                                (String)servicios.get("nameOfService"),
                                (long)servicios.get("factor"),
                                (String)servicios.get("ip")));
            
            servicios = (JSONObject) services.get(1);
            hashtableservicios.put("ser1hora",new Servicio((long)servicios.get("port"), 
                                (String)servicios.get("nameOfService"),
                                (long)servicios.get("factor"),
                                (String)servicios.get("ip")));
            
            servicios = (JSONObject) services.get(2);
            hashtableservicios.put("ser1cuantos",new Servicio((long)servicios.get("port"), 
                                (String)servicios.get("nameOfService"),
                                (long)servicios.get("factor"),
                                (String)servicios.get("ip")));
            
            servicios = (JSONObject) services.get(3);
            hashtableservicios.put("ser1fin",new Servicio((long)servicios.get("port"), 
                                (String)servicios.get("nameOfService"),
                                (long)servicios.get("factor"),
                                (String)servicios.get("ip")));
            
            servicios = (JSONObject) services.get(4);
            hashtableservicios.put("ser2crypt",new Servicio((long)servicios.get("port"), 
                                (String)servicios.get("nameOfService"),
                                (long)servicios.get("factor"),
                                (String)servicios.get("ip")));
            
            servicios = (JSONObject) services.get(5);
            hashtableservicios.put("ser2cuantos",new Servicio((long)servicios.get("port"), 
                                (String)servicios.get("nameOfService"),
                                (long)servicios.get("factor"),
                                (String)servicios.get("ip")));
            
            servicios = (JSONObject) services.get(6);
            hashtableservicios.put("ser2fin",new Servicio((long)servicios.get("port"), 
                                (String)servicios.get("nameOfService"),
                                (long)servicios.get("factor"),
                                (String)servicios.get("ip")));
//            
//            for(int i = 0 ; i < services.size() ; i++) {
//                        JSONObject servidor = (JSONObject) services.get(i);
//                        
//                            System.out.println( "Nombre del servicio " + (String) servidor.get("nameOfService"));
//                            System.out.println( "IP: " +servidor.get("ip"));
//                            System.out.println( "PORT: " + servidor.get("port"));
//                            System.out.println( "Factor: " + servidor.get("factor")); 
//                            System.out.println("\n");
//                            long puerto=(long) servidor.get("port");
//                            //System.out.println(puerto);
//                            switch((int)puerto){
//                                case 12345:
//                                    System.out.println("Llego12345");
//                                    hasthtableservidor1.put((String)servidor.get("nameOfService"),
//                                    new Servicio((long)servidor.get("port"), 
//                                    (String)servidor.get("nameOfService"),
//                                    (long)servidor.get("factor"),
//                                    (String)servidor.get("ip")));
//                                    break;
//                                case 13777:
//                                    System.out.println("Llego13777");
//                                    hasthtableservidor2.put(i,
//                                    new Servicio((long)servidor.get("port"), 
//                                    (String)servidor.get("nameOfService"),
//                                    (long)servidor.get("factor"),
//                                    (String)servidor.get("ip")));
//                                    break;
//                                default:
//                                    System.out.println("No Capto");
//                            }
//                            System.out.println("");
//                        }

//                        hashtableservicios.put(i,new Servicio((long)servicios.get("port"), 
//                                (String)servicios.get("nameOfService"),
//                                (long)servicios.get("factor"),
//                                (String)servicios.get("ip")));
//                        
//                        System.out.println("Servicio: " + i);
//                        
//           
//                        System.out.println("Nombre del servicio: " + servicios.get("nameOfService"));
//                        System.out.println("IP: " + servicios.get("ip"));
//                        System.out.println("Puerto: " + servicios.get("port"));
//                        System.out.println("Factor: " + servicios.get("factor"));
//                        System.out.println("");
//            }
//            System.out.println(""+hashtableservicios.get("ser1fecha"));
//                        for(int i = 0 ; i < services.size() ; i++) {
//                        System.out.println("S1-->"+hasthtableservidor1.get(i));}
//                        for(int i = 0 ; i < services.size() ; i++) {
//                        System.out.println("S2-->"+hasthtableservidor2.get(i));}

                return hashtableservicios;
        }catch(FileNotFoundException e){}
            catch(IOException e){}
                catch(ParseException e){}
        return null;
    }
}
