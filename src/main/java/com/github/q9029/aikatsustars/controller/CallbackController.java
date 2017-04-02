package com.github.q9029.aikatsustars.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.github.q9029.aikatsustars.controller.constant.ControllerConst;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

@Controller
@RequestMapping(value = ControllerConst.Uri.CALLBACK)
public class CallbackController {

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(HttpServletRequest request, HttpServletResponse response) throws TwitterException {

        // セッションからTwitterのインスタンスを取得する。
        Twitter twitter = (Twitter) request.getSession().getAttribute(ControllerConst.Session.TWITTER);

        // セッションからリクエストトークンを取得する。
        RequestToken requestToken = (RequestToken) request.getSession()
                .getAttribute(ControllerConst.Session.TWITTER_REQUEST_TOKEN);

        // リクエストからOAuth認証結果を取得する。
        String verifier = request.getParameter(ControllerConst.Request.OAUTH_VERIFIER);

        // リクエストトークンとOAuth認証結果からアクセストークンを取得する。
        AccessToken accessToken = twitter.getOAuthAccessToken(requestToken, verifier);

        // こいつら暗号化してCookieにいれとく
        accessToken.getToken();
        accessToken.getTokenSecret();

        // セッションからリクエストトークンを削除する。
        request.getSession().removeAttribute(ControllerConst.Session.TWITTER_REQUEST_TOKEN);

        return "redirect:/";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleException() {
        return ControllerConst.View.ERROR;
    }
}
