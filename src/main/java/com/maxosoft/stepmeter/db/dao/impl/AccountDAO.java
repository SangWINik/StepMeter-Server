package com.maxosoft.stepmeter.db.dao.impl;

import com.maxosoft.stepmeter.db.dao.IAccountDAO;
import com.maxosoft.stepmeter.db.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Repository
public class AccountDAO implements IAccountDAO {

    @Autowired
    private Connection connection;

    @Override
    public Account getById(Long id) {
        if (id == null) {
            return null;
        }

        Account account = null;
        try {
            Statement statement = connection.createStatement();
            String query = String.format("SELECT * FROM account WHERE id=%s", id);
            System.out.println(String.format("Executing query: %s", query));
            ResultSet rs = statement.executeQuery(query);
            boolean exists = rs.next();
            if (exists) {
                account = this.getFromResultSet(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return account;
    }

    @Override
    public Account getByEmail(String email) {
        if (email == null || email.isEmpty()) {
            return null;
        }

        Account account = null;
        try {
            Statement statement = connection.createStatement();
            String query = String.format("SELECT * FROM account WHERE email='%s'", email);
            System.out.println(String.format("Executing query: %s", query));
            ResultSet rs = statement.executeQuery(query);
            boolean exists = rs.next();
            if (exists) {
                account = this.getFromResultSet(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return account;
    }

    @Override
    public void save(String email) {
        if (email == null || email.isEmpty()) {
            return;
        }

        Account account = this.getByEmail(email);
        if (account == null) {
            try {
                Statement statement = connection.createStatement();
                String query = String.format("INSERT INTO account (email, registrationDate) VALUES ('%s', now())", email);
                System.out.println(String.format("Executing query: %s", query));
                statement.executeUpdate(query);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Account getFromResultSet(ResultSet resultSet) throws Exception {
        Account account = new Account();
        account.setId(resultSet.getLong("id"));
        account.setEmail(resultSet.getString("email"));
        account.setRegistrationDate(resultSet.getTimestamp("registrationDate"));
        return account;
    }
}
