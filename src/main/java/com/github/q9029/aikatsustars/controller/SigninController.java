package com.github.q9029.aikatsustars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.github.q9029.aikatsustars.controller.constant.RequestURI;
import com.github.q9029.aikatsustars.controller.constant.SessionKey;
import com.github.q9029.aikatsustars.service.TwitterService;

import twitter4j.TwitterException;
import twitter4j.auth.RequestToken;

@Controller
@RequestMapping(RequestURI.SIGNIN)
public class SigninController {

	@Autowired
	private TwitterService twitterService;

	/**
	 * <ul>
	 *  <li>リクエストトークンを取得</li>
	 *  <li>リクエストトークンをセッションに格納</li>
	 *  <li>リクエストトークン付のTwitter認証へリダイレクト</li>
	 * </ul>
	 * @param webRequest
	 * @return
	 * @throws TwitterException
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(WebRequest webRequest) throws TwitterException {

		// TODO Cookieからサインイン

		RequestToken requestToken = twitterService.getRequestToken();
		webRequest.setAttribute(SessionKey.REQUEST_TOKEN, requestToken, WebRequest.SCOPE_SESSION);
		return "redirect:" + requestToken.getAuthenticationURL();
	}
}
