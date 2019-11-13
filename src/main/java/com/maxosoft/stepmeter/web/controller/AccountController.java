package com.maxosoft.stepmeter.web.controller;

import com.maxosoft.stepmeter.db.dao.IAccountDAO;
import com.maxosoft.stepmeter.db.model.Account;
import com.maxosoft.stepmeter.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    private IAccountDAO accountDAO;

    @GetMapping(value = "/accounts/{accountId}")
    public ResponseEntity getAccountById(@PathVariable Long accountId) {
        Account account = accountDAO.getById(accountId);
        if (account != null) {
            return ResponseEntity.ok(new AccountDto(account));
        } else {
            return ResponseEntity.ok("Account not found");
        }
    }

    @GetMapping(value = "/accounts")
    public ResponseEntity getAccountByEmail(@RequestParam String email) {
        Account account = accountDAO.getByEmail(email);
        if (account != null) {
            return ResponseEntity.ok(new AccountDto(account));
        } else {
            return ResponseEntity.ok("Account not found");
        }
    }

    @PostMapping(value = "/accounts")
    public void saveAccount(@RequestParam String email) {
        accountDAO.save(email);
    }
}
