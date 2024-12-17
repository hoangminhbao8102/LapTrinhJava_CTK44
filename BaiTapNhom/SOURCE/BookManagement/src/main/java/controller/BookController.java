/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.BookDAO;
import model.Book;

import java.util.List;

/**
 *
 * @author 20113
 */
public class BookController {
    private final BookDAO bookDAO;

    public BookController() {
        this.bookDAO = new BookDAO();
    }

    // Lấy tất cả sách
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    // Thêm sách mới
    public boolean addBook(Book book) {
        return bookDAO.addBook(book);
    }

    // Xóa sách theo ID
    public boolean deleteBook(int id) {
        return bookDAO.deleteBook(id);
    }

    // Cập nhật sách
    public boolean updateBook(Book book) {
        return bookDAO.updateBook(book);
    }

    // Lấy sách theo ID
    public Book getBookById(int id) {
        return bookDAO.getBookById(id);
    }
    
    // Tìm kiếm sách
    public List<Book> searchBooks(String searchText, String criteria) {
        return bookDAO.searchBooks(searchText, criteria);
    }
}
