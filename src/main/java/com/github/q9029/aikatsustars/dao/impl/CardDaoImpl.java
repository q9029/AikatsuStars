package com.github.q9029.aikatsustars.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.q9029.aikatsustars.dao.CardDao;
import com.github.q9029.aikatsustars.dao.constant.NamedQuery;
import com.github.q9029.aikatsustars.dto.Card;

@Repository
public class CardDaoImpl implements CardDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Card> findAll() {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリの取得
        Query<Card> query = session.createNamedQuery(NamedQuery.Card.findAll, Card.class);

        // クエリ実行
        return query.list();
    }

    @Override
    public Card findById() {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリの取得
        Query<Card> query = session.createNamedQuery(NamedQuery.Card.findById, Card.class);

        // クエリ実行
        return query.uniqueResult();
    }
}
