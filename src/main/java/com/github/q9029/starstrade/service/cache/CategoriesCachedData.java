package com.github.q9029.starstrade.service.cache;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.github.q9029.starstrade.repository.dto.CategoryDto;

public class CategoriesCachedData {

	private static final Logger LOG = Logger.getLogger(CategoriesCachedData.class);

	private static Map<Integer, CategoryDto> categoryDtoList = new LinkedHashMap<>();;

	private CategoriesCachedData() {}

	public static CategoryDto get(int id) {
		return categoryDtoList.get(id);
	}

	public static List<CategoryDto> getAll() {
		return new ArrayList<>(categoryDtoList.values());
	}

	public static void cache(List<CategoryDto> updatedList) {
		synchronized (categoryDtoList) {
			try {
				LOG.info("カテゴリ設定のリロードを開始します。");
				categoryDtoList.clear();
				for (CategoryDto dto : updatedList) {
					categoryDtoList.put(dto.getId(), dto);
				}
				LOG.info("カテゴリ設定のリロードを終了しました。");
			} catch (Exception e) {
				throw new RuntimeException("カテゴリ設定のリロードに失敗しました。", e);
			}
		}
	}
}
