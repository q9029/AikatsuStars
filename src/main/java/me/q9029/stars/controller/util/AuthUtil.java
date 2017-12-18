package me.q9029.stars.controller.util;

import org.springframework.web.context.request.WebRequest;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class AuthUtil {

	public static boolean isAuthenticated(WebRequest request) {

		// セッションから対象を取得
		Object accessToken = request.getAttribute("access_token", WebRequest.SCOPE_SESSION);

		// セッションの存在確認
		if (accessToken == null || !AccessToken.class.isInstance(accessToken)) {
			return false;
		}

		// AccessTokenの有効性確認
		try {
			Twitter twitter = new TwitterFactory().getInstance();
			twitter.setOAuthAccessToken((AccessToken) accessToken);
			twitter.verifyCredentials();
		} catch (Exception e) {
			return false;
		}

		return true;
	}
}
