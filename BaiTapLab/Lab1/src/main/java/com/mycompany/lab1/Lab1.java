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
        System.out.println("+----------------------+");
        System.out.println("| NGAN HANG SO        |");
        System.out.println("| FX123456@v1.0.0     |");
        System.out.println("+----------------------+");

        OUTER:
        while (true) {
            System.out.println("| 1. Nhap CCCD        |");
            System.out.println("| 0. Thoat            |");
            System.out.println("+----------------------+");
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
        String securityCode = generateSecurityCode();
        System.out.println("Nhap ma xa thuc: " + securityCode);

        while (true) {
            System.out.print("Nhap ma xa thuc: ");
            String userInput = scanner.nextLine();

            if (userInput.equals(securityCode)) {
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
            System.out.println("1. Kiem tra noi sinh");
            System.out.println("2. Kiem tra tuoi, gioi tinh");
            System.out.println("3. Kiem tra so ngau nhien");
            System.out.println("0. Thoat");
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
        provinces.put("079", "TP. Ho Chi Minh");
        provinces.put("037", "Ninh Binh");
        // Add other provinces here
        return provinces.get(code);
    }

    private static void displayGenderAndBirthYear(String cccd) {
        int genderCode = Character.getNumericValue(cccd.charAt(3));
        int birthYear = Integer.parseInt(cccd.substring(4, 6));
        int century = 1900 + (genderCode / 2) * 100;
        String gender = (genderCode % 2 == 0) ? "Nam" : "Nu";
        System.out.println("Gioi tinh: " + gender + " | " + (century + birthYear));
    }

    private static String generateSecurityCode() {
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
