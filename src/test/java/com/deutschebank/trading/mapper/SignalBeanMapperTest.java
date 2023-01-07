/**
 * 
 */
package com.deutschebank.trading.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.deutschebank.trading.exception.ValidationException;

/**
 * Tests for {@link SignalBeanMapper}
 * 
 * @author veluchamy.jeganathan
 *
 */
@ExtendWith(MockitoExtension.class)
class SignalBeanMapperTest {

	@InjectMocks
	private SignalBeanMapper signalBeanMapper;

	/**
	 * Test for success scenario of get signal
	 */
	@Test
	void test_getSignal_Success() {
		String result = signalBeanMapper.getSignal(1);
		assertEquals("signalOne", result);
	}
	
	/**
	 * Test for error scenario during get signal
	 */
	@Test
	void test_getSignal_ValidationException() {
		ValidationException thrown = assertThrows(ValidationException.class, () -> {
			signalBeanMapper.getSignal(99);
		});

		assertThat(thrown.getMessage()).contains("This signal cannot be processed at the moment.");
	}

}
