/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bai2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 *
 * @author 20113
 */
public class Bai2 extends JFrame {
    private final JTextField txtSearchTitle;
    private final JButton btnSearch, btnDelete, btnExit;
    private final JTable tblBooks;
    private final DefaultTableModel model;
    private final BookDAO bookDAO;

    public Bai2() {
        // Khởi tạo các thành phần
        setTitle("Book Management");
        setLayout(null);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lblSearch = new JLabel("Search Title:");
        lblSearch.setBounds(20, 20, 100, 25);
        add(lblSearch);

        txtSearchTitle = new JTextField();
        txtSearchTitle.setBounds(120, 20, 200, 25);
        add(txtSearchTitle);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(330, 20, 100, 25);
        add(btnSearch);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(120, 300, 100, 25);
        add(btnDelete);

        btnExit = new JButton("Exit");
        btnExit.setBounds(240, 300, 100, 25);
        add(btnExit);

        tblBooks = new JTable();
        model = new DefaultTableModel(new String[]{"Book ID", "Title", "Price"}, 0);
        tblBooks.setModel(model);
        JScrollPane scrollPane = new JScrollPane(tblBooks);
        scrollPane.setBounds(20, 60, 540, 220);
        add(scrollPane);

        bookDAO = new BookDAO();

        // Sự kiện nút Search
        btnSearch.addActionListener((ActionEvent e) -> {
            searchBooks();
        });

        // Sự kiện nút Delete
        btnDelete.addActionListener((ActionEvent e) -> {
            deleteBook();
        });

        // Sự kiện nút Exit
        btnExit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
    }

    private void searchBooks() {
        String keyword = txtSearchTitle.getText();
        List<Book> books = bookDAO.searchBooks(keyword);
        model.setRowCount(0); // Xóa dữ liệu cũ
        for (Book book : books) {
            model.addRow(new Object[]{book.getBookId(), book.getTitle(), book.getPrice()});
        }
    }

    private void deleteBook() {
        int selectedRow = tblBooks.getSelectedRow();
        if (selectedRow != -1) {
            int bookId = (int) model.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this book?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                if (bookDAO.deleteBook(bookId)) {
                    JOptionPane.showMessageDialog(this, "Book deleted successfully!");
                    model.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete book.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a book to delete.");
        }
    }

    public static void main(String[] args) {
        new Bai2().setVisible(true);
    }
}
