package com.github.q9029.aikatsustars.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.github.q9029.aikatsustars.controller.constant.RequestURI;
import com.github.q9029.aikatsustars.controller.constant.SessionKey;
import com.github.q9029.aikatsustars.controller.constant.View;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;

@Controller
@RequestMapping(value = RequestURI.SIGNIN)
public class SigninController {

    /**
     * ロガー.
     */
    private static final Logger LOG = Logger.getLogger(SigninController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(HttpServletRequest request, HttpSession session) throws TwitterException {

        // Twitterの新規インスタンスを取得する。
        Twitter twitter = new TwitterFactory().getInstance();

        // セッションにTwitterのインスタンスを登録する。
        request.getSession().setAttribute(SessionKey.TWITTER, twitter);

        // TwitterAPIからリクエストトークンを取得する。
        RequestToken requestToken = twitter.getOAuthRequestToken();

        // セッションにリクエストトークンを登録する。
        request.getSession().setAttribute(SessionKey.TWITTER_REQUEST_TOKEN, requestToken);

        // TwitterAPIのログインページにリダイレクトする。
        return "redirect:" + requestToken.getAuthenticationURL();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleException(Exception e) {
        LOG.error("System error.", e);
        return View.ERROR;
    }
}
