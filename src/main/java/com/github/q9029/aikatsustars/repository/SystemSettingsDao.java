package com.github.q9029.aikatsustars.repository;

import java.util.List;

import com.github.q9029.aikatsustars.dto.SystemSetting;

public interface SystemSettingsDao {

	SystemSetting load(long id);

	SystemSetting load(String key);

	List<SystemSetting> loadAll();
}
