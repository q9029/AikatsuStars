package com.github.q9029.aikatsustars.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.q9029.aikatsustars.controller.constant.RequestURI;
import com.github.q9029.aikatsustars.controller.constant.SessionKey;
import com.github.q9029.aikatsustars.controller.constant.View;

import twitter4j.Twitter;

@Controller
@RequestMapping(value = RequestURI.INDEX)
public class IndexController {

    private static final Logger LOG = Logger.getLogger(IndexController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(HttpSession session) {

        try {
            // OAuth有効性確認
            Twitter twitter = (Twitter) session.getAttribute(SessionKey.TWITTER);
            twitter.verifyCredentials();
            return View.INDEX;

        } catch (Exception e) {
            LOG.error("Invalid session.", e);

            // セッションの破棄
            if (session != null) {
                session.invalidate();
            }

            return View.INDEX_SIGNIN;
        }
    }
}
