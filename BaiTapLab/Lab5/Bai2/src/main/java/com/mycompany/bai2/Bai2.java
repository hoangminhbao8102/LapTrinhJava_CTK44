/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bai2;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author 20113
 */
public class Bai2 extends JFrame {
    private JSlider sliderFontSize;
    private JTextField txtCurrentValue;
    private final JButton btnSet;
    private JLabel lblFontSize;

    public Bai2() {
        // Thiết lập JFrame
        setTitle("Font Size Changer");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null); // Hiển thị cửa sổ ở giữa màn hình

        // Tạo JSlider
        sliderFontSize = new JSlider(0, 45, 18);
        sliderFontSize.setBounds(50, 20, 300, 50);
        sliderFontSize.setMajorTickSpacing(10);
        sliderFontSize.setMinorTickSpacing(1);
        sliderFontSize.setPaintTicks(true);
        sliderFontSize.setPaintLabels(true);
        sliderFontSize.setSnapToTicks(true);

        // Tạo JTextField và JButton
        JLabel lblCurrentValue = new JLabel("Giá trị hiện tại:");
        lblCurrentValue.setBounds(50, 80, 100, 30);
        add(lblCurrentValue);

        txtCurrentValue = new JTextField("18");
        txtCurrentValue.setBounds(150, 80, 50, 30);

        btnSet = new JButton("Thiết Lập");
        btnSet.setBounds(220, 80, 100, 30);

        // Tạo JLabel hiển thị Font Size
        lblFontSize = new JLabel("Font Size");
        lblFontSize.setBounds(150, 130, 100, 30);
        lblFontSize.setFont(new Font("Arial", Font.PLAIN, 18));

        // Thêm các thành phần vào JFrame
        add(sliderFontSize);
        add(txtCurrentValue);
        add(btnSet);
        add(lblFontSize);

        // Sự kiện khi kéo thanh trượt
        sliderFontSize.addChangeListener((ChangeEvent e) -> {
            int fontSize = sliderFontSize.getValue();
            txtCurrentValue.setText(String.valueOf(fontSize));
            lblFontSize.setFont(new Font("Arial", Font.PLAIN, fontSize));
        });

        // Sự kiện khi nhấn nút Thiết Lập
        btnSet.addActionListener((ActionEvent e) -> {
            try {
                int fontSize = Integer.parseInt(txtCurrentValue.getText());
                if (fontSize >= 0 && fontSize <= 45) {
                    sliderFontSize.setValue(fontSize);
                    lblFontSize.setFont(new Font("Arial", Font.PLAIN, fontSize));
                } else {
                    JOptionPane.showMessageDialog(null, "Giá trị phải nằm trong khoảng 0-45.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập số hợp lệ.");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Bai2 frame = new Bai2();
            frame.setVisible(true);
        });
    }
}
