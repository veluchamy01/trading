package com.deutschebank.trading;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.deutschebank.trading.controller.SignalController;
import com.deutschebank.trading.dto.SignalDto;
import com.deutschebank.trading.exception.ValidationException;

import jakarta.validation.ConstraintViolationException;

/**
 * Tests from the controller layer
 * 
 * @author veluchamy.jeganathan
 *
 */
@SpringBootTest
class ApplicationTests {

	@Autowired
	private SignalController signalController;

	/**
	 * Test to check if application loads correctly
	 */
	@Test
	void contextLoads() {
		assertThat(signalController).isNotNull();
	}

	/**
	 * Test for successful scenario of processing trading signal
	 */
	@Test
	void test_processSignals_Success() {
		SignalDto signalDto = new SignalDto();
		signalDto.setSignal(1);

		ResponseEntity<String> result = signalController.processSignals(signalDto);

		Assertions.assertThat(result.getBody()).contains("Signal sent for processing");
		Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
	}

	/**
	 * Test for error scenario while processing trading signal
	 */
	@Test
	void test_processSignals_ValidationException() {
		SignalDto signalDto = new SignalDto();
		signalDto.setSignal(99);

		ValidationException thrown = assertThrows(ValidationException.class, () -> {
			signalController.processSignals(signalDto);
		});

		assertThat(thrown.getMessage()).contains("This signal cannot be processed at the moment.");
	}

	/**
	 * Test for error scenario while processing trading signal
	 */
	@Test
	void test_processSignals_ConstraintViolationException() {
		SignalDto signalDto = new SignalDto();

		ConstraintViolationException thrown = assertThrows(ConstraintViolationException.class, () -> {
			signalController.processSignals(signalDto);
		});

		assertThat(thrown.getMessage()).contains("should not be empty");
	}
}
