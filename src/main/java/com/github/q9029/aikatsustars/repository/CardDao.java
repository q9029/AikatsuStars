package com.github.q9029.aikatsustars.repository;

import java.util.List;

import com.github.q9029.aikatsustars.dto.Card;

public interface CardDao {

    List<Card> findAll();

    Card findById();
}
