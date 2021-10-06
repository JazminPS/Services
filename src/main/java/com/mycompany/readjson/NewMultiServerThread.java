/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.readjson;

/**
 *
 * @author LIMOFUNA
 */
import java.net.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Hashtable;

public class NewMultiServerThread extends Thread {
   private Socket socket = null;

   String maquinaX="localhost";
   int puertoX=12345;

   PrintWriter escritorX = null;
   String DatosEnviadosX = null;
   BufferedReader entradaX =null;
   Socket clienteX = null;
   
 LeerJSON leerjson=new LeerJSON();
   Hashtable<String, Servicio> hashtableservicios =leerjson.ServiciosJSON();

   public NewMultiServerThread(Socket socket) {
      super("NewMultiServerThread");
      this.socket = socket;
      NewServer.NoClients++;
      System.out.println("After Init[b]");
   }

   public void run() {

      try {
         PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
         BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         String lineIn, lineOut,p1,ns1,p2,ns2;

	    while((lineIn = entrada.readLine()) != null){
                System.out.println("Received[b]: "+lineIn);
                escritor.flush();
                if(lineIn.equals("FIN")){
                    NewServer.NoClients--;
                    break;
		}else if(lineIn.equals("fecha")){
                    Servicio ser1=hashtableservicios.get("ser1fecha");
                    p1=String.valueOf(ser1.getPort());
                        ns1=ser1.getNameofservive();
                        System.out.println("Connecting to another server[a]");
                        try{
                            clienteX = new Socket (ser1.getLocalhost(),(int)ser1.getPort());
                            System.out.println("Connected to another server");
                        }catch (Exception e){
                            System.out.println ("Fallo : "+ e.toString());
                            System.exit (0);
                        }
                        System.out.println("Trying to send data to another server");

                        try{
                            escritorX = new PrintWriter(clienteX.getOutputStream(), true);
                            entradaX=new BufferedReader(new InputStreamReader(clienteX.getInputStream()));
                        }catch (Exception e){
                            System.out.println ("Fallo : "+ e.toString());
                            clienteX.close();
                            System.exit (0);
                        }
                        String lineX;
                        String DatosEnviadosX;
                        System.out.println("Sending connecting to another server[a]");
                        java.util.Date fecha1 = new Date();
                        DatosEnviadosX="Servicio: "+ns1+" | Puerto:"+(String)p1+ " | "+fecha1 ;
                    //DatosEnviadosX = "connecting";
                        escritorX.println(DatosEnviadosX);
                        lineX = entradaX.readLine();
                        System.out.println("Server1: "+lineX);
                        DatosEnviadosX = "FIN";
                        escritorX.println (DatosEnviadosX);
                        System.out.println("Closing another server");
                        clienteX.close();
                        escritorX.close();
                        entradaX.close();
                        escritor.println("Response from Server1... "+lineX);
                        escritor.flush();
                }else if(lineIn.equals("hora")){
                    Servicio ser1=hashtableservicios.get("ser1hora");
                    p1=String.valueOf(ser1.getPort());
                        ns1=ser1.getNameofservive();
                        System.out.println("Connecting to another server[a]");
                        try{
                            clienteX = new Socket (ser1.getLocalhost(),(int)ser1.getPort());
                            System.out.println("Connected to another server");
                        }catch (Exception e){
                            System.out.println ("Fallo : "+ e.toString());
                            System.exit (0);
                        }
                        System.out.println("Trying to send data to another server");

                        try{
                            escritorX = new PrintWriter(clienteX.getOutputStream(), true);
                            entradaX=new BufferedReader(new InputStreamReader(clienteX.getInputStream()));
                        }catch (Exception e){
                            System.out.println ("Fallo : "+ e.toString());
                            clienteX.close();
                            System.exit (0);
                        }
                        String lineX;
                        String DatosEnviadosX;
                        System.out.println("Sending connecting to another server[a]");
                        LocalDateTime locaDate = LocalDateTime.now();
                        int hours  = locaDate.getHour();
                        int minutes = locaDate.getMinute();
                        int seconds = locaDate.getSecond();
                        DatosEnviadosX="Servicio: "+ns1+" | Puerto:"+(String)p1+ " | "+"Hora actual : " + hours  + ":"+ minutes +":"+seconds;
                    //DatosEnviadosX = "connecting";
                        escritorX.println(DatosEnviadosX);
                        lineX = entradaX.readLine();
                        System.out.println("Server1: "+lineX);
                        DatosEnviadosX = "FIN";
                        escritorX.println (DatosEnviadosX);
                        System.out.println("Closing another server");
                        clienteX.close();
                        escritorX.close();
                        entradaX.close();
                        escritor.println("Response from Server1... "+lineX);
                        escritor.flush();
                }
                else if(lineIn.equals("cuantos")){
                   Servicio ser1=hashtableservicios.get("ser1cuantos"); 
                   Servicio ser2=hashtableservicios.get("ser2cuantos");
                   
                   if(socket.getLocalPort()==ser2.getPort()){
                       System.out.println("Puerto Socket[b]: "+socket.getLocalPort());
                        p2=String.valueOf(ser2.getPort());
                        ns2=ser2.getNameofservive();
                        escritor.append("Servicio: "+ns2+" | Puerto:"+(String)p2+" | #Clientes: "+NewServer.NoClients+"\r\n");
                        escritor.flush();
                   }else{
                        p1=String.valueOf(ser1.getPort());
                        ns1=ser1.getNameofservive();
                        System.out.println("Connecting to another server[a]");
                        try{
                            clienteX = new Socket (ser1.getLocalhost(),(int)ser1.getPort());
                            System.out.println("Connected to another server");
                        }catch (Exception e){
                            System.out.println ("Fallo : "+ e.toString());
                            System.exit (0);
                        }
                        System.out.println("Trying to send data to another server");

                        try{
                            escritorX = new PrintWriter(clienteX.getOutputStream(), true);
                            entradaX=new BufferedReader(new InputStreamReader(clienteX.getInputStream()));
                        }catch (Exception e){
                            System.out.println ("Fallo : "+ e.toString());
                            clienteX.close();
                            System.exit (0);
                        }
                        String lineX;
                        String DatosEnviadosX;
                        System.out.println("Sending connecting to another server[a]");
                        DatosEnviadosX="Servicio: "+ns1+" | Puerto:"+(String)p1+" | #Clientes: "+NewServer.NoClients;
                    //DatosEnviadosX = "connecting";
                        escritorX.println(DatosEnviadosX);
                        lineX = entradaX.readLine();
                        System.out.println("Server1: "+lineX);
                        DatosEnviadosX = "FIN";
                        escritorX.println (DatosEnviadosX);
                        System.out.println("Closing another server");
                        clienteX.close();
                        escritorX.close();
                        entradaX.close();
                        escritor.println("Response from Server1... "+lineX);
                        escritor.flush();
                    }
               }else if(lineIn.equals("crypt")){
                   Servicio ser1=hashtableservicios.get("ser2crypt"); 
                   ns1=ser1.getNameofservive();
                   escritor.println("Servicio: "+ns1);
                   escritor.flush();
                   
               }
            else if(lineIn.equals("connect")){
                    System.out.println("Connecting to another server[b]");
                    try{
                        clienteX = new Socket (maquinaX,puertoX);
                        System.out.println("Connected to another server");
                    }catch (Exception e){
                        System.out.println ("Fallo : "+ e.toString());
                        System.exit (0);
                    }
                    System.out.println("Trying to send data to another server");

                    try{
                        escritorX = new PrintWriter(clienteX.getOutputStream(), true);
                        entradaX=new BufferedReader(new InputStreamReader(clienteX.getInputStream()));
                    }catch (Exception e){
                        System.out.println ("Fallo : "+ e.toString());
                        clienteX.close();
                        System.exit (0);
                    }
                    String lineX;
                    String DatosEnviadosX;
                    System.out.println("Sending connecting to another server[b]");
                    DatosEnviadosX = "connect1";
                    escritorX.println (DatosEnviadosX);
                    lineX = entradaX.readLine();
                    System.out.println("Server2: "+lineX);
                    DatosEnviadosX = "FIN";
                    escritorX.println (DatosEnviadosX);
                    System.out.println("Closing another server");
                    clienteX.close();
                    escritorX.close();
                    entradaX.close();
                    escritor.println("Response from Server2...--- "+lineX);
                    escritor.flush();
                }else{
                    escritor.println("Echo...[b] "+lineIn);
                    escritor.flush();
            }
        }
        try{
            entrada.close();
            escritor.close();
            socket.close();
         }catch(Exception e){
            System.out.println ("Error : " + e.toString());
            socket.close();
            System.exit (0);
   	   }
      }catch (IOException e) {
        System.out.println("Error---");
         e.printStackTrace();
      }
   }
}
