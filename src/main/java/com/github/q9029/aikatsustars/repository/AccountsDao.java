package com.github.q9029.aikatsustars.repository;

import java.io.Serializable;
import java.util.List;

import com.github.q9029.aikatsustars.dto.Account;

public interface AccountsDao {

    Account load(long id);

    Serializable save(Account account);

    void delete(Account account);

    List<Account> loadAll();
}
