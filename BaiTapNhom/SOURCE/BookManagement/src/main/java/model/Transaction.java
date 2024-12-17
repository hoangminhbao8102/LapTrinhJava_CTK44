/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author 20113
 */
public class Transaction {
    private final int id;
    private final int userId;
    private final int bookId;
    private final String transactionType;
    private final Timestamp transactionDate;

    public Transaction(int id, int userId, int bookId, String transactionType, Timestamp transactionDate) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
    }

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public int getBookId() { return bookId; }
    public String getTransactionType() { return transactionType; }
    public Timestamp getTransactionDate() { return transactionDate; }
}
