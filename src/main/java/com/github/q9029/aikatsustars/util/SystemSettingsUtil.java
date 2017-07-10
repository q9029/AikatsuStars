package com.github.q9029.aikatsustars.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.github.q9029.aikatsustars.dto.SystemSetting;

public class SystemSettingsUtil {

	private static final Logger LOG = Logger.getLogger(SystemSettingsUtil.class);

	private static final Map<String, String> systemSettingsMap = new HashMap<>();

	private SystemSettingsUtil() {}

	public static String getValue(String key) {
		return systemSettingsMap.get(key);
	}

	public static void reload(List<SystemSetting> systemSettingList) {
		synchronized (systemSettingsMap) {
			try {
				LOG.info("システム設定のリロードを開始します。");
				systemSettingsMap.clear();
				for (SystemSetting systemSetting : systemSettingList) {
					systemSettingsMap.put(systemSetting.getKey(), systemSetting.getValue());
				}
				LOG.info("システム設定のリロードを終了しました。");
			} catch (Exception e) {
				throw new RuntimeException("システム設定のリロードに失敗しました。", e);
			}
		}
	}
}
