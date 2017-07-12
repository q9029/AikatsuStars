package com.github.q9029.aikatsustars.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.q9029.aikatsustars.controller.constant.RequestKey;
import com.github.q9029.aikatsustars.controller.constant.RequestURI;
import com.github.q9029.aikatsustars.controller.constant.SessionKey;
import com.github.q9029.aikatsustars.dto.AccountDto;
import com.github.q9029.aikatsustars.service.AccountsService;
import com.github.q9029.aikatsustars.service.TwitterService;

import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

@Controller
@RequestMapping(value = RequestURI.CALLBACK)
public class CallbackController {

	@Autowired
	private TwitterService twitterService;

	@Autowired
	private AccountsService accountsService;

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(HttpServletRequest request, HttpSession session) throws TwitterException {

		try {
			// セッションからリクエストトークンを取得
			RequestToken requestToken = (RequestToken) session.getAttribute(SessionKey.REQUEST_TOKEN);

			// リクエストからOAuth認証結果を取得
			String verifier = request.getParameter(RequestKey.OAUTH_VERIFIER);

			// アクセストークンを取得
			AccessToken accessToken = twitterService.getAccessToken(requestToken, verifier);

			AccountDto account = accountsService.load(accessToken.getUserId());

			if (account == null) {
				// リクエストトークンとOAuth認証結果からアクセストークンを取得する。
				account = twitterService.registAccount(accessToken);
			} else {
				try {
					// アカウントの有効性チェック
					twitterService.verify(account);
				} catch (TwitterException e) {
					account.setAccessToken(accessToken.getToken());
					account.setAccessTokenSecret(accessToken.getTokenSecret());
					accountsService.update(account);
				}
			}

			session.setAttribute(SessionKey.ACCOUNT, account);

		} finally {
			// セッションからリクエストトークンを削除する。
			session.removeAttribute(SessionKey.REQUEST_TOKEN);
		}
		return "redirect:/";
	}
}
