/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.Model;

/**
 *
 * @author 20113
 */
public class Account {
    private String accountNumber;
    private double balance;

    public Account () {}
    
    public Account(String accountNumber, double balance) {
        if (balance < 50000) {
            throw new IllegalArgumentException("So du phai lon hon hoac bang 50,000 VND!");
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isPremium() {
        return balance >= 10000000;
    }

    @Override
    public String toString() {
        return "So tai khoan: " + accountNumber + ", So du: " + balance + " VND";
    }
}
