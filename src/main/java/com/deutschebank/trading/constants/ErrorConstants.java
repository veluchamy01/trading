/**
 * 
 */
package com.deutschebank.trading.constants;

/**
 * Contains Error related constants
 * 
 * @author veluchamy.jeganathan
 *
 */
public final class ErrorConstants {

	/**
	 * suppresses default constructor, ensuring non-instantiability.
	 */
	private ErrorConstants() {}

	/**
	 * Error codes to fetch error messages from messages.properties file
	 */
	public static final String ERR_001 = "ERR_001";

	/**
	 * Error messages
	 */
	public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
	public static final String INVALID_SIGNAL = "Invalid Signal";
	public static final String VALIDATION_FAILED = "Validation Failed";
	public static final String FAILED_TO_READ_REQUEST = "Failed to read request";

}
