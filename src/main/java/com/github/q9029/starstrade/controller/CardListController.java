package com.github.q9029.starstrade.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.github.q9029.starstrade.controller.constant.RequestUri;
import com.github.q9029.starstrade.controller.constant.View;
import com.github.q9029.starstrade.repository.dto.CardDto;
import com.github.q9029.starstrade.service.CardsService;

import twitter4j.TwitterException;

@Controller
@RequestMapping(value = RequestUri.CARDLIST)
public class CardListController {

	@Autowired
	private CardsService cardsService;

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(WebRequest request, HttpSession session) throws TwitterException {

//		String name = request.getParameter("name");
//		String category = request.getParameter("category");
//		String brand = request.getParameter("brand");
//		String rareriry = request.getParameter("rareriry");

		String volume = request.getParameter("volume");
		if (StringUtils.isEmpty(volume)) {
			volume = "1";
		}

		List<CardDto> cardList = cardsService.getVolumeCards(Integer.parseInt(volume));
		request.setAttribute("cardlist", cardList, WebRequest.SCOPE_REQUEST);

		return View.CARD_LIST;
	}
}
