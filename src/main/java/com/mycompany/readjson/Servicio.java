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
public class Servicio {
     private long port;
     private String nameofservive;
     private long factor;
     private String localhost;
     

    public Servicio() {
    }
     
     

    public Servicio(long port, String nameofservive, long factor, String localhost) {
        this.port = port;
        this.nameofservive = nameofservive;
        this.factor = factor;
        this.localhost = localhost;
    }

    public long getPort() {
        return port;
    }

    public void setPort(long port) {
        this.port = port;
    }

    public String getNameofservive() {
        return nameofservive;
    }

    public void setNameofservive(String nameofservive) {
        this.nameofservive = nameofservive;
    }

    public long getFactor() {
        return factor;
    }

    public void setFactor(long factor) {
        this.factor = factor;
    }

    public String getLocalhost() {
        return localhost;
    }

    public void setLocalhost(String localhost) {
        this.localhost = localhost;
    }

    @Override
    public String toString() {
        return "Servicio{" + "port=" + port + ", nameofservive=" + nameofservive + ", factor=" + factor + ", localhost=" + localhost + '}';
    }

    
    
    
}
