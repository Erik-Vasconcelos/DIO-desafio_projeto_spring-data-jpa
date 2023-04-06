package me.one.digitalinnovation.dac.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Physical assessment model class
 * 
 * @author erikv
 * @since 04/04/2023
 */

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class PhysicalAssessment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate evaluationDate = LocalDate.now();

	@NonNull
	private Double weight;

	@NonNull
	private Double height;

	@ManyToOne
	private Student student;

}
