/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bai1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 20113
 */
public class StudentDAO {
    public boolean insert(Student student) throws Exception {
        String sql = "INSERT INTO SinhVien(MaSV, HoTen, Email, SoDT, GioiTinh, DiaChi) VALUES(?,?,?,?,?,?)";
        try (Connection con = DatabaseHelper.openConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, student.getMaSV());
            pstmt.setString(2, student.getHoTen());
            pstmt.setString(3, student.getEmail());
            pstmt.setString(4, student.getSoDT());
            pstmt.setInt(5, student.getGioiTinh());
            pstmt.setString(6, student.getDiaChi());
            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean update(Student student) throws Exception {
        String sql = "UPDATE SinhVien SET HoTen=?, Email=?, SoDT=?, GioiTinh=?, DiaChi=? WHERE MaSV=?";
        try (Connection con = DatabaseHelper.openConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, student.getHoTen());
            pstmt.setString(2, student.getEmail());
            pstmt.setString(3, student.getSoDT());
            pstmt.setInt(4, student.getGioiTinh());
            pstmt.setString(5, student.getDiaChi());
            pstmt.setString(6, student.getMaSV());
            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean delete(String maSV) throws Exception {
        String sql = "DELETE FROM SinhVien WHERE MaSV=?";
        try (Connection con = DatabaseHelper.openConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, maSV);
            return pstmt.executeUpdate() > 0;
        }
    }

    public Student findById(String maSV) throws Exception {
        String sql = "SELECT * FROM SinhVien WHERE MaSV=?";
        try (Connection con = DatabaseHelper.openConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, maSV);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Student student = new Student();
                    student.setMaSV(rs.getString("MaSV"));
                    student.setHoTen(rs.getString("HoTen"));
                    student.setEmail(rs.getString("Email"));
                    student.setSoDT(rs.getString("SoDT"));
                    student.setGioiTinh(rs.getInt("GioiTinh"));
                    student.setDiaChi(rs.getString("DiaChi"));
                    return student;
                }
            }
        }
        return null;
    }
    
    public List<Student> getAllStudents() throws Exception {
        String sql = "SELECT * FROM SinhVien";
        List<Student> list = new ArrayList<>();
        try (Connection con = DatabaseHelper.openConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Student student = new Student();
                student.setMaSV(rs.getString("MaSV"));
                student.setHoTen(rs.getString("HoTen"));
                student.setEmail(rs.getString("Email"));
                student.setSoDT(rs.getString("SoDT"));
                student.setGioiTinh(rs.getInt("GioiTinh"));
                student.setDiaChi(rs.getString("DiaChi"));
                list.add(student);
            }
        }
        return list;
    }
}
