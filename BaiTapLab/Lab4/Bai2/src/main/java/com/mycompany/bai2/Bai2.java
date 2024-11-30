/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bai2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author 20113
 */
public class Bai2 extends JFrame {
    private final JTextField txtUsername;
    private final JPasswordField txtPassword;
    private final JPasswordField txtConfirm;
    private final JButton btnSignUp;
    private final JButton btnCancel;

    public Bai2() {
        // Thiết lập tiêu đề
        setTitle("Sign up form");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Căn giữa cửa sổ
        setLocationRelativeTo(null);

        // Thiết kế giao diện
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel lblUsername = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblUsername, gbc);

        txtUsername = new JTextField(15);
        gbc.gridx = 1;
        add(txtUsername, gbc);

        JLabel lblPassword = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblPassword, gbc);

        txtPassword = new JPasswordField(15);
        gbc.gridx = 1;
        add(txtPassword, gbc);

        JLabel lblConfirm = new JLabel("Confirm:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblConfirm, gbc);

        txtConfirm = new JPasswordField(15);
        gbc.gridx = 1;
        add(txtConfirm, gbc);

        btnSignUp = new JButton("Sign up");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(btnSignUp, gbc);

        btnCancel = new JButton("Cancel");
        gbc.gridx = 1;
        add(btnCancel, gbc);

        // Xử lý sự kiện nút "Sign up"
        btnSignUp.addActionListener((ActionEvent e) -> {
            handleSignUp();
        });

        // Xử lý sự kiện nút "Cancel"
        btnCancel.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
    }

    private void handleSignUp() {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();
        String confirm = new String(txtConfirm.getPassword()).trim();

        // Kiểm tra username và password
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username and Password are required!", "Message", JOptionPane.INFORMATION_MESSAGE);

            if (username.isEmpty()) {
                txtUsername.setBackground(Color.YELLOW);
            } else {
                txtUsername.setBackground(Color.WHITE);
            }

            if (password.isEmpty()) {
                txtPassword.setBackground(Color.YELLOW);
            } else {
                txtPassword.setBackground(Color.WHITE);
            }
            return;
        }

        txtUsername.setBackground(Color.WHITE);
        txtPassword.setBackground(Color.WHITE);

        // Kiểm tra password và confirm password
        if (!password.equals(confirm)) {
            JOptionPane.showMessageDialog(this, "Password and confirm password must be the same!", "Message", JOptionPane.INFORMATION_MESSAGE);
            txtPassword.setBackground(Color.YELLOW);
            txtConfirm.setBackground(Color.YELLOW);
        } else {
            JOptionPane.showMessageDialog(this, "Sign up successfully!", "Message", JOptionPane.INFORMATION_MESSAGE);
            txtPassword.setBackground(Color.WHITE);
            txtConfirm.setBackground(Color.WHITE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Bai2 form = new Bai2();
            form.setVisible(true);
        });
    }
}
