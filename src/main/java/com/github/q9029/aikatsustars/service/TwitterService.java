package com.github.q9029.aikatsustars.service;

import com.github.q9029.aikatsustars.dto.Account;

import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public interface TwitterService {

    /**
     * アカウントの有効性チェックを行う.
     * @param account
     */
    User verify(Account account) throws TwitterException;

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

    Account registAccount(AccessToken accessToken) throws TwitterException;
}
