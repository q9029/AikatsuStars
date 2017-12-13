package com.github.q9029.starstrade;

import org.springframework.http.HttpStatus;

public class ServiceException extends RuntimeException {

	private HttpStatus status;

	public ServiceException(HttpStatus status) {
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}
}
