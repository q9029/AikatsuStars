package com.github.q9029.stars_trade.repository;

import java.io.Serializable;
import java.util.List;

import com.github.q9029.stars_trade.repository.dto.VolumeDto;

public interface VolumesDao {

	VolumeDto load(long id);

	Serializable save(VolumeDto account);

	void delete(VolumeDto account);

	List<VolumeDto> loadAll();
}
