package com.github.q9029.starstrade.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.github.q9029.starstrade.controller.constant.RequestUri;
import com.github.q9029.starstrade.controller.constant.View;

@Controller
@RequestMapping(value = RequestUri.E404)
public class E404Controller {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet() {
		ModelAndView modelAndView = new ModelAndView(View.E404);
		modelAndView.setStatus(HttpStatus.NOT_FOUND);
		return modelAndView;
	}
}
