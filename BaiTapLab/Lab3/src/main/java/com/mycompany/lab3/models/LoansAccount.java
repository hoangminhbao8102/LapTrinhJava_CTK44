/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3.models;

import com.mycompany.lab3.Model.Account;

/**
 *
 * @author 20113
 */
public class LoansAccount extends Account implements ReportService, Withdraw {

    // Hằng số
    private static final double LOAN_ACCOUNT_WITHDRAW_FEE = 0.05;
    private static final double LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE = 0.01;
    private static final double LOAN_ACCOUNT_MAX_BALANCE = 100000000;

    private final boolean isPremium; // Xác định tài khoản thường hay Premium

    // Constructor
    public LoansAccount(String accountNumber, double balance, boolean isPremium) {
        super(accountNumber, balance);
        this.isPremium = isPremium;
    }

    @Override
    public boolean withdraw(double amount) {
        double fee = isPremium ? LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE : LOAN_ACCOUNT_WITHDRAW_FEE;
        double totalAmount = amount + (amount * fee);
        if (amount > 0 && getBalance() - totalAmount >= 50000) {
            setBalance(getBalance() - totalAmount);
            addTransaction(new Transaction(getAccountNumber(), amount, true)); // Ghi giao dịch thành công
            return true;
        }
        addTransaction(new Transaction(getAccountNumber(), amount, false)); // Ghi giao dịch thất bại
        return false;
    }

    @Override
    public void log(double amount) {
        System.out.println(Utils.getDivider());
        System.out.printf("%35s%n", "BIEN LAI GIAO DICH LOAN");
        System.out.printf("NGAY G/D: %28s%n", Utils.getDateTime());
        System.out.printf("ATM ID: %30s%n", "DIGITAL-BANK-ATM 2022");
        System.out.printf("SO TK: %31s%n", getAccountNumber());
        System.out.printf("SO TIEN: %29s%n", Utils.formatBalance(amount));
        System.out.printf("SO DU: %31s%n", Utils.formatBalance(getBalance()));
        double fee = isPremium ? LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE : LOAN_ACCOUNT_WITHDRAW_FEE;
        System.out.printf("PHI + VAT: %27s%n", Utils.formatBalance(amount * fee));
        System.out.println(Utils.getDivider());
    }

    @Override
    public boolean isAccepted(double totalAmount) {
        return totalAmount > 0 &&
               getBalance() - totalAmount >= 50000 && // Số dư sau khi rút và trừ phí phải >= 50,000
               getBalance() + totalAmount <= LOAN_ACCOUNT_MAX_BALANCE; // Không vượt quá hạn mức tối đa
    }
}

