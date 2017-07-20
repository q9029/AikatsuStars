package com.github.q9029.aikatsustars.service.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.github.q9029.aikatsustars.repository.dto.SystemSettingDto;

public class SystemSettingsCachedData {

	private static final Logger LOG = Logger.getLogger(SystemSettingsCachedData.class);

	private static final Map<String, String> systemSettingMap = new HashMap<>();

	private SystemSettingsCachedData() {}

	public static String getCachedValue(String key) {
		return systemSettingMap.get(key);
	}

	public static void cache(List<SystemSettingDto> updatedList) {
		synchronized (systemSettingMap) {
			try {
				LOG.info("システム設定のリロードを開始します。");
				systemSettingMap.clear();
				for (SystemSettingDto dto : updatedList) {
					systemSettingMap.put(dto.getKey(), dto.getValue());
				}
				LOG.info("システム設定のリロードを終了しました。");
			} catch (Exception e) {
				throw new RuntimeException("システム設定のリロードに失敗しました。", e);
			}
		}
	}
}
