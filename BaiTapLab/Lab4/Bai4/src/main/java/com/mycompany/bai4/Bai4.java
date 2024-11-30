/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bai4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 20113
 */
public class Bai4 extends JFrame implements ActionListener {
    private final JTextField displayField;
    private double num1 = 0, num2 = 0, result = 0;
    private char operator = ' ';

    public Bai4() {
        // Thiết lập JFrame
        setTitle("CASIO Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null); // Hiện cửa sổ giữa màn hình

        // Khung hiển thị
        displayField = new JTextField();
        displayField.setHorizontalAlignment(SwingConstants.RIGHT);
        displayField.setFont(new Font("Arial", Font.BOLD, 24));
        displayField.setEditable(false);
        add(displayField, BorderLayout.NORTH);

        // Bàn phím
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
                "7", "8", "9", "/", "sqrt",
                "4", "5", "6", "*", "%",
                "1", "2", "3", "-", "1/x",
                "0", "+/-", "C", "+", "="
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            switch (command) {
                case "C" -> {
                    displayField.setText("");
                    num1 = num2 = result = 0;
                    operator = ' ';
                }
                case "+/-" -> {
                    if (!displayField.getText().isEmpty()) {
                        double value = Double.parseDouble(displayField.getText());
                        displayField.setText(String.valueOf(-value));
                    }
                }
                case "sqrt" -> {
                    if (!displayField.getText().isEmpty()) {
                        double value = Double.parseDouble(displayField.getText());
                        displayField.setText(String.valueOf(Math.sqrt(value)));
                    }
                }
                case "%" -> {
                    if (!displayField.getText().isEmpty()) {
                        double value = Double.parseDouble(displayField.getText());
                        displayField.setText(String.valueOf(value / 100));
                    }
                }
                case "1/x" -> {
                    if (!displayField.getText().isEmpty()) {
                        double value = Double.parseDouble(displayField.getText());
                        displayField.setText(String.valueOf(1 / value));
                    }
                }
                case "=" -> {
                    if (!displayField.getText().isEmpty() && operator != ' ') {
                        num2 = Double.parseDouble(displayField.getText());
                        switch (operator) {
                            case '+' -> result = num1 + num2;
                            case '-' -> result = num1 - num2;
                            case '*' -> result = num1 * num2;
                            case '/' -> result = num1 / num2;
                        }
                        displayField.setText(String.valueOf(result));
                        operator = ' ';
                    }
                }
                case "+", "-", "*", "/" -> {
                    if (!displayField.getText().isEmpty()) {
                        num1 = Double.parseDouble(displayField.getText());
                        operator = command.charAt(0);
                        displayField.setText("");
                    }
                }
                default -> // Số
                    displayField.setText(displayField.getText() + command);
            }
        } catch (NumberFormatException ex) {
            displayField.setText("Error");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Bai4 calculator = new Bai4();
            calculator.setVisible(true);
        });
    }
}