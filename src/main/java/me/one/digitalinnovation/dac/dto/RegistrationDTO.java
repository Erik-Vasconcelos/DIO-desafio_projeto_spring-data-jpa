package me.one.digitalinnovation.dac.dto;

import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Registration data transfer class between layers
 * 
 * @author erikv
 * @since 04/04/2023
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDTO {
	
	private Long id;
	
	@Positive
	private Long studentId;
}
