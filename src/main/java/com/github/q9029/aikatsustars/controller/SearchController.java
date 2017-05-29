package com.github.q9029.aikatsustars.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.q9029.aikatsustars.controller.constant.RequestURI;
import com.github.q9029.aikatsustars.controller.constant.View;

import twitter4j.TwitterException;

@Controller
@RequestMapping(value = RequestURI.SEARCH)
public class SearchController {

    /**
     * ロガー.
     */
    private static final Logger LOG = Logger.getLogger(SearchController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(HttpServletRequest request, HttpSession session) throws TwitterException {
        return View.SEARCH;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(HttpServletRequest request, HttpSession session) throws TwitterException {
        return "redirect:/search";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        LOG.error("System error.", e);
        return View.SEARCH;
    }
}
