/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quanlysanpham;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

/**
 *
 * @author 20113
 */
public class QuanLySanPham extends JFrame {
    private final JTable table;
    private final DefaultTableModel model;
    private final JTextField txtMaSP, txtTenSP, txtDonGia, txtNhaCungCap;
    private final JComboBox<String> cboDVT;
    private final JButton btnThem, btnXoa, btnDieuChinh;

    private Connection conn;

    public QuanLySanPham() {
        setTitle("Danh Sach San Pham");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Bảng dữ liệu
        String[] columnNames = {"Ma SP", "Ten SP", "DVT", "Don Gia", "Nha Cung Cap"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Panel nhập liệu
        JPanel inputPanel = new JPanel(new GridLayout(3, 4, 10, 10));
        inputPanel.setBackground(new Color(255, 228, 225));

        inputPanel.add(new JLabel("Ma san pham:"));
        txtMaSP = new JTextField();
        inputPanel.add(txtMaSP);

        inputPanel.add(new JLabel("Ten san pham:"));
        txtTenSP = new JTextField();
        inputPanel.add(txtTenSP);

        inputPanel.add(new JLabel("Don vi tinh:"));
        cboDVT = new JComboBox<>(new String[]{"Chai", "Thung", "Kg", "Lon"});
        inputPanel.add(cboDVT);

        inputPanel.add(new JLabel("Don gia:"));
        txtDonGia = new JTextField();
        inputPanel.add(txtDonGia);

        inputPanel.add(new JLabel("Nha cung cap:"));
        txtNhaCungCap = new JTextField();
        inputPanel.add(txtNhaCungCap);

        // Panel nút chức năng
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(255, 228, 225));

        btnThem = new JButton("Them San Pham");
        btnThem.setBackground(new Color(102, 205, 170));
        btnThem.setFont(new Font("Segoe UI", Font.BOLD, 14));
        buttonPanel.add(btnThem);

        btnXoa = new JButton("Xoa San Pham");
        btnXoa.setBackground(new Color(255, 105, 97));
        btnXoa.setFont(new Font("Segoe UI", Font.BOLD, 14));
        buttonPanel.add(btnXoa);

        btnDieuChinh = new JButton("Dieu Chinh Thong Tin");
        btnDieuChinh.setBackground(new Color(100, 149, 237));
        btnDieuChinh.setFont(new Font("Segoe UI", Font.BOLD, 14));
        buttonPanel.add(btnDieuChinh);

        // Gộp panel
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputPanel, BorderLayout.CENTER);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(bottomPanel, BorderLayout.SOUTH);

        // Kết nối và load dữ liệu
        connectToDatabase();
        loadData();

        // Sự kiện các nút
        btnThem.addActionListener(e -> addProduct());
        btnXoa.addActionListener(e -> deleteProduct());
        btnDieuChinh.addActionListener(e -> updateProduct());

        table.getSelectionModel().addListSelectionListener(e -> populateFieldsFromTable());
    }

    private void connectToDatabase() {
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLySanPham;encrypt=false;trustServerCertificate=true;";
            String user = "sa";
            String password = "minhbao8102";
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error connecting to database: " + e.getMessage());
        }
    }

    private void loadData() {
        try {
            model.setRowCount(0);
            String query = "SELECT * FROM SanPham";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getString("DVT"),
                        rs.getInt("DonGia"),
                        rs.getString("NhaCungCap")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
        }
    }

    private void addProduct() {
        try {
            String query = "INSERT INTO SanPham (MaSP, TenSP, DVT, DonGia, NhaCungCap) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, txtMaSP.getText());
            stmt.setString(2, txtTenSP.getText());
            stmt.setString(3, cboDVT.getSelectedItem().toString());
            stmt.setInt(4, Integer.parseInt(txtDonGia.getText()));
            stmt.setString(5, txtNhaCungCap.getText());
            stmt.executeUpdate();
            loadData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error adding product: " + e.getMessage());
        }
    }

    private void deleteProduct() {
        try {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a product to delete.");
                return;
            }
            String maSP = model.getValueAt(selectedRow, 0).toString();
            String query = "DELETE FROM SanPham WHERE MaSP = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, maSP);
            stmt.executeUpdate();
            loadData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error deleting product: " + e.getMessage());
        }
    }

    private void updateProduct() {
        try {
            String query = "UPDATE SanPham SET TenSP = ?, DVT = ?, DonGia = ?, NhaCungCap = ? WHERE MaSP = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, txtTenSP.getText());
            stmt.setString(2, cboDVT.getSelectedItem().toString());
            stmt.setInt(3, Integer.parseInt(txtDonGia.getText()));
            stmt.setString(4, txtNhaCungCap.getText());
            stmt.setString(5, txtMaSP.getText());
            stmt.executeUpdate();
            loadData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error updating product: " + e.getMessage());
        }
    }

    private void populateFieldsFromTable() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            txtMaSP.setText(model.getValueAt(selectedRow, 0).toString());
            txtTenSP.setText(model.getValueAt(selectedRow, 1).toString());
            cboDVT.setSelectedItem(model.getValueAt(selectedRow, 2).toString());
            txtDonGia.setText(model.getValueAt(selectedRow, 3).toString());
            txtNhaCungCap.setText(model.getValueAt(selectedRow, 4).toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new QuanLySanPham().setVisible(true));
    }
}