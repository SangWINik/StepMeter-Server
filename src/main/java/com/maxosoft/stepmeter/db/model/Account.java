package com.maxosoft.stepmeter.db.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class Account {
    private Long id;
    private String email;
    private Boolean isAdmin;
    private Timestamp registrationDate;
}
