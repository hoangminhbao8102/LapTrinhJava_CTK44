/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import javax.swing.border.TitledBorder;

import controller.BookController;
import model.Book;

/**
 *
 * @author 20113
 */
public class SearchBooksFrame  extends JFrame {
    private final BookController bookController;
    private final JTable resultTable;
    private final DefaultTableModel tableModel;
    private final JTextField searchField;
    private final JComboBox<String> searchCriteriaBox;

    public SearchBooksFrame() {
        bookController = new BookController();

        setTitle("Tìm Kiếm Sách");
        setSize(800, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        setResizable(false);

        // Panel tìm kiếm
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        searchPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                "Tìm Kiếm Sách",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 16),
                Color.BLUE
        ));

        searchField = new JTextField(20);
        searchField.setFont(new Font("Arial", Font.PLAIN, 14));

        String[] searchCriteria = {"Tên Sách", "Tác Giả", "Thể Loại"};
        searchCriteriaBox = new JComboBox<>(searchCriteria);
        searchCriteriaBox.setFont(new Font("Arial", Font.PLAIN, 14));

        JButton searchButton = createStyledButton("Tìm Kiếm", Color.GREEN);

        searchPanel.add(new JLabel("Tìm kiếm:"));
        searchPanel.add(searchField);
        searchPanel.add(new JLabel("Theo:"));
        searchPanel.add(searchCriteriaBox);
        searchPanel.add(searchButton);

        add(searchPanel, BorderLayout.NORTH);

        // Bảng kết quả
        String[] columns = {"ID", "Tên Sách", "Tác Giả", "Thể Loại", "Số Lượng", "Ngày Tạo"};
        tableModel = new DefaultTableModel(columns, 0);
        resultTable = new JTable(tableModel);
        resultTable.setRowHeight(25);
        resultTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        resultTable.setFont(new Font("Arial", Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane(resultTable);
        add(scrollPane, BorderLayout.CENTER);

        // Xử lý sự kiện tìm kiếm
        searchButton.addActionListener(e -> searchBooks());

        // Nạp dữ liệu ban đầu
        loadAllBooks();
    }

    private void searchBooks() {
        String searchText = searchField.getText().trim();
        String criteria = searchCriteriaBox.getSelectedItem().toString();

        if (searchText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa tìm kiếm!");
            return;
        }

        tableModel.setRowCount(0); // Xóa dữ liệu cũ
        List<Book> books = bookController.searchBooks(searchText, criteria);
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

    private void loadAllBooks() {
        tableModel.setRowCount(0); // Xóa dữ liệu cũ
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

    // Phương thức tạo nút với style
    private JButton createStyledButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBackground(color);
        button.setForeground(Color.BLACK);
        button.setPreferredSize(new Dimension(120, 35));
        button.setBorder(BorderFactory.createLineBorder(color.darker(), 2));
        return button;
    }
}
