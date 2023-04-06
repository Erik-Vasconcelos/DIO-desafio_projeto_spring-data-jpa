package me.one.digitalinnovation.dac.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Registration model class
 * 
 * @author erikv
 * @since 04/04/2023
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Registration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate registrationDate = LocalDate.now();

	@NonNull
	@JoinColumn(unique = true)
	@OneToOne(cascade = {CascadeType.ALL})
	private Student student;
}
