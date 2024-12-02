/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bai3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 *
 * @author 20113
 */
public class Bai3 extends JFrame {
    private final JTable tblProducts;
    private final JTextField txtProductId, txtName, txtPrice, txtProvider;
    private final JComboBox<String> cbxUnit;
    private final JButton btnNew, btnSave, btnDelete;
    private final DefaultTableModel tableModel;

    public Bai3() {
        // Set JFrame properties
        setTitle("List of Products");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); // Center the window

        // Create main panel
        JPanel panel = new JPanel(new BorderLayout());

        // Top: Table
        tableModel = new DefaultTableModel(new Object[]{"Product ID", "Name", "Unit", "Price", "Provider"}, 0);
        tblProducts = new JTable(tableModel);
        tblProducts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblProducts.getSelectionModel().addListSelectionListener(e -> loadSelectedProduct());
        panel.add(new JScrollPane(tblProducts), BorderLayout.CENTER);

        // Bottom: Form and buttons
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        formPanel.add(new JLabel("Product ID:"));
        txtProductId = new JTextField();
        formPanel.add(txtProductId);

        formPanel.add(new JLabel("Name:"));
        txtName = new JTextField();
        formPanel.add(txtName);

        formPanel.add(new JLabel("Unit:"));
        cbxUnit = new JComboBox<>(new String[]{"Bottle", "Can", "Kg"});
        formPanel.add(cbxUnit);

        formPanel.add(new JLabel("Price:"));
        txtPrice = new JTextField();
        formPanel.add(txtPrice);

        formPanel.add(new JLabel("Provider:"));
        txtProvider = new JTextField();
        formPanel.add(txtProvider);

        panel.add(formPanel, BorderLayout.SOUTH);

        // Buttons
        JPanel buttonPanel = new JPanel();
        btnNew = new JButton("New");
        btnSave = new JButton("Save");
        btnDelete = new JButton("Delete");

        btnNew.addActionListener(e -> resetForm());
        btnSave.addActionListener(e -> saveProduct());
        btnDelete.addActionListener(e -> deleteProduct());

        buttonPanel.add(btnNew);
        buttonPanel.add(btnSave);
        buttonPanel.add(btnDelete);

        panel.add(buttonPanel, BorderLayout.PAGE_END);

        add(panel);
    }

    private void resetForm() {
        txtProductId.setText("");
        txtName.setText("");
        txtPrice.setText("");
        txtProvider.setText("");
        cbxUnit.setSelectedIndex(0);
        tblProducts.clearSelection();
    }

    private void saveProduct() {
        try {
            String productId = txtProductId.getText().trim();
            String name = txtName.getText().trim();
            String unit = cbxUnit.getSelectedItem().toString();
            double price = Double.parseDouble(txtPrice.getText().trim());
            String provider = txtProvider.getText().trim();

            if (productId.isEmpty() || name.isEmpty() || provider.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields must be filled!");
                return;
            }

            for (int i = 0; i < tableModel.getRowCount(); i++) {
                if (tableModel.getValueAt(i, 0).equals(productId)) {
                    // Update existing product
                    tableModel.setValueAt(name, i, 1);
                    tableModel.setValueAt(unit, i, 2);
                    tableModel.setValueAt(price, i, 3);
                    tableModel.setValueAt(provider, i, 4);
                    JOptionPane.showMessageDialog(this, "Product updated successfully!");
                    return;
                }
            }

            // Add new product
            tableModel.addRow(new Object[]{productId, name, unit, price, provider});
            JOptionPane.showMessageDialog(this, "New product added successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid price value!");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void loadSelectedProduct() {
        int selectedRow = tblProducts.getSelectedRow();
        if (selectedRow != -1) {
            txtProductId.setText(tableModel.getValueAt(selectedRow, 0).toString());
            txtName.setText(tableModel.getValueAt(selectedRow, 1).toString());
            cbxUnit.setSelectedItem(tableModel.getValueAt(selectedRow, 2).toString());
            txtPrice.setText(tableModel.getValueAt(selectedRow, 3).toString());
            txtProvider.setText(tableModel.getValueAt(selectedRow, 4).toString());
        }
    }

    private void deleteProduct() {
        int selectedRow = tblProducts.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a product to delete!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this product?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            tableModel.removeRow(selectedRow);
            resetForm();
            JOptionPane.showMessageDialog(this, "Product deleted successfully!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai3().setVisible(true));
    }
}
