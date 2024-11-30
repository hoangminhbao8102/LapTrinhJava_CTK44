/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bai1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 20113
 */
public class Bai1 extends JFrame {
    private final JTextField txtFirstNumber, txtSecondNumber, txtResult;
    private final JButton btnAdd, btnSubtract, btnMultiply, btnDivide;

    public Bai1() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new GridLayout(4, 2, 5, 5));

        // Center the window on screen
        setLocationRelativeTo(null);

        // Initialize components
        JLabel lblFirstNumber = new JLabel("First Number:");
        JLabel lblSecondNumber = new JLabel("Second Number:");
        JLabel lblResult = new JLabel("Result:");
        
        txtFirstNumber = new JTextField();
        txtSecondNumber = new JTextField();
        txtResult = new JTextField();
        txtResult.setEditable(false); // Make result field read-only
        
        btnAdd = new JButton("+");
        btnSubtract = new JButton("-");
        btnMultiply = new JButton("*");
        btnDivide = new JButton("/");

        // Add components to frame
        add(lblFirstNumber);
        add(txtFirstNumber);
        add(lblSecondNumber);
        add(txtSecondNumber);
        add(lblResult);
        add(txtResult);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnSubtract);
        buttonPanel.add(btnMultiply);
        buttonPanel.add(btnDivide);
        add(new JLabel()); // Empty placeholder
        add(buttonPanel);

        // Add event listeners
        btnAdd.addActionListener(new CalculatorActionListener("+"));
        btnSubtract.addActionListener(new CalculatorActionListener("-"));
        btnMultiply.addActionListener(new CalculatorActionListener("*"));
        btnDivide.addActionListener(new CalculatorActionListener("/"));
    }

    private class CalculatorActionListener implements ActionListener {
        private final String operation;

        public CalculatorActionListener(String operation) {
            this.operation = operation;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double num1 = Double.parseDouble(txtFirstNumber.getText());
                double num2 = Double.parseDouble(txtSecondNumber.getText());
                double result = 0;

                switch (operation) {
                    case "+" -> result = num1 + num2;
                    case "-" -> result = num1 - num2;
                    case "*" -> result = num1 * num2;
                    case "/" -> {
                        if (num2 == 0) {
                            JOptionPane.showMessageDialog(Bai1.this,
                                    "Cannot divide by zero!",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        result = num1 / num2;
                    }
                }

                txtResult.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Bai1.this, 
                    "Please enter valid numbers!", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Bai1 calculator = new Bai1();
            calculator.setVisible(true);
        });
    }
}