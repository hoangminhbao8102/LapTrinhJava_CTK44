/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3.Model;

import com.mycompany.lab3.models.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 20113
 */
public abstract class Account {
    private String accountNumber; // Số tài khoản
    private double balance;       // Số dư tài khoản
    private List<Transaction> transactions = new ArrayList<>(); // Lịch sử giao dịch

    // Constructor mặc định
    public Account() {}

    // Constructor có điều kiện kiểm tra số dư
    public Account(String accountNumber, double balance) {
        if (balance < 50000) {
            throw new IllegalArgumentException("So du phai lon hon hoac bang 50,000 VND!");
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter và Setter
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

    // Kiểm tra tài khoản Premium
    public boolean isPremium() {
        return balance >= 10000000; // Premium nếu số dư >= 10,000,000 VND
    }

    // Lấy danh sách giao dịch
    public List<Transaction> getTransactions() {
        return transactions; // Trả về danh sách giao dịch
    }

    // Thêm giao dịch vào danh sách
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction); // Thêm giao dịch
    }

    // Rút tiền (phương thức trừu tượng, các lớp con phải triển khai)
    public abstract boolean withdraw(double amount);

    // Hiển thị thông tin tài khoản
    @Override
    public String toString() {
        return "So tai khoan: " + accountNumber + ", So du: " + balance + " VND";
    }
}

