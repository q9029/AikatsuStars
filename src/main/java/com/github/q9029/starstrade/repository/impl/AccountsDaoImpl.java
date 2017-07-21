package com.github.q9029.starstrade.repository.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.q9029.starstrade.repository.AccountsDao;
import com.github.q9029.starstrade.repository.constant.NamedQuery;
import com.github.q9029.starstrade.repository.dto.AccountDto;

@Repository
public class AccountsDaoImpl implements AccountsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public AccountDto load(long id) {
		// セッションの取得
		Session session = sessionFactory.getCurrentSession();

		// クエリ実行
		return session.get(AccountDto.class, id);
	}

	@Override
	public Serializable save(AccountDto account) {
		// セッションの取得
		Session session = sessionFactory.getCurrentSession();

		// クエリ実行
		return session.save(account);
	}

	@Override
	public void update(AccountDto account) {
		// セッションの取得
		Session session = sessionFactory.getCurrentSession();

		// クエリ実行
		session.update(account);
	}

	@Override
	public void delete(AccountDto account) {
		// セッションの取得
		Session session = sessionFactory.getCurrentSession();

		// クエリ実行
		session.delete(account);
	}

	@Override
	public List<AccountDto> loadAll() {
		// セッションの取得
		Session session = sessionFactory.getCurrentSession();

		// クエリの取得
		Query<AccountDto> query = session.createNamedQuery(NamedQuery.Account.loadAll, AccountDto.class);

		// クエリ実行
		return query.list();
	}
}
