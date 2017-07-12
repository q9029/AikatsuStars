package com.github.q9029.aikatsustars.repository.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.q9029.aikatsustars.dto.CardDto;
import com.github.q9029.aikatsustars.repository.CardsDao;
import com.github.q9029.aikatsustars.repository.constant.NamedQuery;

@Repository
public class CardsDaoImpl implements CardsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public CardDto load(long id) {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリ実行
        return session.load(CardDto.class, id);
    }

    @Override
    public Serializable save(CardDto card) {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリ実行
        return session.save(card);
    }

    @Override
    public void delete(CardDto card) {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリ実行
        session.delete(card);
    }

    @Override
    public List<CardDto> loadAll() {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリの取得
        Query<CardDto> query = session.createNamedQuery(NamedQuery.Card.loadAll, CardDto.class);

        // クエリ実行
        return query.list();
    }
}
