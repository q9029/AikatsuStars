package com.github.q9029.stars_trade.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.q9029.stars_trade.repository.BrandsDao;
import com.github.q9029.stars_trade.service.BrandsService;
import com.github.q9029.stars_trade.service.cache.BrandsCachedData;

@Service
public class BrandsServiceImpl implements BrandsService {

	@Autowired
	private BrandsDao brandsDao;

	@Override
	public void cacheRepositoryData() {
		BrandsCachedData.cache(brandsDao.loadAll());
	}
}
