package com.github.q9029.aikatsustars.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.q9029.aikatsustars.dto.Card;
import com.github.q9029.aikatsustars.repository.CardsDao;
import com.github.q9029.aikatsustars.service.CardsService;

@Service
public class CardsServiceImpl implements CardsService {

    @Autowired
    private CardsDao cardsDao;

    public List<Card> getAllCards() {
        return cardsDao.loadAll();
    }
}
