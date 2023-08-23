/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1;

import java.util.Random;
import java.util.Scanner;
import com.mycompany.lab1.ThongTinCCCD;
/**
 *
 * @author Maxsys
 */
public class Menu {
    public static String NhapSoCCCD() {
        Scanner in = new Scanner(System.in);        
        System.out.print("Vui lòng nhập số CCCD: ");
        String cccd = in.nextLine();

        String isNumber = "[0-9]+";
        while (cccd.length() != 12 && !cccd.matches(isNumber)) {
            System.out.println("Số CCCD không hợp lệ.");
            System.out.println("Vui lòng thử lại hoặc 'No' để thoát: ");
            cccd = in.nextLine();
            if ("No".equals(cccd)) break;
        }
        return cccd;
    }
    
    public static void XuatMenu_NhapCCCD() {
        System.out.println("\t| 1. Kiểm tra nơi sinh");
        System.out.println("\t| 2. Kiểm tra tuổi, giới tính");
        System.out.println("\t| 3. Kiểm tra số ngẫu nhiên");
        System.out.println("\t| 0. Thoát");
        System.out.print("Chức năng: ");
        
    }
    
    public static int ChonMenu_NhapCCCD() {
        Scanner in = new Scanner(System.in);
        int stt;
        XuatMenu_NhapCCCD();
        stt = in.nextInt();
       
        return stt;
    }
    
    public static void XuLyMenu_NhapCCCD(int menu, String cccd) {
        ThongTinCCCD icccd = new ThongTinCCCD(cccd);
        switch (menu) {
            case 0 -> {
                System.out.println("Thoát chương trình!");
                return;
            }
            case 1 -> KiemTraNoiSinh(icccd.GetTinhTP());
            case 2 -> KiemTraTuoiGT(icccd.KiemTraTuoiGT());
            case 3 -> KiemTraSoNgauNhien(icccd.GetSoNgauNhien());
            default -> System.out.println("Lỗi");
        }  
    }

    public static void KiemTraTuoiGT(String gt) {
        System.out.println("Giới tính: " + gt);
    }

    private static void KiemTraNoiSinh(String ns) {
        System.out.println("Nơi sinh: " + ns);
    }
    
    public static void KiemTraSoNgauNhien(String sonn) {
        System.out.println("Số ngẫu nhiên: " + sonn);
    }
    
    public static void NhapCCCD(){
        Random r = new Random();
        Scanner in = new Scanner(System.in);
        int stt;
        
        int rOTP = r.nextInt(999 - 100 + 1) + 100;
        System.out.print("Nhập mã xác thực: " + rOTP + "\n");
        int inpOTP = in.nextInt();
        if (rOTP == inpOTP) {
            String cccd = NhapSoCCCD();
            do {
                stt = ChonMenu_NhapCCCD();
                XuLyMenu_NhapCCCD(stt, cccd);
            } while (stt > 0);
        }
    }
    public static void XuatMenu()
    {
        System.out.println("+--------------+----------------+");
        System.out.println("| NGÂN HÀNG SỐ | 2011400@v1.0.0 |"); 
        System.out.println("+--------------+----------------+"); 
        System.out.println("| 1. Nhập CCCD                  |");
        System.out.println("| 0. Thoát                      |");
        System.out.println("+-------------------------------+");
        System.out.print("Chức năng: ");
    }
    
    public static int ChonMenu() {
        Scanner in = new Scanner(System.in);
        XuatMenu();   
        
        int stt = in.nextInt();
        return stt;
    }
    
    public static void XuLyMenu(int menu){
        switch(menu){
            case 0 -> {
                System.out.println("Thoát chuong trình!");
                return;
            }
            case 1 -> NhapCCCD();
            default -> System.out.println("Lỗi");
        }
    }
}
