package com.github.q9029.aikatsustars.repository.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.q9029.aikatsustars.dto.Card;
import com.github.q9029.aikatsustars.repository.CardDao;
import com.github.q9029.aikatsustars.repository.constant.NamedQuery;

@Repository
public class CardDaoImpl implements CardDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Card load(long id) {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリ実行
        return session.load(Card.class, id);
    }

    @Override
    public Serializable save(Card card) {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリ実行
        return session.save(card);
    }

    @Override
    public void delete(Card card) {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリ実行
        session.delete(card);
    }

    @Override
    public List<Card> loadAll() {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリの取得
        Query<Card> query = session.createNamedQuery(NamedQuery.Card.loadAll, Card.class);

        // クエリ実行
        return query.list();
    }
}
