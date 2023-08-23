/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2.asm02.models;

import com.mycompany.lab2.asm02.models.Account;
import com.mycompany.lab2.asm02.models.User;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Maxsys
 */
public class Customer extends User{
    public List<Account> accounts;
    
    public Customer() {
        this.accounts = new ArrayList<>();
    }
    
    
    public List<Account> getAccount() { return accounts; }
    
    public boolean isPremium() {
        for (Account account:accounts)
            if (account.isPremium())
                return true;
        return false;
    }
    
    public void addAccount(Account newAccount) {
        for (Account account:accounts)
            if (account.getAccountNumber().equals(newAccount.getAccountNumber()))
                return;
        accounts.add(newAccount);       
    }
    
    public double getBalance() {
        double balances = 0;
          for (Account account:accounts)
            {
                balances += account.getBalance();
            }
        return balances;
    }
    
    public void displayInformation() throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF8")); 
        
        System.out.printf("%-14s | %14s | %-7s | %12s\n",
                this.getCustomerId(), this.getName(), isPremium()?"Premium":"Normal",  String.format("%,.0f", getBalance())+"đ");
        
        for (int i = 0; i < accounts.size(); i++) {
            System.out.printf("%-8s%-6s | %14s   %-7s   %12s\n",
                    i+1, accounts.get(i).getAccountNumber(),
                "", "", String.format("%,.0f", accounts.get(i).getBalance())+"đ");
        }
    }
}
