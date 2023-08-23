/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab2;

import com.mycompany.lab2.asm02.models.Account;
import com.mycompany.lab2.asm02.models.Bank;
import com.mycompany.lab2.asm02.models.Customer;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
/**
 *
 * @author Maxsys
 */
public class Lab2 {
    private static final Bank bank = new Bank();
    public static void main(String[] args) throws Exception {
        int stt;
        do {
            stt = ChonMenu();
            XuLyMenu(stt);
        } while (stt > 0);
    }
    
    private static void XuatMenu() {
        System.out.println("+--------------+-------------------------------------+");
        System.out.println("| NGAN HANG SO |           FX2011400@v2.0.0          |");
        System.out.println("+--------------+-------------------------------------+");
        System.out.println("| 1. Them khach hang                                 |");
        System.out.println("| 2. Them tai khoan cho khach hang                   |");
        System.out.println("| 3. Hien thi danh sach khach hang                   |");
        System.out.println("| 4. Tim theo CCCD                                   |");
        System.out.println("| 5. Tim theo ten khach hang                         |");
        System.out.println("| 0. Thoat                                           |");
        System.out.println("+----------------------------------------------------+");
        System.out.print("Chuc nang: ");
    }

    private static int ChonMenu() {
        Scanner in = new Scanner(System.in);
        XuatMenu();   
        
        int stt = in.nextInt();
        return stt;
    }
    
    private static void XuLyMenu(int menu) throws Exception {
        switch (menu) {
            case 0 -> {
                System.out.println("Thoat chuong trinh!");
                return;
            }
            case 1 -> ThemKhachHang();
            case 2 -> ThemTaiKhoanKhachHang();
            case 3 -> HienThiDanhSachKhachHang();
            case 4 -> TimTheoCCCDKhachHang();
            case 5 -> TimTheoTenKhachHang();
            default -> System.out.println("Loi");
        }  
    }

    private static void ThemKhachHang() throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print("Nhap ten khach hang: ");
        String name = in.nextLine();
        String cccd;
        do {
            System.out.print("Nhap so CCCD: ");
            cccd = in.nextLine();
        } while (cccd.length() != 12);
        
        Customer customer = new Customer();
        customer.setName(name);
        customer.setCustomerId(cccd);
        bank.addCustomer(customer);
    }

    private static void ThemTaiKhoanKhachHang() {
        String cccd;
        Scanner in = new Scanner(System.in);
             
        do {
            System.out.print("Nhap CCCD khach hang: ");
            cccd = in.nextLine();
            for (Customer c:bank.getCustomers()) {
                if (c.getCustomerId().equals(cccd)) {
                    String maSTK;
                    double soDu;
                    do {
                        System.out.print("Nhap ma STK gom 6 chu so: ");
                        maSTK = in.nextLine();
                    } while(maSTK.length() != 6);
                    do {
                        System.out.print("Nhap so du: ");
                        soDu = in.nextDouble();
                    } while(soDu < 50000);
                    
                    c.addAccount(new Account(maSTK, soDu));
                    return;
                }
            }
        } while (true); 
    }

    private static void HienThiDanhSachKhachHang() throws UnsupportedEncodingException {
        for (Customer customer:bank.getCustomers()) {
            customer.displayInformation();
        }
    }

    private static void TimTheoCCCDKhachHang() throws UnsupportedEncodingException {
        Scanner in = new Scanner(System.in);
        
        do {
            System.out.print("Nhap CCCD khach hang: ");
            String cccd = in.nextLine();
            for (Customer c:bank.getCustomers()) {
                if (c.getCustomerId().equals(cccd)) {
                    c.displayInformation();
                    return;
                }
            }
        } while (true);
    }

    private static void TimTheoTenKhachHang() throws UnsupportedEncodingException {
        Scanner in = new Scanner(System.in);
        System.out.print("Nhap ten khach hang: ");
        String ten = in.nextLine();
        for (Customer c:bank.getCustomers()) {
                String check = "(.*)" + ten.toLowerCase() + "(.*)";
                if (c.getName().toLowerCase().matches(check))
                    c.displayInformation();
        }
    }
}
