package com.github.q9029.aikatsustars.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.github.q9029.aikatsustars.service.TwitterService;

import twitter4j.TwitterException;
import twitter4j.auth.RequestToken;

@Controller
@RequestMapping(value = RequestURI.CALLBACK)
public class CallbackController {

    @Autowired
    private TwitterService twitterService;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(HttpServletRequest request, HttpSession session) {

        try {
            // セッションからリクエストトークンを取得する。
            RequestToken requestToken = (RequestToken) session.getAttribute(SessionKey.TWITTER_REQUEST_TOKEN);

            // リクエストからOAuth認証結果を取得する。
            String verifier = request.getParameter(RequestKey.OAUTH_VERIFIER);

            // リクエストトークンとOAuth認証結果からアクセストークンを取得する。
            twitterService.registAccount(requestToken, verifier);

        } catch (TwitterException e) {
            throw new RuntimeException(e);

        } finally {
            // セッションからリクエストトークンを削除する。
            session.removeAttribute(SessionKey.TWITTER_REQUEST_TOKEN);
        }
        return "redirect:/";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleException() {
        return View.ERROR;
    }
}
