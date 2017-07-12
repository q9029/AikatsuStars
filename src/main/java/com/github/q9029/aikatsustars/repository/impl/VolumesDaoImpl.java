package com.github.q9029.aikatsustars.repository.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.q9029.aikatsustars.repository.VolumesDao;
import com.github.q9029.aikatsustars.repository.constant.NamedQuery;
import com.github.q9029.aikatsustars.repository.dto.VolumeDto;

@Repository
public class VolumesDaoImpl implements VolumesDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public VolumeDto load(long id) {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリ実行
        return session.load(VolumeDto.class, id);
    }

    @Override
    public Serializable save(VolumeDto volume) {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリ実行
        return session.save(volume);
    }

    @Override
    public void delete(VolumeDto volume) {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリ実行
        session.delete(volume);
    }

    @Override
    public List<VolumeDto> loadAll() {
        // セッションの取得
        Session session = sessionFactory.getCurrentSession();

        // クエリの取得
        Query<VolumeDto> query = session.createNamedQuery(NamedQuery.Volume.loadAll, VolumeDto.class);

        // クエリ実行
        return query.list();
    }
}
