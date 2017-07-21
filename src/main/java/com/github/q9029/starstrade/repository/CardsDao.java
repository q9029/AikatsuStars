package com.github.q9029.starstrade.repository;

import java.io.Serializable;
import java.util.List;

import com.github.q9029.starstrade.repository.dto.CardDto;

public interface CardsDao {

	CardDto load(long id);

	Serializable save(CardDto account);

	void delete(CardDto account);

	List<CardDto> loadAll();
}
