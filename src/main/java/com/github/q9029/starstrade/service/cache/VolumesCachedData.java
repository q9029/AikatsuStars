package com.github.q9029.starstrade.service.cache;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.github.q9029.starstrade.repository.dto.VolumeDto;

public class VolumesCachedData {

	private static final Logger LOG = Logger.getLogger(VolumesCachedData.class);

	private static Map<Integer, VolumeDto> volumeDtoList = new LinkedHashMap<>();

	private VolumesCachedData() {}

	public static VolumeDto get(int id) {
		return volumeDtoList.get(id);
	}

	public static List<VolumeDto> getAll() {
		// TODO 順番は担保されるか？
		return new ArrayList<>(volumeDtoList.values());
	}

	public static void cache(List<VolumeDto> updatedList) {
		synchronized (volumeDtoList) {
			try {
				LOG.info("弾設定のリロードを開始します。");
				volumeDtoList.clear();
				for (VolumeDto dto : updatedList) {
					volumeDtoList.put(dto.getId(), dto);
				}
				LOG.info("弾設定のリロードを終了しました。");
			} catch (Exception e) {
				throw new RuntimeException("弾設定のリロードに失敗しました。", e);
			}
		}
	}
}
