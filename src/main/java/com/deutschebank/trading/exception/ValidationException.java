/**
 * 
 */
package com.deutschebank.trading.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Thrown by various accessor methods to indicate that the record being requested does not exist.
 * 
 * @author veluchamy.jeganathan
 *
 */
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ValidationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7084007452479453090L;

	/**
	 * Constructs a {@link ValidationException} with {@code null} as its error
	 * message string.
	 */
	public ValidationException() {
		super();
	}

	/**
	 * Constructs a {@link ValidationException}, saving a reference to the error
	 * message string {@code message} for later retrieval by the {@code getMessage}
	 * method.
	 *
	 * @param message the detail message.
	 */
	public ValidationException(String message) {
		super(message);
	}

}
