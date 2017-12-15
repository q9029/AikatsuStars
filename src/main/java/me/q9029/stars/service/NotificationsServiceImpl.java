package me.q9029.stars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.q9029.stars.repository.NotificationsDao;
import me.q9029.stars.repository.model.NotificationEntity;

@Service
public class NotificationsServiceImpl implements NotificationsService {

	@Autowired
	private NotificationsDao dao;

	@Override
	public List<NotificationEntity> getList() {
		return dao.selectAll();
	}
}
