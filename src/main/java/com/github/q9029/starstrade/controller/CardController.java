package com.github.q9029.starstrade.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.github.q9029.starstrade.controller.constant.RequestKey;
import com.github.q9029.starstrade.controller.constant.RequestUri;
import com.github.q9029.starstrade.repository.dto.CardDto;
import com.github.q9029.starstrade.service.CardsService;

import net.arnx.jsonic.JSON;
import net.arnx.jsonic.JSONException;

@RestController
@RequestMapping(value = RequestUri.CARD, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CardController {

	private static final Logger LOG = Logger.getLogger(CardController.class);

	@Autowired
	private CardsService cardsService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> doGet(WebRequest request) {

		String cardId = request.getParameter(RequestKey.Parameter.CARD_ID);
		try {
			CardDto cardDto = cardsService.getCard(Integer.parseInt(cardId));

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

			ResponseEntity<String> response = new ResponseEntity<>(json, headers, HttpStatus.OK);
			return response;

		} catch (NumberFormatException | JSONException e) {
			throw new RuntimeException("カード取得で例外が発生しました。card_id=" + cardId, e);
		}
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
