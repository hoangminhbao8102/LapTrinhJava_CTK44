/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.asm02.models;

import com.mycompany.lab2.asm02.models.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/**
 *
 * @author Maxsys
 */
public class Bank {
    private final String ID;
    private final List<Customer> customers;
    
    public Bank() {
        this.customers = new ArrayList<>();
        this.ID = String.valueOf(UUID.randomUUID());
    }
    
    public void addCustomer(Customer newCustomer) {
        this.customers.add(newCustomer);
    }
    public boolean isCustomerExisted(String customerId) {
        for (Customer customer:customers)
        {
            if (customer.getCustomerId().equals(customerId))
                return true;
        }
        return false;
    }
    
    public List<Customer> getCustomers() {
        return customers;
    }
}
