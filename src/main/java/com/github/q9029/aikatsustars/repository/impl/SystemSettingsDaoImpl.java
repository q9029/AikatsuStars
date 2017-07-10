package com.github.q9029.aikatsustars.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.q9029.aikatsustars.dto.SystemSetting;
import com.github.q9029.aikatsustars.repository.SystemSettingsDao;
import com.github.q9029.aikatsustars.repository.constant.NamedQuery;

@Repository
public class SystemSettingsDaoImpl implements SystemSettingsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SystemSetting load(long id) {
		// セッションの取得
		Session session = sessionFactory.getCurrentSession();

		// クエリ実行
		return session.get(SystemSetting.class, id);
	}

	@Override
	public SystemSetting load(String key) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<SystemSetting> loadAll() {
		// セッションの取得
		Session session = sessionFactory.getCurrentSession();

		// クエリの取得
		Query<SystemSetting> query = session.createNamedQuery(NamedQuery.SystemSetting.loadAll, SystemSetting.class);

		// クエリ実行
		return query.list();
	}
}
