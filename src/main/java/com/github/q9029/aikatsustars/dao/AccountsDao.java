package com.github.q9029.aikatsustars.dao;

import java.util.List;

import com.github.q9029.aikatsustars.dao.dto.Account;

public interface AccountsDao {

    List<Account> selectAll();
}
