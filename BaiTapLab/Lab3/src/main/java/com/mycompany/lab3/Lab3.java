/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab3;
import com.mycompany.lab3.Model.Account;
import com.mycompany.lab3.models.DigitalBank;
import com.mycompany.lab3.models.DigitalCustomer;
import com.mycompany.lab3.models.LoansAccount;
import com.mycompany.lab3.models.SavingsAccount;
import com.mycompany.lab3.models.Transaction;
import java.util.Scanner;


/**
 *
 * @author 20113
 */
public class Lab3 {
    private static final int EXIT_COMMAND_CODE = 0;
    private static final int EXIT_ERROR_CODE = -1;
    private static final Scanner scanner = new Scanner(System.in);
    private static final DigitalBank activeBank = new DigitalBank();
    private static final String CUSTOMER_ID = "001215000001";
    private static final String CUSTOMER_NAME = "FUNIX";

    public static void main(String[] args) {
        // Thêm khách hàng mặc định vào ngân hàng
        try (scanner) {
            activeBank.addCustomer(CUSTOMER_ID, CUSTOMER_NAME);

            System.out.println("+----------+-------------------------+----------+");
            System.out.println("| NGAN HANG SO | FX2011356@v3.0.0");
            System.out.println("+----------+-------------------------+----------+");

            int choice;
            do {
                System.out.println("1. Thong tin khach hang"); 
                System.out.println("2. Them tai khoan Savings");
                System.out.println("3. Them tai khoan Loan");
                System.out.println("4. Rut tien");
                System.out.println("5. Lich su giao dich");
                System.out.println("0. Thoat");
                System.out.println("+----------+-------------------------+----------+");
                System.out.print("Chon chuc nang: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Đọc dòng trống

                switch (choice) {
                    case 1 -> {
                        // Hiển thị thông tin khách hàng
                        DigitalCustomer customer = activeBank.getCustomerById(CUSTOMER_ID);
                        if (customer != null) {
                            customer.displayInformation();
                        } else {
                            System.out.println("Khong tim thay khach hang!");
                        }
                    }
                    case 2 -> {
                        // Thêm tài khoản tiết kiệm
                        System.out.print("Nhap so tai khoan: ");
                        String accountNumber = scanner.nextLine();
                        System.out.print("Nhap so du ban dau: ");
                        double balance = scanner.nextDouble();
                        SavingsAccount savingsAccount = new SavingsAccount(accountNumber, balance);
                        activeBank.addAccount(CUSTOMER_ID, savingsAccount);
                    }
                    case 3 -> {
                        // Thêm tài khoản vay
                        System.out.print("Nhap so tai khoan: ");
                        String accountNumber = scanner.nextLine();
                        System.out.print("Nhap so du ban dau: ");
                        double balance = scanner.nextDouble();
                        System.out.print("La tai khoan premium? (true/false): ");
                        boolean isPremium = scanner.nextBoolean();
                        LoansAccount loansAccount = new LoansAccount(accountNumber, balance, isPremium);
                        activeBank.addAccount(CUSTOMER_ID, loansAccount);
                    }
                    case 4 -> {
                        // Rút tiền
                        System.out.print("Nhap so tai khoan: ");
                        String accountNumber = scanner.nextLine();
                        System.out.print("Nhap so tien muon rut: ");
                        double amount = scanner.nextDouble();
                        activeBank.withdraw(CUSTOMER_ID, accountNumber, amount);
                    }
                    case 5 -> {
                        // Hiển thị lịch sử giao dịch
                        DigitalCustomer customer = activeBank.getCustomerById(CUSTOMER_ID);
                        if (customer != null) {
                            System.out.println("+--------------+--------------+-------------+----------------------+------------+");
                            System.out.println("| Ma Giao Dich | So Tai Khoan | So Tien     | Thoi Gian            | Trang Thai |");
                            System.out.println("+--------------+--------------+-------------+----------------------+------------+");
                            for (Account account : customer.getAccounts()) {
                                if (account instanceof SavingsAccount || account instanceof LoansAccount) {
                                    // In lịch sử giao dịch nếu có
                                    for (Transaction transaction : account.getTransactions()) {
                                        transaction.displayTransaction();
                                    }
                                }
                            }
                            System.out.println("+--------------+--------------+-------------+----------------------+------------+");
                        } else {
                            System.out.println("Khong tim thay khach hang!");
                        }
                    }
                    case 0 -> {
                        System.out.println("Tam biet!");
                        return;
                    }
                    default -> System.out.println("Lua chon khong hop le!");
                }
            } while (choice != 0);
        }
    }
}
