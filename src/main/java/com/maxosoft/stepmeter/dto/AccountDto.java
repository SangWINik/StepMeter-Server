package com.maxosoft.stepmeter.dto;

import com.maxosoft.stepmeter.db.model.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private Long id;
    private String email;
    private Date registrationDate;

    public AccountDto(Account account) {
        this.id = account.getId();
        this.email = account.getEmail();
        this.registrationDate = account.getRegistrationDate();
    }
}
