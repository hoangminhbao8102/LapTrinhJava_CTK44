/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3.models;

import com.mycompany.lab3.Model.Account;
import com.mycompany.lab3.Model.Bank;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 20113
 */
public class DigitalBank extends Bank {

    private final List<DigitalCustomer> customers; // Danh sách khách hàng

    public DigitalBank() {
        this.customers = new ArrayList<>();
    }

    // Tìm khách hàng theo CCCD
    public DigitalCustomer getCustomerById(String customerId) {
        for (DigitalCustomer customer : customers) {
            if (customer.getCustomerId() != null && customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null; // Trả về null nếu không tìm thấy khách hàng
    }

    // Thêm khách hàng mới
    public void addCustomer(String customerId, String name) {
        if (getCustomerById(customerId) != null) {
            System.out.println("Khach hang voi CCCD " + customerId + " da ton tai.");
            return;
        }

        // Tạo khách hàng mới và thêm vào danh sách
        DigitalCustomer newCustomer = new DigitalCustomer(customerId, name);
        customers.add(newCustomer);
        System.out.println("Khach hang da duoc them thanh cong: " + name + " (CCCD: " + customerId + ")");
    }

    // Thêm tài khoản cho khách hàng
    @Override
    public void addAccount(String customerId, Account account) {
        DigitalCustomer customer = getCustomerById(customerId);
        if (customer == null) {
            System.out.println("Khong tim thay khach hang voi CCCD: " + customerId);
            return;
        }

        // Kiểm tra tài khoản đã tồn tại
        if (customer.hasAccount(account.getAccountNumber())) {
            System.out.println("Tai khoan voi so " + account.getAccountNumber() + " da ton tai.");
            return;
        }

        // Thêm tài khoản vào khách hàng
        customer.addAccount(account);
        System.out.println("Tai khoan da duoc them thanh cong cho khach hang: " + customerId);
    }

    // Rút tiền từ tài khoản của khách hàng
    public void withdraw(String customerId, String accountNumber, double amount) {
        // Tìm khách hàng theo CCCD
        DigitalCustomer customer = getCustomerById(customerId);

        if (customer == null) {
            System.out.println("Khong tim thay khach hang voi CCCD: " + customerId);
            return;
        }

        // Thực hiện rút tiền
        boolean result = customer.withdraw(accountNumber, amount);
        if (result) {
            System.out.println("Rut tien thanh cong: " + amount + " VND tu tai khoan " + accountNumber);
        } else {
            System.out.println("Rut tien that bai. Kiem tra so du hoac dieu kien rut tien.");
        }
    }
}
