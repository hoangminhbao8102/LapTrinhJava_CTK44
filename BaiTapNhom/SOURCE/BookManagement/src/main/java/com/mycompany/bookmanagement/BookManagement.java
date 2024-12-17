/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bookmanagement;

import view.LoginFrame;

import javax.swing.*;

/**
 *
 * @author 20113
 */
public class BookManagement {

    public static void main(String[] args) {
        // Thiết lập Look and Feel của hệ điều hành (Giao diện đẹp hơn)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }

        // Khởi chạy giao diện đăng nhập
        SwingUtilities.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
        });
    }
}
