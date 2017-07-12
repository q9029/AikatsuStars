package com.github.q9029.aikatsustars.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.q9029.aikatsustars.repository.SystemSettingsDao;
import com.github.q9029.aikatsustars.repository.constant.NamedQuery;
import com.github.q9029.aikatsustars.repository.dto.SystemSettingDto;

@Repository
public class SystemSettingsDaoImpl implements SystemSettingsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<SystemSettingDto> loadAll() {
		// セッションの取得
		Session session = sessionFactory.getCurrentSession();

		// クエリの取得
		Query<SystemSettingDto> query = session.createNamedQuery(NamedQuery.SystemSettings.loadAll, SystemSettingDto.class);

		// クエリ実行
		return query.list();
	}
}
