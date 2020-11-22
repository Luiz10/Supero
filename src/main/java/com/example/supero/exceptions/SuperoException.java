package com.example.supero.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class SuperoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SuperoException(String msg) {
		super(msg);
	}

	public SuperoException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

}
