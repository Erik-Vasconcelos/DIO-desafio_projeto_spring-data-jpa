package me.one.digitalinnovation.dac.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.one.digitalinnovation.dac.dto.PhysicalAssessmentDTO;
import me.one.digitalinnovation.dac.model.PhysicalAssessment;
import me.one.digitalinnovation.dac.model.Student;
import me.one.digitalinnovation.dac.repository.PhysicalAssessmentRepository;
import me.one.digitalinnovation.dac.service.interfaces.PhysicalAssessmentService;
import me.one.digitalinnovation.dac.service.interfaces.StudentService;

/**
 * Physical Assessment services class
 * 
 * @author erikv
 * @since 04/04/2023
 */

@Service
public class PhysicalAssessmentImpl implements PhysicalAssessmentService {

	@Autowired
	private PhysicalAssessmentRepository physicalAssessmentRepository;

	@Autowired
	private StudentService studentService;

	@Override
	public PhysicalAssessment insert(PhysicalAssessmentDTO dtoEntity) {
		PhysicalAssessment assessment = convertoDtoToEntity(dtoEntity);
		Student student = studentService.get(dtoEntity.getStudentId());
		assessment.setStudent(student);

		physicalAssessmentRepository.save(assessment);
		return assessment;
	}

	@Override
	public PhysicalAssessment get(Long id) {
		Optional<PhysicalAssessment> optional = physicalAssessmentRepository.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new IllegalArgumentException("No Physical Assessement found with the given id");
		}
	}

	@Override
	public List<PhysicalAssessment> getAll() {
		return physicalAssessmentRepository.findAll();
	}

	@Override
	public PhysicalAssessment update(PhysicalAssessmentDTO dtoEntity) {
		PhysicalAssessment assessment = convertoDtoToEntity(dtoEntity);
		Student student = studentService.get(dtoEntity.getStudentId());
		student.setId(dtoEntity.getId());
		assessment.setStudent(student);

		physicalAssessmentRepository.save(assessment);

		return assessment;
	}

	@Override
	public void delete(Long id) {
		physicalAssessmentRepository.deleteById(id);
	}

	private PhysicalAssessment convertoDtoToEntity(PhysicalAssessmentDTO assessmentDTO) {
		PhysicalAssessment assessment = new PhysicalAssessment(assessmentDTO.getWeight(), assessmentDTO.getHeight());
		return assessment;
	}
}
