package com.github.q9029.aikatsustars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.q9029.aikatsustars.controller.constant.RequestURI;
import com.github.q9029.aikatsustars.controller.constant.View;

@Controller
@RequestMapping(value = RequestURI.PRIVACYPOLICY)
public class PrivacyPolicyController {

	@RequestMapping(method = RequestMethod.GET)
	public String doGet() {
		return View.PRIVACYPOLICY;
	}
}
