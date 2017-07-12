package com.github.q9029.aikatsustars.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.q9029.aikatsustars.controller.constant.RequestURI;
import com.github.q9029.aikatsustars.controller.constant.SessionKey;
import com.github.q9029.aikatsustars.service.TwitterService;

import twitter4j.TwitterException;
import twitter4j.auth.RequestToken;

@Controller
@RequestMapping(value = RequestURI.SIGNIN)
public class SigninController {

	@Autowired
	private TwitterService twitterService;

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(HttpServletRequest request, HttpSession session) throws TwitterException {

		// TwitterAPIからリクエストトークンを取得する。
		RequestToken requestToken = twitterService.getRequestToken();

		// セッションにリクエストトークンを登録する。
		session.setAttribute(SessionKey.REQUEST_TOKEN, requestToken);

		// TwitterAPIのログインページにリダイレクトする。
		return "redirect:" + requestToken.getAuthenticationURL();
	}
}
