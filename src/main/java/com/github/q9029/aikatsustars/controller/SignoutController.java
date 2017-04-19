package com.github.q9029.aikatsustars.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.q9029.aikatsustars.controller.constant.RequestURI;

@Controller
@RequestMapping(value = RequestURI.SIGNOUT)
public class SignoutController {

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(HttpServletRequest request, HttpSession session) {

        // セッション情報の破棄
        session.invalidate();

        // indexにリダイレクト
        return "redirect:/";
    }
}
