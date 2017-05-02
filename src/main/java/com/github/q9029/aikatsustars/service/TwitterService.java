package com.github.q9029.aikatsustars.service;

import twitter4j.TwitterException;
import twitter4j.auth.RequestToken;

public interface TwitterService {

    RequestToken getRequestToken() throws TwitterException;

    void registAccount(RequestToken requestToken, String verifier) throws TwitterException;

    void cleanAccounts();
}
