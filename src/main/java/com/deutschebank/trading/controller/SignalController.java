/**
 * 
 */
package com.deutschebank.trading.controller;

import static com.deutschebank.trading.constants.SignalConstants.SUCCESS_RESPONSE;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deutschebank.trading.dto.SignalDto;
import com.deutschebank.trading.enums.Messages;
import com.deutschebank.trading.exception.ValidationException;
import com.deutschebank.trading.mapper.SignalBeanMapper;
import com.deutschebank.trading.service.SignalHandler;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * REST Controller for signal service
 * 
 * @author veluchamy.jeganathan
 *
 */
@RestController
@RequestMapping("/signals")
@Slf4j
@RequiredArgsConstructor
@Validated
public class SignalController {

	private final Map<String, SignalHandler> signalFactory;

	private final SignalBeanMapper signalBeanMapper;

	/**
	 * API provides functionality to process the trading signals
	 * 
	 * @param signalDto - input contains signal details
	 * @return - successful message
	 * @throws ValidationException - in case invalid signal is sent in the request
	 */
	@PostMapping
	public ResponseEntity<String> processSignals(@RequestBody @Valid SignalDto signalDto) throws ValidationException {
		Integer signal = signalDto.getSignal();
		log.info("Signal controller invoked with signal {}.", signal);

		SignalHandler signalHandler = this.signalFactory.get(signalBeanMapper.getSignal(signal));

		signalHandler.handleSignal(signal);
		
		log.info("Signal controller exit with success response.", signal);
		return new ResponseEntity<>(Messages.MESSAGE.getMessage(SUCCESS_RESPONSE), HttpStatus.CREATED);
	}

}
