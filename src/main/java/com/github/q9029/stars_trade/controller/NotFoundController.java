package com.github.q9029.stars_trade.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.github.q9029.stars_trade.controller.constant.RequestURI;
import com.github.q9029.stars_trade.controller.constant.View;

@Controller
@RequestMapping(value = RequestURI.NOTFOUND)
public class NotFoundController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet() {
		ModelAndView modelAndView = new ModelAndView(View.NOT_FOUND);
		modelAndView.setStatus(HttpStatus.NOT_FOUND);
		return modelAndView;
	}
}
