/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.asm02.models;

/**
 *
 * @author Maxsys
 */
public class Account {
    private String accountNumber;
    private double balance;
    
    public Account() { }
    
    public Account(String accNumber, double balances)
    {
        this.accountNumber = accNumber;
        this.balance = balances;
    }
    
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    
    public boolean isPremium() { return this.balance >= 10000000; }
    public String ToString()
    {
        return this.accountNumber + " | \t\t\t" + this.balance;
    }
}
