package com.github.q9029.aikatsustars.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.q9029.aikatsustars.dao.AccountsDao;
import com.github.q9029.aikatsustars.dao.dto.Account;
import com.github.q9029.aikatsustars.service.TwitterService;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

@Service
public class TwitterServiceImpl implements TwitterService {

    @Autowired
    private AccountsDao accountsDao;

    @Override
    public void cleanAccounts() {

        List<Account> accountList = accountsDao.selectAll();

        if (accountList != null) {
            for (Account account : accountsDao.selectAll()) {

                // Twitterの新規インスタンスを取得する。
                Twitter twitter = new TwitterFactory().getInstance();

                AccessToken accessToken = new AccessToken(account.getAccessToken(), account.getAccessTokenSecret());
                twitter.setOAuthAccessToken(accessToken);

                try {
                    twitter.verifyCredentials();
                } catch (TwitterException e) {
                    // 無効フラグを立てる
                }
            }
        }
    }
}
