package com.github.q9029.stars_trade.service;

import com.github.q9029.stars_trade.repository.dto.AccountDto;

import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public interface TwitterService {

	/**
	 * アカウントの有効性チェックを行う.
	 * @param account
	 */
	User verify(AccountDto account) throws TwitterException;

	/**
	 * リクエストトークンを取得する.
	 * @return
	 * @throws TwitterException
	 */
	RequestToken getRequestToken() throws TwitterException;

	/**
	 * アクセストークンを取得する.
	 * @param requestToken
	 * @param verifier
	 * @return
	 * @throws TwitterException
	 */
	AccessToken getAccessToken(RequestToken requestToken, String verifier) throws TwitterException;

	AccountDto registAccount(AccessToken accessToken) throws TwitterException;
}
