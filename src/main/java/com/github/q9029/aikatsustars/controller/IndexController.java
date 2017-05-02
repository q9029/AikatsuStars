package com.github.q9029.aikatsustars.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.q9029.aikatsustars.controller.constant.RequestURI;
import com.github.q9029.aikatsustars.controller.constant.SessionKey;
import com.github.q9029.aikatsustars.controller.constant.View;

import twitter4j.Twitter;
import twitter4j.TwitterException;

@Controller
@RequestMapping(value = RequestURI.INDEX)
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(HttpSession session) {

        // Twitterインスタンスの取得
        Twitter twitter = (Twitter) session.getAttribute(SessionKey.TWITTER);

        // NULLでない場合
        if (twitter != null) {
            try {
                // OAuth有効性確認
                twitter.verifyCredentials();

            } catch (TwitterException e) {
                session.invalidate();
            }
        }
        // index.jspを返却
         return View.INDEX;
    }
}
