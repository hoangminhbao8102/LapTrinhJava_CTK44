/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1;
import java.util.Scanner;
/**
 *
 * @author Maxsys
 */
public class Menu {
    public static void XuatMenu()
    {
        System.out.println("+--------------+----------------+");
        System.out.println("| NGAN HANG SO | 2011400@v1.0.0 |"); 
        System.out.println("+--------------+----------------+"); 
        System.out.println("| 1. Nhap CCCD                  |");
        System.out.println("| 0. Thoat                      |");
        System.out.println("+-------------------------------+");
        System.out.print("Chuc nang: ");
    }
    
    public static int ChonMenu() {
        Scanner in = new Scanner(System.in);
        XuatMenu();   
        
        int stt = in.nextInt();
        return stt;
    }
}
