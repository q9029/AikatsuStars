package com.github.q9029.aikatsustars.repository.impl;

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
    public List<VolumeCard> findAll() {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリの取得
        Query<VolumeCard> query = session.createNamedQuery(NamedQuery.VolumeCard.findAll, VolumeCard.class);

        // クエリ実行
        return query.list();
    }

    @Override
    public VolumeCard findById() {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリの取得
        Query<VolumeCard> query = session.createNamedQuery(NamedQuery.VolumeCard.findById, VolumeCard.class);

        // クエリ実行
        return query.uniqueResult();
    }
}
