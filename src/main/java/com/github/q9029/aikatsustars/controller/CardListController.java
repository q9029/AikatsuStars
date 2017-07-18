package com.github.q9029.aikatsustars.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.q9029.aikatsustars.controller.constant.RequestURI;
import com.github.q9029.aikatsustars.controller.constant.View;
import com.github.q9029.aikatsustars.service.CardsService;

import twitter4j.TwitterException;

@Controller
@RequestMapping(value = RequestURI.CARDLIST)
public class CardListController {

	@Autowired
	private CardsService cardsService;

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(HttpServletRequest request, HttpSession session) throws TwitterException {
		String volume = request.getParameter("volume");
		volume = !StringUtils.isEmpty(volume) ? volume : "1";
		request.setAttribute("cardlist", cardsService.getAllCards());
		return View.CARDLIST;
	}
}
