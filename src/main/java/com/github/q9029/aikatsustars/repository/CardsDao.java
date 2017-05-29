package com.github.q9029.aikatsustars.repository;

import java.io.Serializable;
import java.util.List;

import com.github.q9029.aikatsustars.dto.Card;

public interface CardsDao {

    Card load(long id);

    Serializable save(Card account);

    void delete(Card account);

    List<Card> loadAll();
}
