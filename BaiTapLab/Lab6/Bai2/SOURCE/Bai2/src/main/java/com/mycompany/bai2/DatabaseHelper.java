/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bai2;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 20113
 */
public class DatabaseHelper {
    public static Connection openConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLBook;"
            + "encrypt=false;trustServerCertificate=true;";
        String username = "sa";
        String password = "minhbao8102";
        return DriverManager.getConnection(connectionUrl, username, password);
    }
}
