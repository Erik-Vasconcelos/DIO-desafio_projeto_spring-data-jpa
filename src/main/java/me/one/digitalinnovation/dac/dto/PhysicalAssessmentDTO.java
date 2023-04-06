package me.one.digitalinnovation.dac.dto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Physical Assessment data transfer class between layers
 * 
 * @author erikv
 * @since 04/04/2023
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhysicalAssessmentDTO {
	
	private Long id;
	
	@DecimalMin(value = "10.00", message = "The weight '${validatedValue}' is below the minimum value: {value}")
	@DecimalMax(value = "300.00", message = "The weight '${validatedValue}' is above the maximum value: {value}")
	private Double weight;

	@DecimalMin(value = "50.0", message = "The weight '${validatedValue}' is below the minimum value: {value}")
	@DecimalMax(value = "300.0", message = "The height '${validatedValue}' is above the maximum value: {value}")
	private Double height;

	private Long studentId;
}
