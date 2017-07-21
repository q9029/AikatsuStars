package com.github.q9029.stars_trade.repository;

import java.io.Serializable;
import java.util.List;

import com.github.q9029.stars_trade.repository.dto.VolumeCardDto;

public interface VolumeCardsDao {

	VolumeCardDto load(long id);

	Serializable save(VolumeCardDto account);

	void delete(VolumeCardDto account);

	List<VolumeCardDto> loadAll();
}
