package me.one.digitalinnovation.dac.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Student model class
 * 
 * @author erikv
 * @since 04/04/2023
 */

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private String name;
	
	@NonNull
	@Column(unique = true)
	private String cpf;
	
	@NonNull
	private String neighborhood;
	
	@NonNull
	private LocalDate birthDate;

	@JsonIgnore
	@OneToMany(mappedBy = "student", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	private List<PhysicalAssessment> physicalAssessment = new ArrayList<>();

}
