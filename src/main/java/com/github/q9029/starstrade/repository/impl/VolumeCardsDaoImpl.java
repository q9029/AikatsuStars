package com.github.q9029.starstrade.repository.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.q9029.starstrade.repository.VolumeCardsDao;
import com.github.q9029.starstrade.repository.constant.NamedQuery;
import com.github.q9029.starstrade.repository.dto.VolumeCardDto;

@Repository
public class VolumeCardsDaoImpl implements VolumeCardsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public VolumeCardDto load(long id) {
		// セッションの取得
		Session session = sessionFactory.getCurrentSession();

		// クエリ実行
		return session.load(VolumeCardDto.class, id);
	}

	@Override
	public Serializable save(VolumeCardDto volumeCard) {
		// セッションの取得
		Session session = sessionFactory.getCurrentSession();

		// クエリ実行
		return session.save(volumeCard);
	}

	@Override
	public void delete(VolumeCardDto volumeCard) {
		// セッションの取得
		Session session = sessionFactory.getCurrentSession();

		// クエリ実行
		session.delete(volumeCard);
	}

	@Override
	public List<VolumeCardDto> loadAll() {
		// セッションの取得
		Session session = sessionFactory.getCurrentSession();

		// クエリの取得
		Query<VolumeCardDto> query = session.createNamedQuery(NamedQuery.VolumeCard.loadAll, VolumeCardDto.class);

		// クエリ実行
		return query.list();
	}
}
