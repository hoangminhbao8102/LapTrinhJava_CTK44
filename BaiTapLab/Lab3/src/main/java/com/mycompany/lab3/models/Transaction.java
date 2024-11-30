/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

/**
 *
 * @author 20113
 */
public class Transaction {
    private final String id; // Mã giao dịch (random ngẫu nhiên)
    private final String accountNumber; // Số tài khoản
    private final double amount; // Số tiền giao dịch
    private final String time; // Thời điểm giao dịch
    private final boolean status; // Trạng thái giao dịch (thành công hoặc thất bại)

    // Constructor
    public Transaction(String accountNumber, double amount, boolean status) {
        this.id = generateRandomId();
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.time = getDateTime();
        this.status = status;
    }

    // Sinh mã giao dịch ngẫu nhiên
    private String generateRandomId() {
        return UUID.randomUUID().toString().substring(0, 12).replace("-", "");
    }

    // Lấy ngày giờ hiện tại
    public static String getDateTime() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return df.format(Calendar.getInstance().getTime());
    }

    // Hiển thị thông tin giao dịch
    public void displayTransaction() {
        System.out.printf("| %-12s | %-12s | %12.0fđ | %-20s | %-10s |\n",
                id, accountNumber, amount, time, (status ? "Thành công" : "Thất bại"));
    }

    // Getter
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public String getTime() {
        return time;
    }

    public boolean isStatus() {
        return status;
    }
}
