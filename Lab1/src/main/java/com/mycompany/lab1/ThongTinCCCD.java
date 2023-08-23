/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1;

import com.mycompany.lab1.TinhTP;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Maxsys
 */
public class ThongTinCCCD {
    public ArrayList<TinhTP> DSTinhTP = new ArrayList<TinhTP>(
        Arrays.asList(
            new TinhTP("Hà Nội","001"),
                    new TinhTP("Hà Giang","002"),
                    new TinhTP("Cao Bằng", "004"),
                    new TinhTP("Bắc Kạn", "006"),
                    new TinhTP("Tuyên Quang", "008"),
                    new TinhTP("Lào Cai", "010"),
                    new TinhTP("Điện Biên", "011"),
                    new TinhTP("Lai Châu","012"),
                    new TinhTP("Sơn La","014"),
                    new TinhTP("Yên Bái","015"),
                    new TinhTP("Hòa Bình","017"),
                    new TinhTP("Thái Nguyên","019"),
                    new TinhTP("Lạng Sơn","020"),
                    new TinhTP("Quảng Ninh","022"),
                    new TinhTP("Bắc Giang","024"),
                    new TinhTP("Phú Thọ","025"),
                    new TinhTP("Vĩnh Phúc","026"),
                    new TinhTP("Bắc Ninh","027"),
                    new TinhTP("Hải Dương","030"),
                    new TinhTP("Hải Phòng","031"),
                    new TinhTP("Hưng Yên","033"),
                    new TinhTP("Thái Bình","034"),
                    new TinhTP("Hà Nam","035"),
                    new TinhTP("Nam Định","036"),
                    new TinhTP("Ninh Bình","037"),
                    new TinhTP("Thanh Hóa","038"),
                    new TinhTP("Nghệ An","040"),
                    new TinhTP("Hà Tĩnh","042"),
                    new TinhTP("Quảng Bình","044"),
                    new TinhTP("Quảng Trị","045"),
                    new TinhTP("Thừa Thiên Huế","046"),
                    new TinhTP("Đà Nẵng","048"),
                    new TinhTP("Quảng Nam","049"),
                    new TinhTP("Quảng Ngãi","051"),
                    new TinhTP("Bình Định","052"),
                    new TinhTP("Phú Yên","054"),
                    new TinhTP("Khánh Hòa","056"),
                    new TinhTP("Ninh Thuận","058"),
                    new TinhTP("Bình Thuận","060"),
                    new TinhTP("Kon Tum","062"),
                    new TinhTP("Gia Lai","064"),
                    new TinhTP("Đắk Lắk","066"),
                    new TinhTP("Đắk Nông","067"),
                    new TinhTP("Lâm Đồng","068"),
                    new TinhTP("Bình Phước","070"),
                    new TinhTP("Tây Ninh","072"),
                    new TinhTP("Bình Dương","074"),
                    new TinhTP("Đồng Nai","075"),
                    new TinhTP("Bà Rịa - Vũng Tàu","077"),
                    new TinhTP("Hồ Chí Minh","079"),
                    new TinhTP("Long An","080"),
                    new TinhTP("Tiền Giang","082"),
                    new TinhTP("Bến Tre","083"),
                    new TinhTP("Trà Vinh","084"),
                    new TinhTP("Vĩnh Long","086"),
                    new TinhTP("Đồng Tháp","087"),
                    new TinhTP("An Giang","089"),
                    new TinhTP("Kiên Giang","091"),
                    new TinhTP("Cần Thơ","092"),
                    new TinhTP("Hậu Giang","093"),
                    new TinhTP("Sóc Trăng","094"),
                    new TinhTP("Bạc Liêu","095"),
                    new TinhTP("Cà Mau","096")
    )
    );
    private String TinhTP;
    private String GioiTinh;
    private int NamSinh;
    private String SoNN;
    
    private String XuLyTinhTP(String ma){
        for (int i = 0; i < DSTinhTP.size(); i++)
            if((DSTinhTP.get(i).MaTinhTP).equals(ma))
                return DSTinhTP.get(i).TenTinhTP;
        return "Lỗi";
    }
    
    private String XuLyGioiTinh(String s){
        int gt = Integer.parseInt(s);
        String check = (gt % 2 == 0) ? "Nam" : "Nữ";
        return check;
    }
    
    private int XuLyNamSinh(String nam, String s){
        int ns;
        if (Integer.parseInt(s) % 2 == 0)
            ns = Integer.parseInt(nam) + 100 * (19 + Integer.parseInt(s)/2);
        else
            ns = Integer.parseInt(nam) + 100 * (19 + (Integer.parseInt(s) + 1) / 2 - 1);
        return ns;
    }
    
    public ThongTinCCCD() {}
    
    public String GetTinhTP(){
        return TinhTP;
    }
    
    public String GetGioiTinh(){
        return GioiTinh;
    }
    
    public int GetNamSinh(){
        return NamSinh;
    }
    
    public String GetSoNgauNhien(){
        return SoNN;
    }
    
    public ThongTinCCCD(String CCCD){
        this.TinhTP = XuLyTinhTP(CCCD.substring(0,3));
        this.GioiTinh = XuLyGioiTinh(CCCD.substring(3, 4));
        this.NamSinh = XuLyNamSinh(CCCD.substring(4, 6), CCCD.substring(3, 4));
        this.SoNN = CCCD.substring(6);
    } 
    
    public void GetThongTin(){
        System.out.println(TinhTP);
        System.out.println(GioiTinh);
        System.out.println(NamSinh);
        System.out.println(SoNN);
    }
    
    public String KiemTraTuoiGT(){
        return GioiTinh + " | " + NamSinh;
    }
}
