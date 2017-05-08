package com.github.q9029.aikatsustars.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.q9029.aikatsustars.dto.Account;
import com.github.q9029.aikatsustars.repository.AccountsDao;
import com.github.q9029.aikatsustars.service.TwitterService;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

@Service
public class TwitterServiceImpl implements TwitterService {

    @Autowired
    private AccountsDao accountsDao;

    @Override
    public RequestToken getRequestToken() throws TwitterException {
        // リクエストトークンを取得
        Twitter twitter = new TwitterFactory().getInstance();
        return twitter.getOAuthRequestToken();
    }

    @Override
    public AccessToken getAccessToken(RequestToken requestToken, String verifier) throws TwitterException {
        // アクセストークンを取得
        Twitter twitter = new TwitterFactory().getInstance();
        return twitter.getOAuthAccessToken(requestToken, verifier);
    }

    @Override
    public Account registAccount(RequestToken requestToken, String verifier) throws TwitterException {
        // Twitterインスタンスを取得
        Twitter twitter = new TwitterFactory().getInstance();

        // 登録情報の取得
        AccessToken accessToken = twitter.getOAuthAccessToken(requestToken, verifier);
        User user = twitter.verifyCredentials();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        // アカウントを新規作成
        Account account = new Account();
        account.setId(user.getId());
        account.setName(user.getName());
        account.setScreenName(user.getScreenName());
        account.setAccessToken(accessToken.getToken());
        account.setAccessTokenSecret(accessToken.getTokenSecret());
        account.setValid(true);
        account.setAdministrative(false);
        account.setCreatedAt(timestamp);
        account.setModifiedAt(timestamp);

        // アカウントの永続化
        accountsDao.save(account);

        return account;
    }

    @Override
    public User verify(Account account) throws TwitterException {
        // アクセストークンを生成
        AccessToken accessToken = new AccessToken(account.getAccessToken(), account.getAccessTokenSecret());

        // アクセストークンを設定
        Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthAccessToken(accessToken);

        // アクセストークンの有効性チェック
        return twitter.verifyCredentials();
    }
}
