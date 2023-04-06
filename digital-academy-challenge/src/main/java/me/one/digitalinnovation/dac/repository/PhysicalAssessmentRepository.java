package me.one.digitalinnovation.dac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.one.digitalinnovation.dac.model.PhysicalAssessment;

/**
 * Physical assessment class repository
 * 
 * @author erikv
 * @since 04/04/2023
 */

public interface PhysicalAssessmentRepository extends JpaRepository<PhysicalAssessment, Long> {

}
