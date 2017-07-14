package com.github.q9029.aikatsustars.service.util;

import java.util.List;

import org.apache.log4j.Logger;

import com.github.q9029.aikatsustars.repository.dto.BrandDto;

public class BrandsUtil {

	private static final Logger LOG = Logger.getLogger(BrandsUtil.class);

	private static List<BrandDto> brandDtoList;

	private BrandsUtil() {}

	public static List<BrandDto> getList() {
		return brandDtoList;
	}

	public static void reload(List<BrandDto> updatedList) {
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
