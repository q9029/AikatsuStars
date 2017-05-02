package com.github.q9029.aikatsustars.repository.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.q9029.aikatsustars.dto.VolumeCard;
import com.github.q9029.aikatsustars.repository.VolumeCardDao;
import com.github.q9029.aikatsustars.repository.constant.NamedQuery;

@Repository
public class VolumeCardDaoImpl implements VolumeCardDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public VolumeCard load(long id) {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリ実行
        return session.load(VolumeCard.class, id);
    }

    @Override
    public Serializable save(VolumeCard volumeCard) {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリ実行
        return session.save(volumeCard);
    }

    @Override
    public void delete(VolumeCard volumeCard) {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリ実行
        session.delete(volumeCard);
    }

    @Override
    public List<VolumeCard> loadAll() {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリの取得
        Query<VolumeCard> query = session.createNamedQuery(NamedQuery.VolumeCard.loadAll, VolumeCard.class);

        // クエリ実行
        return query.list();
    }
}
