package com.github.q9029.aikatsustars.service.cache;

import java.util.List;

import org.apache.log4j.Logger;

import com.github.q9029.aikatsustars.repository.dto.VolumeDto;

public class VolumesCachedData {

	private static final Logger LOG = Logger.getLogger(VolumesCachedData.class);

	private static List<VolumeDto> volumeDtoList;

	private VolumesCachedData() {}

	public static List<VolumeDto> getCachedList() {
		return volumeDtoList;
	}

	public static void cache(List<VolumeDto> updatedList) {
		synchronized (volumeDtoList) {
			try {
				LOG.info("弾設定のリロードを開始します。");
				if (volumeDtoList != null) {
					volumeDtoList.clear();
				}
				volumeDtoList = updatedList;
				LOG.info("弾設定のリロードを終了しました。");
			} catch (Exception e) {
				throw new RuntimeException("弾設定のリロードに失敗しました。", e);
			}
		}
	}
}
