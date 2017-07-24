package com.github.q9029.starstrade.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.q9029.starstrade.controller.constant.RequestUri;

@RestController
@RequestMapping(value = RequestUri.Job.HEALTHCHECK)
public class JobHealthCheckController {

	private static final Logger LOG = Logger.getLogger(JobHealthCheckController.class);

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> doHead() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Connection", "close");
		headers.add("Content-Length", "0");
		return new ResponseEntity<>(null, headers, HttpStatus.OK);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		LOG.error(e.getMessage(), e);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Connection", "close");
		headers.add("Content-Length", "0");
		return new ResponseEntity<>(null, headers, HttpStatus.SERVICE_UNAVAILABLE);
	}
}
