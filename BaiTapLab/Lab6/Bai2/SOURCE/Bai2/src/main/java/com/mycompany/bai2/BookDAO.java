/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bai2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 20113
 */
public class BookDAO {
    public List<Book> searchBooks(String keyword) {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM Books WHERE Title LIKE ?";
        try (Connection conn = DatabaseHelper.openConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                books.add(new Book(rs.getInt("BookId"), rs.getString("Title"), rs.getDouble("Price")));
            }
        } catch (SQLException e) {
        } catch (Exception e) {
        }
        return books;
    }

    public boolean deleteBook(int bookId) {
        String query = "DELETE FROM Books WHERE BookId = ?";
        try (Connection conn = DatabaseHelper.openConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setInt(1, bookId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
        } catch (Exception e) {
        }
        return false;
    }
}
