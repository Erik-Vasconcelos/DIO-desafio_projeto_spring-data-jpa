package me.one.digitalinnovation.dac.service.interfaces;

import java.util.List;

/**
 * Student services interface 
 * 
 * @author erikv
 * @since 04/04/2023
 */

import me.one.digitalinnovation.dac.dto.StudentDTO;
import me.one.digitalinnovation.dac.model.PhysicalAssessment;
import me.one.digitalinnovation.dac.model.Student;

public interface StudentService extends CrudMethods<StudentDTO, Student> {

	List<PhysicalAssessment> getAllPhysicalAssessments(Long idStudent);

}
