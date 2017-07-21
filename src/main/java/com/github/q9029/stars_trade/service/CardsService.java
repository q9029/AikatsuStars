package com.github.q9029.stars_trade.service;

import java.util.List;

import com.github.q9029.stars_trade.repository.dto.CardDto;

public interface CardsService {

	List<CardDto> getAllCards();

	List<CardDto> getVolumeCards(int volumeId);

	List<CardDto> getCards(String keyword);

	CardDto getCard(Integer cardId);

}
