/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bai1;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author 20113
 */
public class Bai1 extends JFrame {
    // Các thành phần giao diện
    private final JTextField txtHo, txtTen, txtBiDanh, txtMatKhau;
    private final JRadioButton radNam, radNu, radKhongXacDinh;
    private final JComboBox<String> cboQueQuan;
    private final JCheckBox chkAnChoi, chkNhayMua, chkNghiNgoi;
    private final JTextArea txtGhiChu;
    private final JButton btnNhapMoi, btnLuu, btnThoat;

    public Bai1() {
        setTitle("Quản Lý Nhân Viên");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); // Hiển thị ở giữa màn hình
        setLayout(new BorderLayout());

        // Panel chính
        JPanel pnlMain = new JPanel(new GridLayout(4, 1));
        
        // Panel Họ Tên
        JPanel pnlHoTen = new JPanel(new GridLayout(2, 4));
        pnlHoTen.setBorder(BorderFactory.createTitledBorder("Họ Tên"));
        pnlHoTen.add(new JLabel("Họ:"));
        txtHo = new JTextField();
        pnlHoTen.add(txtHo);
        pnlHoTen.add(new JLabel("Tên:"));
        txtTen = new JTextField();
        pnlHoTen.add(txtTen);
        pnlHoTen.add(new JLabel("Bí Danh:"));
        txtBiDanh = new JTextField();
        pnlHoTen.add(txtBiDanh);
        pnlHoTen.add(new JLabel("Mật Khẩu:"));
        txtMatKhau = new JTextField();
        pnlHoTen.add(txtMatKhau);
        
        // Panel Giới Tính
        JPanel pnlGioiTinh = new JPanel(new FlowLayout());
        pnlGioiTinh.setBorder(BorderFactory.createTitledBorder("Giới Tính"));
        radNam = new JRadioButton("Nam", true);
        radNu = new JRadioButton("Nữ");
        radKhongXacDinh = new JRadioButton("Không xác định");
        ButtonGroup groupGioiTinh = new ButtonGroup();
        groupGioiTinh.add(radNam);
        groupGioiTinh.add(radNu);
        groupGioiTinh.add(radKhongXacDinh);
        pnlGioiTinh.add(radNam);
        pnlGioiTinh.add(radNu);
        pnlGioiTinh.add(radKhongXacDinh);
        
        // Panel Thông Tin Khác
        JPanel pnlThongTinKhac = new JPanel(new GridLayout(2, 2));
        pnlThongTinKhac.setBorder(BorderFactory.createTitledBorder("Thông Tin Khác"));
        pnlThongTinKhac.add(new JLabel("Quê Quán:"));
        cboQueQuan = new JComboBox<>(new String[]{"Item 1", "Item 2", "Item 3"});
        pnlThongTinKhac.add(cboQueQuan);
        pnlThongTinKhac.add(new JLabel("Sở Thích:"));
        JPanel pnlSoThich = new JPanel(new FlowLayout());
        chkAnChoi = new JCheckBox("Ăn chơi");
        chkNhayMua = new JCheckBox("Nhảy múa");
        chkNghiNgoi = new JCheckBox("Nghỉ ngơi");
        pnlSoThich.add(chkAnChoi);
        pnlSoThich.add(chkNhayMua);
        pnlSoThich.add(chkNghiNgoi);
        pnlThongTinKhac.add(pnlSoThich);
        
        // Panel Ghi Chú
        pnlThongTinKhac.add(new JLabel("Ghi Chú:"));
        txtGhiChu = new JTextArea(3, 20);
        JScrollPane scrollGhiChu = new JScrollPane(txtGhiChu);
        pnlThongTinKhac.add(scrollGhiChu);

        // Panel Chức Năng
        JPanel pnlChucNang = new JPanel(new FlowLayout());
        btnNhapMoi = new JButton("Nhập Mới");
        btnLuu = new JButton("Lưu");
        btnThoat = new JButton("Thoát");
        pnlChucNang.add(btnNhapMoi);
        pnlChucNang.add(btnLuu);
        pnlChucNang.add(btnThoat);

        // Thêm các panel vào giao diện
        pnlMain.add(pnlHoTen);
        pnlMain.add(pnlGioiTinh);
        pnlMain.add(pnlThongTinKhac);
        add(pnlMain, BorderLayout.CENTER);
        add(pnlChucNang, BorderLayout.SOUTH);

        // Xử lý sự kiện
        btnNhapMoi.addActionListener(e -> resetForm());
        btnLuu.addActionListener(e -> luuThongTin());
        btnThoat.addActionListener(e -> System.exit(0));
    }

    // Reset form
    private void resetForm() {
        txtHo.setText("");
        txtTen.setText("");
        txtBiDanh.setText("");
        txtMatKhau.setText("");
        radNam.setSelected(true);
        cboQueQuan.setSelectedIndex(0);
        chkAnChoi.setSelected(false);
        chkNhayMua.setSelected(false);
        chkNghiNgoi.setSelected(false);
        txtGhiChu.setText("");
    }

    // Lưu thông tin
    private void luuThongTin() {
        if (txtHo.getText().trim().isEmpty()) {
            txtHo.setBackground(Color.PINK);
            JOptionPane.showMessageDialog(this, "Họ không được để trống");
            return;
        } else {
            txtHo.setBackground(Color.WHITE);
        }

        if (txtTen.getText().trim().isEmpty()) {
            txtTen.setBackground(Color.PINK);
            JOptionPane.showMessageDialog(this, "Tên không được để trống");
            return;
        } else {
            txtTen.setBackground(Color.WHITE);
        }

        String gioiTinh = radNam.isSelected() ? "Nam" : radNu.isSelected() ? "Nữ" : "Không xác định";
        String soThich = (chkAnChoi.isSelected() ? "Ăn chơi " : "") +
                         (chkNhayMua.isSelected() ? "Nhảy múa " : "") +
                         (chkNghiNgoi.isSelected() ? "Nghỉ ngơi" : "");
        String thongTin = String.format("Họ: %s\nTên: %s\nBí Danh: %s\nMật Khẩu: %s\nGiới Tính: %s\nQuê Quán: %s\nSở Thích: %s\nGhi Chú: %s",
                                        txtHo.getText(), txtTen.getText(), txtBiDanh.getText(), txtMatKhau.getText(),
                                        gioiTinh, cboQueQuan.getSelectedItem(), soThich, txtGhiChu.getText());

        JOptionPane.showMessageDialog(this, thongTin, "Thông Tin Nhân Viên", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Bai1().setVisible(true);
        });
    }
}
