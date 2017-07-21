package com.github.q9029.stars_trade.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.q9029.stars_trade.repository.SystemSettingsDao;
import com.github.q9029.stars_trade.service.SystemSettingsService;
import com.github.q9029.stars_trade.service.cache.SystemSettingsCachedData;

@Service
public class SystemSettingsServiceImpl implements SystemSettingsService {

	@Autowired
	private SystemSettingsDao systemSettingsDao;

	@Override
	public void cacheRepositoryData() {
		SystemSettingsCachedData.cache(systemSettingsDao.loadAll());
	}
}
