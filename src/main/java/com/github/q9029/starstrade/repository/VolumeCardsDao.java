package com.github.q9029.starstrade.repository;

import java.io.Serializable;
import java.util.List;

import com.github.q9029.starstrade.repository.dto.VolumeCardDto;

public interface VolumeCardsDao {

	VolumeCardDto load(long id);

	Serializable save(VolumeCardDto account);

	void delete(VolumeCardDto account);

	List<VolumeCardDto> loadAll();
}
