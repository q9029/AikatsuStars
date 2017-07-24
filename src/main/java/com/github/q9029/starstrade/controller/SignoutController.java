package com.github.q9029.starstrade.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.q9029.starstrade.controller.constant.RequestUri;

@Controller
@RequestMapping(value = RequestUri.SIGNOUT)
public class SignoutController {

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
		return "redirect:" + RequestUri.INDEX;
	}
}
