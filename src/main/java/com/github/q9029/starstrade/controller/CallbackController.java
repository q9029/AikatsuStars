package com.github.q9029.starstrade.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.github.q9029.starstrade.controller.constant.RequestKey;
import com.github.q9029.starstrade.controller.constant.RequestURI;
import com.github.q9029.starstrade.controller.constant.SessionKey;
import com.github.q9029.starstrade.repository.dto.AccountDto;
import com.github.q9029.starstrade.service.AccountsService;
import com.github.q9029.starstrade.service.TwitterService;

import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

@Controller
@RequestMapping(RequestURI.CALLBACK)
public class CallbackController {

	@Autowired
	private TwitterService twitterService;

	@Autowired
	private AccountsService accountsService;

	/**
	 * <ul>
	 *  <li>oauth_verifierを取得</li>
	 *  <li>リクエストトークンをセッションから取得</li>
	 *  <li>アクセストークンを取得</li>
	 *  <li>アカウント情報を更新</li>
	 *  <li>アカウント情報をセッションに格納</li>
	 *  <li>リクエストトークンをセッションから削除</li>
	 * </ul>
	 * @param request
	 * @return
	 * @throws TwitterException
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(WebRequest request, HttpServletResponse response) throws TwitterException {
		try {
			String oauthVerifier = request.getParameter(RequestKey.Parameter.OAUTH_VERIFIER);
			RequestToken requestToken = (RequestToken) request.getAttribute(SessionKey.REQUEST_TOKEN, WebRequest.SCOPE_SESSION);

			AccessToken accessToken = twitterService.getAccessToken(requestToken, oauthVerifier);

			AccountDto account = accountsService.load(accessToken.getUserId());
			if (account == null) {
				account = twitterService.registAccount(accessToken);
			} else {
				try {
					twitterService.verify(account);
				} catch (TwitterException e) {
					account.setAccessToken(accessToken.getToken());
					account.setAccessTokenSecret(accessToken.getTokenSecret());
					accountsService.update(account);
				}
			}
			request.setAttribute(SessionKey.ACCOUNT, account, WebRequest.SCOPE_SESSION);

			// TODO アカウント情報をCookieに設定
			// Cookie cookie = new Cookie("account", account.getAccessToken());
			// cookie.setSecure(true);
			// cookie.setMaxAge(60 * 60 * 24 * 7);
			// cookie.setDomain(request.getContextPath());
			// response.addCookie(cookie);
		} finally {
			request.removeAttribute(SessionKey.REQUEST_TOKEN, WebRequest.SCOPE_SESSION);
		}
		return "redirect:/";
	}
}
