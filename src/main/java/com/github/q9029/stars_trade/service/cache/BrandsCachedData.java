package com.github.q9029.stars_trade.service.cache;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.github.q9029.stars_trade.repository.dto.BrandDto;

public class BrandsCachedData {

	private static final Logger LOG = Logger.getLogger(BrandsCachedData.class);

	private static Map<Integer, BrandDto> brandDtoList = new LinkedHashMap<>();;

	private BrandsCachedData() {}

	public static BrandDto get(int id) {
		return brandDtoList.get(id);
	}

	public static List<BrandDto> getAll() {
		return new ArrayList<>(brandDtoList.values());
	}

	public static void cache(List<BrandDto> updatedList) {
		synchronized (brandDtoList) {
			try {
				LOG.info("ブランド設定のリロードを開始します。");
				brandDtoList.clear();
				for (BrandDto dto : updatedList) {
					brandDtoList.put(dto.getId(), dto);
				}
				LOG.info("ブランド設定のリロードを終了しました。");
			} catch (Exception e) {
				throw new RuntimeException("ブランド設定のリロードに失敗しました。", e);
			}
		}
	}
}
