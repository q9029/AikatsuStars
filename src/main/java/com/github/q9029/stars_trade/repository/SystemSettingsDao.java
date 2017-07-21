package com.github.q9029.stars_trade.repository;

import java.util.List;

import com.github.q9029.stars_trade.repository.dto.SystemSettingDto;

public interface SystemSettingsDao {

	List<SystemSettingDto> loadAll();
}
