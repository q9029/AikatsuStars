package com.github.q9029.aikatsustars.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.github.q9029.aikatsustars.controller.constant.View;

@Component
public class GlobalExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception exception) {
        ModelAndView modelAndView = new ModelAndView(View.ERROR);
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        return modelAndView;
    }
}
