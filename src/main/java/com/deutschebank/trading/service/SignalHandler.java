/**
 * 
 */
package com.deutschebank.trading.service;

/**
 * Service layer for handling the signals
 * 
 * @author veluchamy.jeganathan
 *
 */
public interface SignalHandler {

	/**
	 * service method for handling the signals
	 * 
	 * @param signal - input signal
	 */
	void handleSignal(int signal);

}
