package com.github.q9029.aikatsustars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.q9029.aikatsustars.controller.constant.ControllerConst;

@Controller
@RequestMapping(value = ControllerConst.Uri.CALLBACK)
public class CallbackController {

    @RequestMapping(method = RequestMethod.GET)
    public String doGet() {
        return ControllerConst.View.INDEX;
    }
}
