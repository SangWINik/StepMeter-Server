package com.maxosoft.stepmeter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
public class AppConfig {

    @Bean
    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://stepmeter.best:3306/stepmete_stepmeter_db?serverTimezone=UTC","stepmete_root","V6mdwaMM4xcd3vE");
    }
}
