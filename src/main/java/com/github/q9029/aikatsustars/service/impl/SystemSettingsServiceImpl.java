package com.github.q9029.aikatsustars.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.q9029.aikatsustars.repository.SystemSettingsDao;
import com.github.q9029.aikatsustars.service.SystemSettingsService;
import com.github.q9029.aikatsustars.util.SystemSettingsUtil;

@Service
public class SystemSettingsServiceImpl implements SystemSettingsService {

	@Autowired
	private SystemSettingsDao systemSettingsDao;

	@Override
	public void reload() {
		SystemSettingsUtil.reload(systemSettingsDao.loadAll());
	}
}
