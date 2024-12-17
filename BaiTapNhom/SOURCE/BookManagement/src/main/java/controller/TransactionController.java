/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.TransactionDAO;
import model.Transaction;

import java.util.List;

/**
 *
 * @author 20113
 */
public class TransactionController {
    private final TransactionDAO transactionDAO;

    public TransactionController() {
        transactionDAO = new TransactionDAO();
    }

    public boolean addTransaction(Transaction transaction) {
        return transactionDAO.addTransaction(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionDAO.getAllTransactions();
    }
}
