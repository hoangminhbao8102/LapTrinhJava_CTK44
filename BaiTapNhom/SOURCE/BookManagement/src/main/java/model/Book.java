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
public class Book {
    private final int id;
    private final String title;
    private final String author;
    private final int genreId;
    private final int quantity;
    private final Timestamp createdAt;

    public Book(int id, String title, String author, int genreId, int quantity, Timestamp createdAt) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genreId = genreId;
        this.quantity = quantity;
        this.createdAt = createdAt;
    }

    // Getters và Setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getGenreId() { return genreId; }
    public int getQuantity() { return quantity; }
    public Timestamp getCreatedAt() { return createdAt; }
}
