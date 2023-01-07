/**
 * 
 */
package com.deutschebank.trading.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * DTO class has parameters for handling signals
 * 
 * @author veluchamy.jeganathan
 *
 */
@Data
public class SignalDto {

	@NotNull(message = "should not be empty")
	private Integer signal;

}
