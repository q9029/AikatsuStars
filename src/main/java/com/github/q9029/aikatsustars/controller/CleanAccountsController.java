package com.github.q9029.aikatsustars.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.q9029.aikatsustars.controller.constant.ControllerConst;
import com.github.q9029.aikatsustars.service.TwitterService;

@RestController
@RequestMapping(value = ControllerConst.Uri.CLEAN_ACCOUNTS)
public class CleanAccountsController {

    private static final Logger LOG = Logger.getLogger(CleanAccountsController.class);

    @Autowired
    private TwitterService twitterService;

    @RequestMapping(method = RequestMethod.HEAD)
    public ResponseEntity<String> doHead() {
        // logic execute.
        twitterService.cleanAccounts();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Connection", "close");
        headers.add("Content-Length", "0");
        return new ResponseEntity<>(null, headers, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        LOG.error("", e);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Connection", "close");
        headers.add("Content-Length", "0");
        return new ResponseEntity<>(null, headers, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
