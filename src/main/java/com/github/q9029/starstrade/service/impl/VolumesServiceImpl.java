package com.github.q9029.starstrade.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.q9029.starstrade.repository.VolumesDao;
import com.github.q9029.starstrade.service.VolumesService;
import com.github.q9029.starstrade.service.cache.VolumesCachedData;

@Service
public class VolumesServiceImpl implements VolumesService {

	@Autowired
	private VolumesDao volumesDao;

	@Override
	public void cacheRepositoryData() {
		VolumesCachedData.cache(volumesDao.loadAll());
	}
}
