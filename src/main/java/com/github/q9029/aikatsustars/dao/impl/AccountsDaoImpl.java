package com.github.q9029.aikatsustars.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.github.q9029.aikatsustars.dao.AccountsDao;
import com.github.q9029.aikatsustars.dao.dto.Account;

@Repository
public class AccountsDaoImpl implements AccountsDao {

    /** JdbcTemplate. */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> selectAll() {
        return jdbcTemplate.query(
                "SELECT access_token, access_token_secret FROM accounts",
                new BeanPropertyRowMapper<Account>(Account.class));
    }
}
