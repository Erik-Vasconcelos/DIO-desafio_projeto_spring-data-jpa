package me.one.digitalinnovation.dac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import me.one.digitalinnovation.dac.model.PhysicalAssessment;
import me.one.digitalinnovation.dac.model.Student;

/**
 * Student repository class
 * 
 * @author erikv
 * @since 04/04/2023
 */

@Repository
public interface StudentRespository extends JpaRepository<Student, Long> {

	void deleteById(Long idStudent);
	
	@Query("SELECT s.physicalAssessment FROM Student s where s.id = :idStudent")
	List<PhysicalAssessment> findAllPhysicalAssessment(Long idStudent);
}
