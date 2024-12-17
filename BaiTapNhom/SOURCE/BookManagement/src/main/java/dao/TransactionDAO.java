/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Transaction;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 20113
 */
public class TransactionDAO {
    public boolean addTransaction(Transaction transaction) {
        String query = "INSERT INTO transactions (user_id, book_id, transaction_type, transaction_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, transaction.getUserId());
            stmt.setInt(2, transaction.getBookId());
            stmt.setString(3, transaction.getTransactionType());
            stmt.setTimestamp(4, transaction.getTransactionDate());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
        }
        return false;
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        String query = "SELECT * FROM transactions";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                transactions.add(new Transaction(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("book_id"),
                        rs.getString("transaction_type"),
                        rs.getTimestamp("transaction_date")
                ));
            }
        } catch (SQLException e) {
        }
        return transactions;
    }
}
