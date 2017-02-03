package com.github.q9029.aikatsustars.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.github.q9029.aikatsustars.controller.constant.ControllerConst;

@Controller
@RequestMapping(value = ControllerConst.Uri.CALLBACK)
public class CallbackController {

    @RequestMapping(method = RequestMethod.GET)
    public String doGet() {
        return ControllerConst.View.INDEX;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleException() {
        return ControllerConst.View.ERROR;
    }
}
