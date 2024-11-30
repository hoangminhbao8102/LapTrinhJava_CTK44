/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab2;

import com.mycompany.lab2.Model.Bank;
import com.mycompany.lab2.Model.Customer;
import com.mycompany.lab2.Model.Account;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author 20113
 */
public class Lab2 {

    private static final Bank bank = new Bank();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("+----------+-------------------------+----------+");
            System.out.println("| NGAN HANG SO | FX2011356@v1.0.0");
            System.out.println("+----------+-------------------------+----------+");
            System.out.println("1. Them khach hang");
            System.out.println("2. Them tai khoan cho khach hang");
            System.out.println("3. Hien thi danh sach khach hang");
            System.out.println("4. Tim theo CCCD");
            System.out.println("5. Tim theo ten khach hang");
            System.out.println("0. Thoat");
            System.out.println("+----------+-------------------------+----------+");
            System.out.print("Chon chuc nang: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    // Thêm khách hàng
                    System.out.print("Nhap ten khach hang: ");
                    String name = scanner.nextLine();

                    System.out.print("Nhap so CCCD: ");
                    String cccd = scanner.nextLine();

                    try {
                        Customer customer = new Customer(name, cccd);
                        bank.addCustomer(customer);
                        System.out.println("Them khach hang thanh cong!");
                    } catch (Exception e) {
                        System.out.println("Loi: " + e.getMessage());
                    }
                }
                case 2 -> {
                    // Thêm tài khoản cho khách hàng
                    System.out.print("Nhap CCCD khach hang: ");
                    String customerID = scanner.nextLine();

                    if (!bank.isCustomerExisted(customerID)) {
                        System.out.println("Khong tim thay khach hang voi CCCD da nhap.");
                        break;
                    }

                    System.out.print("Nhap ma so tai khoan (6 chu so): ");
                    String accountNumber = scanner.nextLine();

                    System.out.print("Nhap so du tai khoan: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine();

                    if (balance < 50000) {
                        System.out.println("So du khong duoc nho hon 50,000 VND.");
                        break;
                    }

                    try {
                        Account account = new Account(accountNumber, balance);
                        bank.addAccount(customerID, account);
                        System.out.println("Them tai khoan thanh cong!");
                    } catch (Exception e) {
                        System.out.println("Loi: " + e.getMessage());
                    }
                }
                case 3 -> {
                    // Hiển thị danh sách khách hàng
                    List<Customer> customers = bank.getCustomers();
                    if (customers.isEmpty()) {
                        System.out.println("Khong co khach hang nao trong ngan hang.");
                    } else {
                        for (Customer customer : customers) {
                            customer.displayInformation();
                            System.out.println("--------------------");
                        }
                    }
                }
                case 4 -> {
                    // Tìm theo CCCD
                    System.out.print("Nhap so CCCD can tim: ");
                    String searchCCCD = scanner.nextLine();

                    Customer foundCustomer = bank.getCustomers().stream()
                            .filter(c -> c.getCustomerId().equals(searchCCCD))
                            .findFirst()
                            .orElse(null);
                    
                    if (foundCustomer != null) {
                        foundCustomer.displayInformation();
                    } else {
                        System.out.println("Khong tim thay khach hang voi CCCD: " + searchCCCD);
                    }
                }
                case 5 -> {
                    // Tìm theo tên khách hàng
                    System.out.print("Nhap tu khoa ten khach hang: ");
                    String keyword = scanner.nextLine().toLowerCase();

                    List<Customer> matchedCustomers = bank.getCustomers().stream()
                            .filter(c -> c.getName().toLowerCase().contains(keyword))
                            .toList();
                    
                    if (matchedCustomers.isEmpty()) {
                        System.out.println("Khong tim thay khach hang nao co ten chua: " + keyword);
                    } else {
                        for (Customer customer : matchedCustomers) {
                            customer.displayInformation();
                            System.out.println("--------------------");
                        }
                    }
                }
                case 0 -> {
                    System.out.println("Tam biet!");
                    return;
                }
                default -> System.out.println("Lua chon khong hop le!");
            }
        }
    }
}
