package com.github.q9029.aikatsustars.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.q9029.aikatsustars.controller.bean.SearchFormBean;
import com.github.q9029.aikatsustars.controller.constant.RequestKey;
import com.github.q9029.aikatsustars.controller.constant.RequestURI;
import com.github.q9029.aikatsustars.controller.constant.View;
import com.github.q9029.aikatsustars.service.SearchService;

import twitter4j.TwitterException;

@Controller
@RequestMapping(value = RequestURI.SEARCH)
public class SearchController {

	@Autowired
	private SearchService searchService;

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(HttpServletRequest request, HttpSession session, @ModelAttribute SearchFormBean formBean) throws TwitterException {

		String keyword = request.getParameter(RequestKey.Parameter.KEYWORD);
		String volume = request.getParameter(RequestKey.Parameter.VOLUME);
		String type = request.getParameter(RequestKey.Parameter.TYPE);
		String category = request.getParameter(RequestKey.Parameter.CATEGORY);
		String brand = request.getParameter(RequestKey.Parameter.BRAND);
		String raretiry = request.getParameter(RequestKey.Parameter.RARITY);

		request.setAttribute(RequestKey.Attribute.VOLUME_LIST, null);
		request.setAttribute(RequestKey.Attribute.TYPE_LIST, null);
		request.setAttribute(RequestKey.Attribute.CATEGORY_LIST, null);
		request.setAttribute(RequestKey.Attribute.BRAND_LIST, null);
		request.setAttribute(RequestKey.Attribute.RARITY_LIST, null);

		return View.SEARCH;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doPost(HttpServletRequest request, HttpSession session) throws TwitterException {
		return "redirect:/search";
	}
}
