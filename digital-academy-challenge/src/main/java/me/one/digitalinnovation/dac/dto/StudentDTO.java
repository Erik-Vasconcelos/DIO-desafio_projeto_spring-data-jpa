package me.one.digitalinnovation.dac.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Student data transfer class between layers
 * 
 * @author erikv
 * @since 04/04/2023
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

	private Long id;
	
	@NotBlank(message = "The name field is required!")
	@Size(min = 3, max = 50, message = "The name '${validatedValue}' is invalid. The value must be between {min} and {max}")
	private String name;

	@NotBlank(message = "The cpf field is required!")
	@CPF(message = "The cpf: '${validatedValue}' is invalid")
	private String cpf;

	@NotBlank(message = "The neighborhood field is required!")
	private String neighborhood;

	@Past(message = "Date of birth cannot be in the present or future")
	private LocalDate birthDate;
	
}
