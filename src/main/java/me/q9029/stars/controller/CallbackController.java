package me.q9029.stars.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

@Controller
@RequestMapping("/callback")
public class CallbackController {

	public static final String OAUTH_VERIFIER = "oauth_verifier";

	public static final String ACCESS_TOKEN = "access_token";
	public static final String SCREEN_NAME = "screen_name";

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(WebRequest request, HttpSession session) {

		try {
			// 必要パラメータの取得
			String oauthVerifier = request.getParameter(OAUTH_VERIFIER);
			RequestToken requestToken = (RequestToken) request.getAttribute(
					SigninController.REQUEST_TOKEN, WebRequest.SCOPE_SESSION);

			// AccessTokenの取得
			Twitter twitter = new TwitterFactory().getInstance();
			AccessToken accessToken = twitter.getOAuthAccessToken(requestToken, oauthVerifier);

			request.setAttribute(ACCESS_TOKEN, accessToken, WebRequest.SCOPE_SESSION);
			request.setAttribute(SCREEN_NAME, accessToken.getScreenName(), WebRequest.SCOPE_SESSION);

		} catch (TwitterException e) {
			// セッション情報の削除
			if (session != null) {
				session.invalidate();
			}

			throw new ServiceException(HttpStatus.SERVICE_UNAVAILABLE, "アクセストークンの取得に失敗しました。");

		} finally {
			request.removeAttribute(SigninController.REQUEST_TOKEN, WebRequest.SCOPE_SESSION);
		}

		// TODO 作業ページに戻る
		return "redirect:/";
	}
}
