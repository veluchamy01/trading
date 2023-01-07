/**
 * 
 */
package com.deutschebank.trading.constants;

/**
 * Contains Trading Signal related constants
 * 
 * @author veluchamy.jeganathan
 *
 */
public final class SignalConstants {

	/**
	 * suppresses default constructor, ensuring non-instantiability.
	 */
	private SignalConstants() {
	}

	/**
	 * supported signal types
	 */
	public static final String SIGNAL_ONE = "signalOne";
	public static final String SIGNAL_TWO = "signalTwo";

	/**
	 * message constants
	 */
	public static final String MESSAGE = "messages";
	
	/**
	 * constants to fetch messages from the messages.properties file
	 */
	public static final String SUCCESS_RESPONSE = "SUCCESS_RESPONSE";

}
