/**
 * 
 */
package com.deutschebank.trading.mapper;

import static com.deutschebank.trading.constants.ErrorConstants.ERR_001;
import static com.deutschebank.trading.constants.SignalConstants.SIGNAL_ONE;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.deutschebank.trading.enums.Messages;
import com.deutschebank.trading.exception.ValidationException;

import lombok.extern.slf4j.Slf4j;

/**
 * SignalBeanMapper maps all the supported signal types with their corresponding
 * bean value
 * 
 * @author veluchamy.jeganathan
 *
 */
@Component
@Slf4j
public class SignalBeanMapper {

	private final Map<Integer, String> signalMapper;

	/**
	 * Maps all the supported signal with their corresponding bean value
	 */
	public SignalBeanMapper() {
		signalMapper = new HashMap<>();
		signalMapper.put(1, SIGNAL_ONE);
	}

	/**
	 * Retrieves the bean value of the sent signal
	 * 
	 * @param key - input signal from request
	 * @return - bean value
	 * @throws ValidationException - in case the sent input signal is not supported
	 */
	public String getSignal(Integer key) throws ValidationException {
		if (!this.signalMapper.containsKey(key)) {
			log.error("Received signal Type : {}. {}", key, Messages.MESSAGE.getMessage(ERR_001));
			throw new ValidationException(Messages.MESSAGE.getMessage(ERR_001));
		}
		log.debug("Bean value of the requested signal type : {} is {}.", key, this.signalMapper.get(key));
		return this.signalMapper.get(key);
	}

}
