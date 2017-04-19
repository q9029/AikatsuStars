package com.github.q9029.aikatsustars.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.q9029.aikatsustars.dto.Volume;
import com.github.q9029.aikatsustars.repository.VolumeDao;
import com.github.q9029.aikatsustars.repository.constant.NamedQuery;

@Repository
public class VolumeDaoImpl implements VolumeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Volume> findAll() {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリの取得
        Query<Volume> query = session.createNamedQuery(NamedQuery.Volume.findAll, Volume.class);

        // クエリ実行
        return query.list();
    }

    @Override
    public Volume findById() {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリの取得
        Query<Volume> query = session.createNamedQuery(NamedQuery.Volume.findById, Volume.class);

        // クエリ実行
        return query.uniqueResult();
    }
}
