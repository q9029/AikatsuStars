package com.github.q9029.aikatsustars.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.github.q9029.aikatsustars.controller.constant.RequestURI;
import com.github.q9029.aikatsustars.controller.constant.View;

@Controller
@RequestMapping(value = RequestURI.ERROR)
public class ErrorController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String doGet() {
        return View.ERROR;
    }
}
