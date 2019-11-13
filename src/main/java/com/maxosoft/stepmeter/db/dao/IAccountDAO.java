package com.maxosoft.stepmeter.db.dao;

import com.maxosoft.stepmeter.db.model.Account;

public interface IAccountDAO {
    Account getById(Long id);
    Account getByEmail(String email);
    void save(String email);
}
