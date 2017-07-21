package com.github.q9029.starstrade.repository;

import java.util.List;

import com.github.q9029.starstrade.repository.dto.SystemSettingDto;

public interface SystemSettingsDao {

	List<SystemSettingDto> loadAll();
}
