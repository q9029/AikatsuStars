package com.github.q9029.aikatsustars.service.cache;

import java.util.List;

import org.apache.log4j.Logger;

import com.github.q9029.aikatsustars.repository.dto.BrandDto;

public class BrandsCachedData {

	private static final Logger LOG = Logger.getLogger(BrandsCachedData.class);

	private static List<BrandDto> brandDtoList;

	private BrandsCachedData() {}

	public static List<BrandDto> getCachedList() {
		return brandDtoList;
	}

	public static void cache(List<BrandDto> updatedList) {
		synchronized (brandDtoList) {
			try {
				LOG.info("ブランド設定のリロードを開始します。");
				if (brandDtoList != null) {
					brandDtoList.clear();
				}
				brandDtoList = updatedList;
				LOG.info("ブランド設定のリロードを終了しました。");
			} catch (Exception e) {
				throw new RuntimeException("ブランド設定のリロードに失敗しました。", e);
			}
		}
	}
}
