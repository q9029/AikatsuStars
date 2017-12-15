package me.q9029.stars.repository;

import java.util.List;

import me.q9029.stars.repository.model.NotificationEntity;

public interface NotificationsDao {

	List<NotificationEntity> selectAll();
}
