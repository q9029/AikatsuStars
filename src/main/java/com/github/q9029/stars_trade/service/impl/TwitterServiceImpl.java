package com.github.q9029.stars_trade.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.q9029.stars_trade.repository.AccountsDao;
import com.github.q9029.stars_trade.repository.dto.AccountDto;
import com.github.q9029.stars_trade.service.TwitterService;

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
	public AccountDto registAccount(AccessToken accessToken) throws TwitterException {
		// Twitterインスタンスを取得
		Twitter twitter = new TwitterFactory().getInstance();

		// 登録情報の取得
		twitter.setOAuthAccessToken(accessToken);
		User user = twitter.verifyCredentials();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		// アカウントを新規作成
		AccountDto account = new AccountDto();
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
	public User verify(AccountDto account) throws TwitterException {
		// アクセストークンを生成
		AccessToken accessToken = new AccessToken(account.getAccessToken(), account.getAccessTokenSecret());

		// アクセストークンを設定
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthAccessToken(accessToken);

		// アクセストークンの有効性チェック
		return twitter.verifyCredentials();
	}
}
