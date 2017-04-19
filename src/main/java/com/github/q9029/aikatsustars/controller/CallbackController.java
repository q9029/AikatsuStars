package com.github.q9029.aikatsustars.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.github.q9029.aikatsustars.controller.constant.RequestKey;
import com.github.q9029.aikatsustars.controller.constant.RequestURI;
import com.github.q9029.aikatsustars.controller.constant.SessionKey;
import com.github.q9029.aikatsustars.controller.constant.View;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

@Controller
@RequestMapping(value = RequestURI.CALLBACK)
public class CallbackController {

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(HttpServletRequest request, HttpServletResponse response) throws TwitterException {

        // セッションからTwitterのインスタンスを取得する。
        Twitter twitter = (Twitter) request.getSession().getAttribute(SessionKey.TWITTER);

        // セッションからリクエストトークンを取得する。
        RequestToken requestToken = (RequestToken) request.getSession()
                .getAttribute(SessionKey.TWITTER_REQUEST_TOKEN);

        // リクエストからOAuth認証結果を取得する。
        String verifier = request.getParameter(RequestKey.OAUTH_VERIFIER);

        // リクエストトークンとOAuth認証結果からアクセストークンを取得する。
        AccessToken accessToken = twitter.getOAuthAccessToken(requestToken, verifier);

        // こいつら暗号化してCookieにいれとく
        accessToken.getToken();
        accessToken.getTokenSecret();

        // セッションからリクエストトークンを削除する。
        request.getSession().removeAttribute(SessionKey.TWITTER_REQUEST_TOKEN);

        return "redirect:/";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleException() {
        return View.ERROR;
    }
}
