package com.github.q9029.aikatsustars.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.q9029.aikatsustars.controller.constant.ControllerConst;

import twitter4j.Twitter;

@Controller
@RequestMapping(value = ControllerConst.Uri.INDEX)
public class IndexController {

    private static final Logger LOG = Logger.getLogger(IndexController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(HttpSession session) {

        try {
            // OAuth有効性確認
            Twitter twitter = (Twitter) session.getAttribute(ControllerConst.Session.TWITTER);
            twitter.verifyCredentials();
            return ControllerConst.View.INDEX;

        } catch (Exception e) {
            LOG.error("Invalid session.", e);

            // セッションの破棄
            if (session != null) {
                session.invalidate();
            }

            return ControllerConst.View.INDEX_SIGNIN;
        }
    }
}
