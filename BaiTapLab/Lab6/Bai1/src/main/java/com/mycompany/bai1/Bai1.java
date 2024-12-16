/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bai1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 *
 * @author 20113
 */
public class Bai1 extends JFrame {
    // Các thành phần giao diện
    private JTextField txtMaSV, txtHoTen, txtEmail, txtSoDT, txtDiaChi;
    private JRadioButton rbtnNam, rbtnNu;
    private JButton btnNhapMoi, btnLuu, btnThoat, btnTimKiem, btnCapNhat, btnXoa;
    private JTable table;
    private DefaultTableModel tableModel;

    // Constructor
    public Bai1() {
        setTitle("Quản Lý Sinh Viên");
        setLayout(null);
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Thêm thành phần giao diện
        addComponents();

        // Hiển thị cửa sổ
        setVisible(true);
    }

    private void addComponents() {
        JLabel lblTitle = new JLabel("Quản Lý Sinh Viên", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setBounds(0, 10, 700, 30);
        add(lblTitle);

        JLabel lblMaSV = new JLabel("Mã SV:");
        lblMaSV.setBounds(50, 60, 100, 25);
        add(lblMaSV);
        txtMaSV = new JTextField();
        txtMaSV.setBounds(150, 60, 200, 25);
        add(txtMaSV);

        JLabel lblHoTen = new JLabel("Họ Tên:");
        lblHoTen.setBounds(50, 100, 100, 25);
        add(lblHoTen);
        txtHoTen = new JTextField();
        txtHoTen.setBounds(150, 100, 200, 25);
        add(txtHoTen);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(50, 140, 100, 25);
        add(lblEmail);
        txtEmail = new JTextField();
        txtEmail.setBounds(150, 140, 200, 25);
        add(txtEmail);

        JLabel lblSoDT = new JLabel("Số ĐT:");
        lblSoDT.setBounds(400, 140, 100, 25);
        add(lblSoDT);
        txtSoDT = new JTextField();
        txtSoDT.setBounds(470, 140, 200, 25);
        add(txtSoDT);

        JLabel lblGioiTinh = new JLabel("Giới Tính:");
        lblGioiTinh.setBounds(50, 180, 100, 25);
        add(lblGioiTinh);
        rbtnNam = new JRadioButton("Nam");
        rbtnNam.setBounds(150, 180, 60, 25);
        rbtnNu = new JRadioButton("Nữ");
        rbtnNu.setBounds(220, 180, 60, 25);
        ButtonGroup group = new ButtonGroup();
        group.add(rbtnNam);
        group.add(rbtnNu);
        add(rbtnNam);
        add(rbtnNu);

        JLabel lblDiaChi = new JLabel("Địa Chỉ:");
        lblDiaChi.setBounds(50, 220, 100, 25);
        add(lblDiaChi);
        txtDiaChi = new JTextField();
        txtDiaChi.setBounds(150, 220, 520, 25);
        add(txtDiaChi);

        // Nút chức năng
        btnNhapMoi = new JButton("Nhập Mới");
        btnNhapMoi.setBounds(50, 270, 100, 30);
        add(btnNhapMoi);

        btnLuu = new JButton("Lưu");
        btnLuu.setBounds(160, 270, 100, 30);
        add(btnLuu);

        btnThoat = new JButton("Thoát");
        btnThoat.setBounds(270, 270, 100, 30);
        add(btnThoat);

        btnTimKiem = new JButton("Tìm Kiếm");
        btnTimKiem.setBounds(380, 270, 100, 30);
        add(btnTimKiem);

        btnCapNhat = new JButton("Cập Nhật");
        btnCapNhat.setBounds(490, 270, 100, 30);
        add(btnCapNhat);

        btnXoa = new JButton("Xóa");
        btnXoa.setBounds(600, 270, 100, 30);
        add(btnXoa);

        // Bảng JTable
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã SV", "Họ Tên", "Email", "Số ĐT", "Giới Tính", "Địa Chỉ"});
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 320, 620, 200);
        add(scrollPane);

        // Xử lý sự kiện cho các nút
        handleEvents();
    }

    private void handleEvents() {
        btnNhapMoi.addActionListener(e -> resetForm());
        btnLuu.addActionListener(e -> saveStudent());
        btnThoat.addActionListener(e -> System.exit(0));
        btnTimKiem.addActionListener(e -> searchStudent());
        btnCapNhat.addActionListener(e -> updateStudent());
        btnXoa.addActionListener(e -> deleteStudent());
    }

    private void resetForm() {
        txtMaSV.setText("");
        txtHoTen.setText("");
        txtEmail.setText("");
        txtSoDT.setText("");
        txtDiaChi.setText("");
        rbtnNam.setSelected(false);
        rbtnNu.setSelected(false);
    }

    private void saveStudent() {
        try {
            if (txtMaSV.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Mã sinh viên không được để trống!");
                txtMaSV.setBackground(Color.PINK);
                return;
            }

            Student student = new Student();
            student.setMaSV(txtMaSV.getText());
            student.setHoTen(txtHoTen.getText());
            student.setEmail(txtEmail.getText());
            student.setSoDT(txtSoDT.getText());
            student.setGioiTinh(rbtnNam.isSelected() ? 1 : 0);
            student.setDiaChi(txtDiaChi.getText());

            StudentDAO dao = new StudentDAO();
            if (dao.insert(student)) {
                JOptionPane.showMessageDialog(this, "Sinh viên mới đã được lưu!");
                loadTableData();
                resetForm();
            } else {
                JOptionPane.showMessageDialog(this, "Lưu thất bại!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }

    private void loadTableData() {
        try {
            tableModel.setRowCount(0); // Xóa dữ liệu cũ
            StudentDAO dao = new StudentDAO();
            List<Student> list = dao.getAllStudents();

            for (Student student : list) {
                tableModel.addRow(new Object[]{
                    student.getMaSV(),
                    student.getHoTen(),
                    student.getEmail(),
                    student.getSoDT(),
                    student.getGioiTinh() == 1 ? "Nam" : "Nữ",
                    student.getDiaChi()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }

    private void searchStudent() {
        try {
            if (txtMaSV.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Mã sinh viên không được để trống!");
                txtMaSV.setBackground(Color.PINK);
                return;
            }

            StudentDAO dao = new StudentDAO();
            Student student = dao.findById(txtMaSV.getText());

            if (student != null) {
                txtHoTen.setText(student.getHoTen());
                txtEmail.setText(student.getEmail());
                txtSoDT.setText(student.getSoDT());
                txtDiaChi.setText(student.getDiaChi());
                if (student.getGioiTinh() == 1) {
                    rbtnNam.setSelected(true);
                } else {
                    rbtnNu.setSelected(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy sinh viên có mã: " + txtMaSV.getText());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }

    private void updateStudent() {
        try {
            if (txtMaSV.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Mã sinh viên không được để trống!");
                txtMaSV.setBackground(Color.PINK);
                return;
            }

            Student student = new Student();
            student.setMaSV(txtMaSV.getText());
            student.setHoTen(txtHoTen.getText());
            student.setEmail(txtEmail.getText());
            student.setSoDT(txtSoDT.getText());
            student.setGioiTinh(rbtnNam.isSelected() ? 1 : 0);
            student.setDiaChi(txtDiaChi.getText());

            StudentDAO dao = new StudentDAO();
            if (dao.update(student)) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                loadTableData();
                resetForm();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }


    private void deleteStudent() {
        try {
            if (txtMaSV.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Mã sinh viên không được để trống!");
                txtMaSV.setBackground(Color.PINK);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa không?", 
                                                         "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                StudentDAO dao = new StudentDAO();
                if (dao.delete(txtMaSV.getText())) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công!");
                    loadTableData();
                    resetForm();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại!");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai1());
    }
}
