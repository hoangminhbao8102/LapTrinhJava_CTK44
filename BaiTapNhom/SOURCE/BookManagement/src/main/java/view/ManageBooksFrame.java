/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.BookController;
import model.Book;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author 20113
 */
public class ManageBooksFrame extends JFrame {
    private final BookController bookController;
    private final JTable bookTable;
    private final DefaultTableModel tableModel;

    private final JTextField titleField, authorField, genreField, quantityField;

    public ManageBooksFrame() {
        bookController = new BookController();

        // Cấu hình chính của JFrame
        setTitle("Quản Lý Sách");
        setSize(900, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        setResizable(false);

        // Tạo bảng hiển thị sách
        String[] columns = {"ID", "Tên Sách", "Tác Giả", "Thể Loại", "Số Lượng", "Ngày Tạo"};
        tableModel = new DefaultTableModel(columns, 0);
        bookTable = new JTable(tableModel);

        bookTable.setRowHeight(25);
        bookTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        bookTable.setFont(new Font("Arial", Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane(bookTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                "Danh Sách Sách",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 14),
                Color.BLUE
        ));
        add(scrollPane, BorderLayout.CENTER);

        // Form nhập liệu sách
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        titleField = new JTextField(15);
        authorField = new JTextField(15);
        genreField = new JTextField(15);
        quantityField = new JTextField(15);

        // Dòng 1
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Tên Sách:"), gbc);
        gbc.gridx = 1;
        formPanel.add(titleField, gbc);

        gbc.gridx = 2;
        formPanel.add(new JLabel("Tác Giả:"), gbc);
        gbc.gridx = 3;
        formPanel.add(authorField, gbc);

        // Dòng 2
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Thể Loại:"), gbc);
        gbc.gridx = 1;
        formPanel.add(genreField, gbc);

        gbc.gridx = 2;
        formPanel.add(new JLabel("Số Lượng:"), gbc);
        gbc.gridx = 3;
        formPanel.add(quantityField, gbc);

        // Dòng 3 (nút chức năng)
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        JButton addButton = new JButton("Thêm");
        JButton updateButton = new JButton("Cập Nhật");
        JButton deleteButton = new JButton("Xóa");
        JButton refreshButton = new JButton("Tải Lại");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 4;
        formPanel.add(buttonPanel, gbc);

        add(formPanel, BorderLayout.SOUTH);

        // Sự kiện nút
        addButton.addActionListener(e -> addBook());
        updateButton.addActionListener(e -> updateBook());
        deleteButton.addActionListener(e -> deleteBook());
        refreshButton.addActionListener(e -> loadBookData());

        bookTable.getSelectionModel().addListSelectionListener(event -> fillFormFromTable());

        // Tải dữ liệu sách ban đầu
        loadBookData();
    }

    // Thêm sách
    private void addBook() {
        try {
            String title = titleField.getText();
            String author = authorField.getText();
            int genreId = Integer.parseInt(genreField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            Book book = new Book(0, title, author, genreId, quantity, null);
            if (bookController.addBook(book)) {
                JOptionPane.showMessageDialog(this, "Thêm sách thành công!");
                loadBookData();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm sách thất bại!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng dữ liệu!");
        }
    }

    // Cập nhật sách
    private void updateBook() {
        int selectedRow = bookTable.getSelectedRow();
        if (selectedRow >= 0) {
            try {
                int id = (int) tableModel.getValueAt(selectedRow, 0);
                String title = titleField.getText();
                String author = authorField.getText();
                int genreId = Integer.parseInt(genreField.getText());
                int quantity = Integer.parseInt(quantityField.getText());

                Book book = new Book(id, title, author, genreId, quantity, null);
                if (bookController.updateBook(book)) {
                    JOptionPane.showMessageDialog(this, "Cập nhật sách thành công!");
                    loadBookData();
                    clearForm();
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhật sách thất bại!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng dữ liệu!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách cần cập nhật!");
        }
    }

    // Xóa sách
    private void deleteBook() {
        int selectedRow = bookTable.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) tableModel.getValueAt(selectedRow, 0);
            if (bookController.deleteBook(id)) {
                JOptionPane.showMessageDialog(this, "Xóa sách thành công!");
                loadBookData();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa sách thất bại!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách cần xóa!");
        }
    }

    // Tải dữ liệu sách
    private void loadBookData() {
        tableModel.setRowCount(0);
        List<Book> books = bookController.getAllBooks();
        for (Book book : books) {
            tableModel.addRow(new Object[]{
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getGenreId(),
                    book.getQuantity(),
                    book.getCreatedAt()
            });
        }
    }

    private void fillFormFromTable() {
        int selectedRow = bookTable.getSelectedRow();
        if (selectedRow >= 0) {
            titleField.setText(tableModel.getValueAt(selectedRow, 1).toString());
            authorField.setText(tableModel.getValueAt(selectedRow, 2).toString());
            genreField.setText(tableModel.getValueAt(selectedRow, 3).toString());
            quantityField.setText(tableModel.getValueAt(selectedRow, 4).toString());
        }
    }

    private void clearForm() {
        titleField.setText("");
        authorField.setText("");
        genreField.setText("");
        quantityField.setText("");
    }
}
