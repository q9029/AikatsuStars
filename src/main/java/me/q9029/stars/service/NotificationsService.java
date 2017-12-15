package me.q9029.stars.service;

import java.util.List;

import me.q9029.stars.repository.model.NotificationEntity;

public interface NotificationsService {

	List<NotificationEntity> getList();
}
