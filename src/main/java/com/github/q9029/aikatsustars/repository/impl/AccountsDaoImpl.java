package com.github.q9029.aikatsustars.repository.impl;

import java.io.Serializable;
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
    public Account load(long id) {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリ実行
        return session.get(Account.class, id);
    }

    @Override
    public Serializable save(Account account) {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリ実行
        return session.save(account);
    }

    @Override
    public void update(Account account) {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリ実行
        session.update(account);
    }

    @Override
    public void delete(Account account) {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリ実行
        session.delete(account);
    }

    @Override
    public List<Account> loadAll() {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリの取得
        Query<Account> query = session.createNamedQuery(NamedQuery.Account.loadAll, Account.class);

        // クエリ実行
        return query.list();
    }
}
