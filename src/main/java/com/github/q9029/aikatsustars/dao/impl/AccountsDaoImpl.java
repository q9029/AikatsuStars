package com.github.q9029.aikatsustars.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.q9029.aikatsustars.dao.AccountsDao;
import com.github.q9029.aikatsustars.dto.Account;

@Repository
public class AccountsDaoImpl implements AccountsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Account> findAll() {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリの取得
        Query<Account> query = session.createNamedQuery("findAll", Account.class);

        // クエリ実行
        return query.list();
    }

    @Override
    public List<Account> findAllValid() {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリの取得
        Query<Account> query = session.createNamedQuery("findValid", Account.class);

        // パラメータ設定
        query.setParameter("valid", true);

        // クエリ実行
        return query.list();
    }
}
