package me.q9029.stars.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.q9029.stars.repository.model.NotificationEntity;

@Repository
public class NotificationsDaoImpl implements NotificationsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<NotificationEntity> selectAll() {

		// セッションの取得
		Session session = sessionFactory.getCurrentSession();

		// クエリの取得
		Query<NotificationEntity> query = session.createNamedQuery("NotificationsDao.selectAll", NotificationEntity.class);

		// クエリ実行
		return query.list();
	}
}
