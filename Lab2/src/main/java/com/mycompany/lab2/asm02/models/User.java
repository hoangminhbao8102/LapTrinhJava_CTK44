/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.asm02.models;

/**
 *
 * @author Maxsys
 */
public abstract class User {
    private String name;
    private String customerID;
    
    public User(){}
    
    public String getName() { return name; }
    
    public void setName(String name) { this.name  = name; }
    
    public String getCustomerId() { return customerID; }
    
    public void setCustomerId(String customerID) throws Exception {
        if (customerID.matches("[0-9]+") && customerID.length()==12)
            this.customerID  = customerID;
        else
            throw new Exception("Ma khac hang khong hop le");
    }
}
