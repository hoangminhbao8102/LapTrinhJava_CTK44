/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab1;

import java.util.*;

/**
 *
 * @author 20113
 */
public class Lab1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| NGAN HANG SO | FX2011356@v1.0.0");
        System.out.println("+----------+-------------------------+----------+");

        OUTER:
        while (true) {
            System.out.println("+----------+-------------------------+----------+");
            System.out.println("| 1. Nhap CCCD                                  |");
            System.out.println("| 0. Thoat                                      |");
            System.out.println("+----------+-------------------------+----------+");
            System.out.print("Chuc nang: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0 -> {
                    System.out.println("Cam on ban da su dung chuong trinh!");
                    break OUTER;
                }
                case 1 -> handleCCCD(scanner);
                default -> System.out.println("Lua chon khong hop le. Vui long thu lai!");
            }
        }
    }
    
    private static void handleCCCD(Scanner scanner) {
        System.out.println("Chon kieu ma xac thuc:");
        System.out.println("1. Ma xac thuc bang so");
        System.out.println("2. Ma xac thuc bang ky tu ngau nhien");
        System.out.print("Lua chon: ");
        int authType = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String securityCode;
        switch (authType) {
            case 1 -> securityCode = generateNumericCode();
            case 2 -> securityCode = generateAlphanumericCode();
            default -> {
                System.out.println("Lua chon khong hop le!");
                return;
            }
        }

        System.out.println(securityCode);

        while (true) {
            System.out.print("Nhap ma xac thuc: ");
            String userInput = scanner.nextLine();

            if (userInput.equals(securityCode)) {
                System.out.println("Ma xac thuc chinh xac!");
                break;
            } else {
                System.out.println("Ma xac thuc khong dung. Vui long thu lai.");
            }
        }

        while (true) {
            System.out.print("Nhap so CCCD (hoac 'No' de thoat): ");
            String cccd = scanner.nextLine();

            if (cccd.equalsIgnoreCase("No")) {
                return;
            }

            if (isValidCCCD(cccd)) {
                handleCCCDDetails(cccd, scanner);
                break;
            } else {
                System.out.println("So CCCD khong hop le. Vui long thu lai.");
            }
        }
    }

    private static void handleCCCDDetails(String cccd, Scanner scanner) {
        OUTER:
        while (true) {
            System.out.println("\t| 1. Kiem tra noi sinh");
            System.out.println("\t| 2. Kiem tra tuoi, gioi tinh");
            System.out.println("\t| 3. Kiem tra so ngau nhien");
            System.out.println("\t| 0. Thoat");
            System.out.print("Chuc nang: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0 -> {
                    break OUTER;
                }
                case 1 -> {
                    String province = getProvinceByCode(cccd.substring(0, 3));
                    System.out.println("Noi Sinh: " + (province != null ? province : "Khong xac dinh"));
                }
                case 2 -> displayGenderAndBirthYear(cccd);
                case 3 -> System.out.println("So ngau nhien: " + cccd.substring(6));
                default -> System.out.println("Lua chon khong hop le. Vui long thu lai!");
            }
        }
    }

    private static boolean isValidCCCD(String cccd) {
        return cccd.matches("\\d{12}");
    }

    private static String getProvinceByCode(String code) {
        Map<String, String> provinces = new HashMap<>();
        provinces.put("001", "Ha Noi");
        provinces.put("002", "Ha Giang");
        provinces.put("004", "Cao Bang");
        provinces.put("006", "Bac Kan");
        provinces.put("008", "Tuyen Quang");
        provinces.put("010", "Lao Cai");
        provinces.put("011", "Dien Bien");
        provinces.put("012", "Lai Chau");
        provinces.put("014", "Son La");
        provinces.put("015", "Yen Bai");
        provinces.put("017", "Hoa Binh");
        provinces.put("019", "Thai Nguyen");
        provinces.put("020", "Lang Son");
        provinces.put("022", "Quang Ninh");
        provinces.put("024", "Bac Giang");
        provinces.put("025", "Phu Tho");
        provinces.put("026", "Vinh Phuc");
        provinces.put("027", "Bac Ninh");
        provinces.put("030", "Hai Duong");
        provinces.put("031", "Hai Phong");
        provinces.put("033", "Hung Yen");
        provinces.put("034", "Thai Binh");
        provinces.put("035", "Ha Nam");
        provinces.put("036", "Nam Dinh");
        provinces.put("037", "Ninh Binh");
        provinces.put("038", "Thanh Hoa");
        provinces.put("040", "Nghe An");
        provinces.put("042", "Ha Tinh");
        provinces.put("044", "Quang Binh");
        provinces.put("045", "Quang Tri");
        provinces.put("046", "Thua Thien Hue");
        provinces.put("048", "Da Nang");
        provinces.put("049", "Quang Nam");
        provinces.put("051", "Quang Ngai");
        provinces.put("052", "Bình Dinh");
        provinces.put("054", "Phu Yen");
        provinces.put("056", "Khanh Hoa");
        provinces.put("058", "Ninh Thuan");
        provinces.put("060", "Binh Thuan");
        provinces.put("062", "Kon Tum");
        provinces.put("064", "Gia Lai");
        provinces.put("066", "Dak Lak");
        provinces.put("067", "Dak Nong");
        provinces.put("068", "Lam Dong");
        provinces.put("070", "Binh Phuoc");
        provinces.put("072", "Tay Ninh");
        provinces.put("074", "Binh Duong");
        provinces.put("075", "Dong Nai");
        provinces.put("077", "Ba Ria - Vung Tau");
        provinces.put("079", "TP. Ho Chi Minh");
        provinces.put("080", "Long An");
        provinces.put("082", "Tien Giang");
        provinces.put("083", "Ben Tre");
        provinces.put("084", "Tra Vinh");
        provinces.put("086", "Vinh Long");
        provinces.put("087", "Dong Thap");
        provinces.put("089", "An Giang");
        provinces.put("091", "Kien Giang");
        provinces.put("092", "Can Tho");
        provinces.put("093", "Hau Giang");
        provinces.put("094", "Soc Trang");
        provinces.put("095", "Bac Lieu");
        provinces.put("096", "Ca Mau");
        return provinces.get(code);
    }

    private static void displayGenderAndBirthYear(String cccd) {
        int genderCode = Character.getNumericValue(cccd.charAt(3));
        int birthYear = Integer.parseInt(cccd.substring(4, 6));
        int century = 1900 + (genderCode / 2) * 100;
        String gender = (genderCode % 2 == 0) ? "Nam" : "Nu";
        System.out.println("Gioi tinh: " + gender + " | " + (century + birthYear));
    }

    private static String generateNumericCode() {
        Random random = new Random();
        return String.valueOf(100 + random.nextInt(900)); // Random 3-digit number
    }

    private static String generateAlphanumericCode() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            if (random.nextBoolean()) {
                sb.append((char) (random.nextInt(26) + 'A')); // Uppercase letter
            } else {
                sb.append((char) (random.nextInt(26) + 'a')); // Lowercase letter
            }
        }
        return sb.toString();
    }
}
