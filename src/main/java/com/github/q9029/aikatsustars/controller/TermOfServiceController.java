package com.github.q9029.aikatsustars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.q9029.aikatsustars.controller.constant.RequestURI;
import com.github.q9029.aikatsustars.controller.constant.View;

/**
 * Service's terms of service.
 * @author q9029
 */
@Controller
@RequestMapping(value = RequestURI.TERMS)
public class TermOfServiceController {

    @RequestMapping(method = RequestMethod.GET)
    public String doGet() {
        return View.TERMS;
    }
}
