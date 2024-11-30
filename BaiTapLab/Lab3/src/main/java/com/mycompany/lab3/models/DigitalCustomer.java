/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3.models;

import com.mycompany.lab3.Model.Account;
import com.mycompany.lab3.Model.Customer;

/**
 *
 * @author 20113
 */
public class DigitalCustomer extends Customer {

    public DigitalCustomer(String customerId, String name) {
        super(name, customerId);
    }

    public boolean withdraw(String accountNumber, double amount) {
        for (Account account : getAccounts()) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account.withdraw(amount); // Gọi hàm withdraw của tài khoản
            }
        }
        System.out.println("Không tìm thấy tài khoản với số: " + accountNumber);
        return false; // Nếu không tìm thấy tài khoản
    }

    @Override
    public void displayInformation() {
        System.out.println("Khach hang: " + getName() + " (CCCD: " + getCustomerId() + ")");
        System.out.println("Danh sach tai khoan:");
        for (Account account : getAccounts()) {
            System.out.println(account);
        }
    }
    
    public boolean hasAccount(String accountNumber) {
    for (Account account : getAccounts()) {
        if (account.getAccountNumber().equals(accountNumber)) {
            return true; // Tìm thấy tài khoản
        }
    }
    return false; // Không tìm thấy tài khoản
}
}
