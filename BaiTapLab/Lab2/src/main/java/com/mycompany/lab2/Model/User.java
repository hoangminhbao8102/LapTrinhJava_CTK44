/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.Model;

/**
 *
 * @author 20113
 */
public abstract class User {
    private String name;
    private String customerId;
    
    public User() {}
    
    public User(String name, String customerId) {
        this.name = name;
        if (customerId.matches("\\d{12}")) {
            this.customerId = customerId;
        } else {
            throw new IllegalArgumentException("CCCD khong hop le!");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        if (customerId.matches("\\d{12}")) {
            this.customerId = customerId;
        } else {
            throw new IllegalArgumentException("CCCD khong hop le!");
        }
    }
}
