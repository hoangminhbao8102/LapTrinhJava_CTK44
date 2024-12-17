/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author 20113
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Quản Lý Sách - Menu Chính");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tạo Menu
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Chức năng");
        JMenuItem manageBooks = new JMenuItem("Quản lý Sách");
        JMenuItem searchBooks = new JMenuItem("Tìm kiếm");
        JMenuItem stats = new JMenuItem("Thống kê");

        // Thêm các mục vào menu
        menu.add(manageBooks);
        menu.add(searchBooks);
        menu.add(stats);
        menuBar.add(menu);

        // Thiết lập Menu Bar
        setJMenuBar(menuBar);

        // Gắn hành động cho các menu item với trạng thái Loading
        manageBooks.addActionListener(e -> showLoadingScreen(() -> new ManageBooksFrame().setVisible(true)));
        searchBooks.addActionListener(e -> showLoadingScreen(() -> new SearchBooksFrame().setVisible(true)));
        stats.addActionListener(e -> showLoadingScreen(() -> new StatsFrame().setVisible(true)));

        // Nội dung chính
        JLabel welcomeLabel = new JLabel("Chào mừng đến với hệ thống Quản Lý Sách!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(welcomeLabel, BorderLayout.CENTER);
    }

    // Phương thức hiển thị màn hình Loading
    private void showLoadingScreen(Runnable nextScreen) {
        SwingUtilities.invokeLater(() -> new LoadingScreen(nextScreen).setVisible(true));
    }
}
