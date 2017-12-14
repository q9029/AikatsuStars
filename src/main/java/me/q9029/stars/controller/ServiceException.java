package me.q9029.stars.controller;

import org.springframework.http.HttpStatus;

/**
 * 既知例外.
 * @author Queue
 */
public class ServiceException extends RuntimeException {

	private HttpStatus status;

	public ServiceException(HttpStatus status, Exception ex) {
		super(ex);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}
}
