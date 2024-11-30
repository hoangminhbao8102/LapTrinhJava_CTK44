/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bai3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author 20113
 */
public class Bai3 extends JFrame {
    private JTextField txtName;
    private JTextArea txtAddress;
    private JRadioButton rbMale, rbFemale;
    private JComboBox<String> cbQualification;
    private JCheckBox cbReading, cbSinging, cbDancing;
    private final JButton btnOkay, btnReset;

    public Bai3() {
        setTitle("Student Detail");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Center the window on the screen
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create components
        JLabel lblTitle = new JLabel("Student Detail", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setBounds(100, 10, 200, 30);
        add(lblTitle);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(20, 50, 80, 25);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(100, 50, 150, 25);
        add(txtName);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(20, 80, 80, 25);
        add(lblAddress);

        txtAddress = new JTextArea();
        txtAddress.setBounds(100, 80, 150, 60);
        add(new JScrollPane(txtAddress));

        JLabel lblSex = new JLabel("Sex:");
        lblSex.setBounds(20, 150, 80, 25);
        add(lblSex);

        rbMale = new JRadioButton("Male");
        rbMale.setBounds(100, 150, 60, 25);
        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(160, 150, 80, 25);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);

        add(rbMale);
        add(rbFemale);

        JLabel lblQualification = new JLabel("Qualification:");
        lblQualification.setBounds(20, 180, 100, 25);
        add(lblQualification);

        cbQualification = new JComboBox<>(new String[]{"Undergraduate", "Graduate", "Postgraduate"});
        cbQualification.setBounds(100, 180, 150, 25);
        add(cbQualification);

        JLabel lblHobby = new JLabel("Hobby:");
        lblHobby.setBounds(270, 50, 80, 25);
        add(lblHobby);

        cbReading = new JCheckBox("Reading");
        cbReading.setBounds(270, 80, 100, 25);
        add(cbReading);

        cbSinging = new JCheckBox("Singing");
        cbSinging.setBounds(270, 110, 100, 25);
        add(cbSinging);

        cbDancing = new JCheckBox("Dancing");
        cbDancing.setBounds(270, 140, 100, 25);
        add(cbDancing);

        btnOkay = new JButton("Okay");
        btnOkay.setBounds(100, 220, 80, 30);
        add(btnOkay);

        btnReset = new JButton("Reset");
        btnReset.setBounds(200, 220, 80, 30);
        add(btnReset);

        // Add action listeners
        btnOkay.addActionListener((ActionEvent e) -> {
            String name1 = txtName.getText();
            String address = txtAddress.getText();
            String gender = rbMale.isSelected() ? "Male" : rbFemale.isSelected() ? "Female" : "Not Selected";
            String qualification = cbQualification.getSelectedItem().toString();
            String hobbies = "";
            if (cbReading.isSelected()) hobbies += "Reading ";
            if (cbSinging.isSelected()) hobbies += "Singing ";
            if (cbDancing.isSelected()) hobbies += "Dancing ";
            String message = String.format("Name: %s\nAddress: %s\nSex: %s\nQualification: %s\nHobbies: %s", name1, address, gender, qualification, hobbies);
            JOptionPane.showMessageDialog(null, message, "Student Detail", JOptionPane.INFORMATION_MESSAGE);
        });

        btnReset.addActionListener((ActionEvent e) -> {
            txtName.setText("");
            txtAddress.setText("");
            genderGroup.clearSelection();
            cbQualification.setSelectedIndex(0);
            cbReading.setSelected(false);
            cbSinging.setSelected(false);
            cbDancing.setSelected(false);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Bai3().setVisible(true);
        });
    }
}
