package com.github.q9029.aikatsustars.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.q9029.aikatsustars.controller.constant.RequestURI;
import com.github.q9029.aikatsustars.repository.dto.CardDto;
import com.github.q9029.aikatsustars.service.CardsService;

import net.arnx.jsonic.JSON;

@RestController
@RequestMapping(value = RequestURI.CARD, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CardController {

	private static final Logger LOG = Logger.getLogger(CardController.class);

	@Autowired
	private CardsService cardsService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> doGet(@ModelAttribute Integer cardId) {

		CardDto cardDto = cardsService.getCard(cardId);

		Map<String, Object> cardInfoMap = new LinkedHashMap<>();
		cardInfoMap.put("no", cardDto.getNo());
		cardInfoMap.put("name", cardDto.getName());
		cardInfoMap.put("type", "クール");
		cardInfoMap.put("brand", "スパイスコード");
		cardInfoMap.put("rarerity", "SPR");
		cardInfoMap.put("volume", "星のツバサ1弾");
		cardInfoMap.put("img_url", cardDto.getUrl());

		String json = JSON.encode(cardInfoMap);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Connection", "close");
		return new ResponseEntity<>(json, headers, HttpStatus.OK);
	}

	@ExceptionHandler
	public ResponseEntity<String> handleException(Exception e) {

		LOG.error(e.getMessage(), e);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Connection", "close");
		headers.add("Content-Length", "0");
		return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
	}
}
