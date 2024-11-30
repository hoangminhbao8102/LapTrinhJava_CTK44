/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/**
 *
 * @author 20113
 */
public class Bank {
    private final String id;
    private final List<Customer> customers;

    public Bank() {
        this.id = UUID.randomUUID().toString();
        this.customers = new ArrayList<>();
    }

    public String getID() {
        return id;
    }
    
    public void addCustomer(Customer newCustomer) {
        if (customers.stream().noneMatch(c -> c.getCustomerId().equals(newCustomer.getCustomerId()))) {
            customers.add(newCustomer);
        } else {
            throw new IllegalArgumentException("Khach hang da ton tai!");
        }
    }

    public void addAccount(String customerID, Account account) {
        // Tìm khách hàng dựa trên customerID
        Customer customer = customers.stream()
            .filter(c -> c.getCustomerId().equals(customerID))
            .findFirst()
            .orElse(null);

        if (customer == null) {
            // Nếu khách hàng không tồn tại
            throw new IllegalArgumentException("Khong tim thay khach hang voi CCCD: " + customerID);
        }

        try {
            // Thêm tài khoản vào khách hàng
            customer.addAccount(account);
        } catch (IllegalArgumentException e) {
            // Nếu tài khoản đã tồn tại, ném lỗi
            throw new IllegalArgumentException("Tai khoan da ton tai hoac khong hop le: " + account.getAccountNumber());
        }
    }

    public boolean isCustomerExisted(String customerId) {
        return customers.stream().anyMatch(c -> c.getCustomerId().equals(customerId));
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
