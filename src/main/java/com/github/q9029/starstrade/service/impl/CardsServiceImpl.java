package com.github.q9029.starstrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.q9029.starstrade.repository.CardsDao;
import com.github.q9029.starstrade.repository.dto.CardDto;
import com.github.q9029.starstrade.service.CardsService;

@Service
public class CardsServiceImpl implements CardsService {

	@Autowired
	private CardsDao cardsDao;

	public List<CardDto> getAllCards() {
		return cardsDao.loadAll();
	}

	@Override
	public List<CardDto> getVolumeCards(int volumeId) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<CardDto> getCards(String keyword) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public CardDto getCard(Integer cardId) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
