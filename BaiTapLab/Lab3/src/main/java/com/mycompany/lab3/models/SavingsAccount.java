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
public class SavingsAccount extends Account implements ReportService, Withdraw {

    // Hằng số: Số tiền tối đa cho một lần rút
    private static final double SAVINGS_ACCOUNT_MAX_WITHDRAW = 5000000;

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void log(double amount) {
        System.out.println(Utils.getDivider());
        System.out.printf("%35s%n", "BIEN LAI GIAO DICH SAVINGS");
        System.out.printf("NGAY G/D: %28s%n", Utils.getDateTime());
        System.out.printf("ATM ID: %30s%n", "DIGITAL-BANK-ATM 2022");
        System.out.printf("SO TK: %31s%n", this.getAccountNumber());
        System.out.printf("SO TIEN: %29s%n", Utils.formatBalance(amount));
        System.out.printf("SO DU: %31s%n", Utils.formatBalance(this.getBalance()));
        System.out.printf("PHI + VAT: %27s%n", Utils.formatBalance(0)); // Không áp dụng phí cho Savings
        System.out.println(Utils.getDivider());
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount % 10000 == 0 && amount <= SAVINGS_ACCOUNT_MAX_WITHDRAW && getBalance() - amount >= 50000) {
            setBalance(getBalance() - amount);
            addTransaction(new Transaction(getAccountNumber(), amount, true)); // Ghi giao dịch thành công
            return true;
        }
        addTransaction(new Transaction(getAccountNumber(), amount, false)); // Ghi giao dịch thất bại
        return false;
    }

    @Override
    public boolean isAccepted(double amount) {
        // Kiểm tra các điều kiện:
        return amount > 0 &&
               amount % 10000 == 0 &&                         // Số tiền phải là bội số của 10.000
               amount <= SAVINGS_ACCOUNT_MAX_WITHDRAW &&      // Không vượt quá 5.000.000
               getBalance() - amount >= 50000;                // Số dư sau rút phải >= 50.000
    }
}
