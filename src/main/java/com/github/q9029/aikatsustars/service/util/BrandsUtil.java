package com.github.q9029.aikatsustars.service.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.github.q9029.aikatsustars.repository.dto.BrandDto;
import com.github.q9029.aikatsustars.service.bean.BrandBean;

public class BrandsUtil {

	private static final Logger LOG = Logger.getLogger(BrandsUtil.class);

	private static List<BrandBean> brandList;

	private BrandsUtil() {}

	public static List<BrandBean> getList() {
		return brandList;
	}

	public static void reload(List<BrandDto> brandDtoList) {
		synchronized (brandList) {
			try {
				LOG.info("ブランド設定のリロードを開始します。");
				brandList = new ArrayList<>();
				for (BrandDto brandDto : brandDtoList) {
					BrandBean brandBean = new BrandBean();
					brandBean.setValue(brandDto.getId());
					brandBean.setName(brandDto.getName());
					brandList.add(brandBean);
				}
				LOG.info("ブランド設定のリロードを終了しました。");
			} catch (Exception e) {
				throw new RuntimeException("ブランド設定のリロードに失敗しました。", e);
			}
		}
	}
}
