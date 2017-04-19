package com.github.q9029.aikatsustars.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.q9029.aikatsustars.dto.Account;
import com.github.q9029.aikatsustars.repository.AccountsDao;
import com.github.q9029.aikatsustars.repository.constant.NamedQuery;

@Repository
public class AccountsDaoImpl implements AccountsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Account> findAll() {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリの取得
        Query<Account> query = session.createNamedQuery(NamedQuery.Account.findAll, Account.class);

        // クエリ実行
        return query.list();
    }

    @Override
    public Account findById() {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリの取得
        Query<Account> query = session.createNamedQuery(NamedQuery.Account.findById, Account.class);

        // クエリ実行
        return query.uniqueResult();
    }
}
