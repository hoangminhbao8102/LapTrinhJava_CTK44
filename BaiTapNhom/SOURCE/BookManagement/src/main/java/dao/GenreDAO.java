/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Genre;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 20113
 */
public class GenreDAO {
    public List<Genre> getAllGenres() {
        List<Genre> genres = new ArrayList<>();
        String query = "SELECT * FROM genres";
        try (Connection conn = DatabaseConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                genres.add(new Genre(
                        rs.getInt("id"),
                        rs.getString("genre_name")
                ));
            }
        } catch (Exception e) {
            // Bắt tất cả các ngoại lệ (bao gồm SQLException và ClassNotFoundException)
        }
        return genres;
    }
}
