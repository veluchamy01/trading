/**
 * 
 */
package com.deutschebank.trading.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deutschebank.trading.external.algo.Algo;
import com.deutschebank.trading.service.SignalHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * Service implementation layer for {@link SignalHandler}
 * 
 * @author veluchamy.jeganathan
 *
 */
@Service("signalOne")
@Slf4j
public class SignalOneImpl implements SignalHandler {

	@Autowired
	private Algo algo;

	@Override
	public void handleSignal(int signal) {
		log.debug("Inside handle signal implementation");
		this.algo.setUp();
		this.algo.setAlgoParam(1, 60);
		this.algo.performCalc();
		this.algo.submitToMarket();
		this.algo.doAlgo();
		log.debug("Exit handle signal implementation");
	}

}
