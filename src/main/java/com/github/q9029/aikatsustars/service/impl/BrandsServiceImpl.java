package com.github.q9029.aikatsustars.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.q9029.aikatsustars.repository.BrandsDao;
import com.github.q9029.aikatsustars.service.BrandsService;
import com.github.q9029.aikatsustars.service.cache.BrandsCachedData;

@Service
public class BrandsServiceImpl implements BrandsService {

	@Autowired
	private BrandsDao brandsDao;

	@Override
	public void cacheRepositoryData() {
		BrandsCachedData.cache(brandsDao.loadAll());
	}
}
