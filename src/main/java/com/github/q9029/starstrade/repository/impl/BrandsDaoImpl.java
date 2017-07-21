package com.github.q9029.starstrade.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.q9029.starstrade.repository.BrandsDao;
import com.github.q9029.starstrade.repository.constant.NamedQuery;
import com.github.q9029.starstrade.repository.dto.BrandDto;

@Repository
public class BrandsDaoImpl implements BrandsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<BrandDto> loadAll() {
		// セッションの取得
		Session session = sessionFactory.getCurrentSession();

		// クエリの取得
		Query<BrandDto> query = session.createNamedQuery(NamedQuery.Brand.loadAll, BrandDto.class);

		// クエリ実行
		return query.list();
	}
}
