package me.one.digitalinnovation.dac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import me.one.digitalinnovation.dac.model.Registration;

/**
 * Enrollment class repository 
 * 
 * @author erikv
 * @since 04/04/2023
 */
public interface RegistrationRepository extends JpaRepository<Registration, Long>{

	@Query("SELECT r FROM Registration r WHERE r.student.neighborhood = :neighborhood")
	List<Registration> findByNeighborhood(String neighborhood);
}
