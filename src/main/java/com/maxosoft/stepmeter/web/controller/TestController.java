package com.maxosoft.stepmeter.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private Connection connection;

    @GetMapping(value = "/")
    public ResponseEntity testNoPath() {
        return ResponseEntity.ok("no path");
    }

    @GetMapping(value = "/test")
    public ResponseEntity test() {
        return ResponseEntity.ok("test");
    }

    @GetMapping(value = "/db")
    public ResponseEntity testDb() {
        List<String> rows = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM testtable");
            while (rs.next()) {
                rows.add(rs.getString("textcolumn"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(rows);
    }
}
