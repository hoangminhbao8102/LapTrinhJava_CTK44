/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3.Model;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author 20113
 */
public class Customer extends User {
    private final List<Account> accounts;

    public Customer(String customerId, String name) {
        super(name, customerId);
        this.accounts = new ArrayList<>(); // Khởi tạo danh sách tài khoản
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account newAccount) {
        if (accounts.stream().noneMatch(acc -> acc.getAccountNumber().equals(newAccount.getAccountNumber()))) {
            accounts.add(newAccount);
        } else {
            throw new IllegalArgumentException("Tai khoan da ton tai!");
        }
    }

    public boolean isPremium() {
        return accounts.stream().anyMatch(Account::isPremium);
    }

    public double getBalance() {
        return accounts.stream().mapToDouble(Account::getBalance).sum();
    }

    public void displayInformation() {
        // Hiển thị thông tin khách hàng trên một dòng
        System.out.printf("%-12s | %-10s | %-8s | %,15.0fVND\n",
                getCustomerId(),
                getName(),
                (isPremium() ? "Premium" : "Normal"),
                getBalance());

        // Hiển thị thông tin từng tài khoản trên các dòng tiếp theo
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            System.out.printf("%-12s | %6s | %,15.0fVND\n",
                    (i + 1),
                    account.getAccountNumber(),
                    account.getBalance());
        }
    }
}
