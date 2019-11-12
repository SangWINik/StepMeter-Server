package com.maxosoft.stepmeter.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://stepmeter.best:3306/stepmete_stepmeter_db?serverTimezone=UTC","stepmete_root","V6mdwaMM4xcd3vE");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
