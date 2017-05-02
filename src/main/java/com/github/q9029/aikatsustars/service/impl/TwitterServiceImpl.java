package com.github.q9029.aikatsustars.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.q9029.aikatsustars.dto.Account;
import com.github.q9029.aikatsustars.repository.AccountsDao;
import com.github.q9029.aikatsustars.service.TwitterService;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

@Service
public class TwitterServiceImpl implements TwitterService {

    @Autowired
    private AccountsDao accountsDao;

    @Override
    public RequestToken getRequestToken() throws TwitterException {
        // Twitterの新規インスタンスを取得する。
        Twitter twitter = new TwitterFactory().getInstance();

        // TwitterAPIからリクエストトークンを取得する。
        return twitter.getOAuthRequestToken();
    }

    @Override
    public void registAccount(RequestToken requestToken, String verifier) throws TwitterException {
        // Twitterインスタンスを取得
        Twitter twitter = new TwitterFactory().getInstance();

        // アクセストークンを取得
        AccessToken accessToken = twitter.getOAuthAccessToken(requestToken, verifier);

        // アカウントを新規作成
        Account account = new Account();
        account.setId(twitter.getId());
//        account.setName(accessToken.getUserId());
        account.setScreenName(accessToken.getScreenName());
        account.setAccessToken(accessToken.getToken());
        account.setAccessTokenSecret(accessToken.getTokenSecret());

        // アカウントの永続化
        accountsDao.save(account);
    }

    @Override
    public void cleanAccounts() {

        // アカウント全件取得
        List<Account> accountList = accountsDao.loadAll();

        // 取得したアカウント件数ループ
        for (Account account : accountList) {

            // Twitterインスタンスを取得
            Twitter twitter = new TwitterFactory().getInstance();

            // アクセストークンを設定
            AccessToken accessToken = new AccessToken(account.getAccessToken(), account.getAccessTokenSecret());
            twitter.setOAuthAccessToken(accessToken);

            // 有効フラグを初期化
            boolean isValid = true;

            try {
                // アクセストークンの有効性チェック
                twitter.verifyCredentials();

            } catch (TwitterException e) {
                // 有効フラグに無効を設定
                isValid = false;
            }

            // 有効フラグを設定
            account.setValid(isValid);
        }
    }
}
