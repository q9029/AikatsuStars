package me.q9029.stars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;

@Controller
@RequestMapping("/signin")
public class SigninController {

	public static final String REQUEST_TOKEN = "request_token";

	/**
	 * <ul>
	 *  <li>リクエストトークンを取得</li>
	 *  <li>リクエストトークンをセッションに格納</li>
	 *  <li>リクエストトークン付のTwitter認証へリダイレクト</li>
	 * </ul>
	 * @param request
	 * @return
	 * @throws TwitterException
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(WebRequest request) throws TwitterException {

		// TODO Cookieからサインイン

		// リクエストトークンを取得
		Twitter twitter = new TwitterFactory().getInstance();
		RequestToken requestToken = twitter.getOAuthRequestToken();
		request.setAttribute("request_token", requestToken, WebRequest.SCOPE_SESSION);
		return "redirect:" + requestToken.getAuthenticationURL();
	}
}
