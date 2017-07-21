package com.github.q9029.starstrade.service.cache;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.github.q9029.starstrade.repository.dto.TypeDto;

public class TypesCachedData {

	private static final Logger LOG = Logger.getLogger(TypesCachedData.class);

	private static Map<Integer, TypeDto> typeDtoList = new LinkedHashMap<>();;

	private TypesCachedData() {}

	public static TypeDto get(int id) {
		return typeDtoList.get(id);
	}

	public static List<TypeDto> getAll() {
		return new ArrayList<>(typeDtoList.values());
	}

	public static void cache(List<TypeDto> updatedList) {
		synchronized (typeDtoList) {
			try {
				LOG.info("タイプ設定のリロードを開始します。");
				typeDtoList.clear();
				for (TypeDto dto : updatedList) {
					typeDtoList.put(dto.getId(), dto);
				}
				LOG.info("タイプ設定のリロードを終了しました。");
			} catch (Exception e) {
				throw new RuntimeException("タイプ設定のリロードに失敗しました。", e);
			}
		}
	}
}
