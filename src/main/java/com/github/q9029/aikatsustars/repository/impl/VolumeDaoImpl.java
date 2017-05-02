package com.github.q9029.aikatsustars.repository.impl;

import java.io.Serializable;
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
    public Volume load(long id) {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリ実行
        return session.load(Volume.class, id);
    }

    @Override
    public Serializable save(Volume volume) {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリ実行
        return session.save(volume);
    }

    @Override
    public void delete(Volume volume) {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリ実行
        session.delete(volume);
    }

    @Override
    public List<Volume> loadAll() {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリの取得
        Query<Volume> query = session.createNamedQuery(NamedQuery.Volume.loadAll, Volume.class);

        // クエリ実行
        return query.list();
    }
}
