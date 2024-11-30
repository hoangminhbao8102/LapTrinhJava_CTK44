/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3.models;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author 20113
 */
public class Utils {
    // Tạo đường kẻ phân cách
    public static String getDivider() {
        return "+----------------------------------------------+";
    }

    // Lấy ngày giờ hiện tại dưới dạng chuỗi
    public static String getDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formatter.format(Calendar.getInstance().getTime());
    }

    // Định dạng số tiền thành chuỗi với dấu phân cách hàng nghìn
    public static String formatBalance(double balance) {
        DecimalFormat formatter = new DecimalFormat("#,### VND");
        return formatter.format(balance);
    }
}
