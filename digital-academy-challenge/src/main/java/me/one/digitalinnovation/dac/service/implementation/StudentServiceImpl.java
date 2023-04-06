package me.one.digitalinnovation.dac.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.one.digitalinnovation.dac.dto.StudentDTO;
import me.one.digitalinnovation.dac.model.PhysicalAssessment;
import me.one.digitalinnovation.dac.model.Student;
import me.one.digitalinnovation.dac.repository.StudentRespository;
import me.one.digitalinnovation.dac.service.interfaces.StudentService;

/**
 * Student services class
 * 
 * @author erikv
 * @since 04/04/2023
 */

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRespository studentRespository;

	@Override
	public Student insert(StudentDTO dtoEntity) {
		Student student = convertDtoToEntity(dtoEntity);
		studentRespository.save(student);
		
		return student;
	}

	@Override
	public Student get(Long id) {
		Optional<Student> student = studentRespository.findById(id);
		
		if(student.isPresent()) {
			return student.get();
		}else {
			throw new IllegalArgumentException("No student found with the given id");
		}
	}

	@Override
	public List<Student> getAll() {
		List<Student> students = studentRespository.findAll();
		
		return students;
	}

	@Override
	public Student update(StudentDTO dtoEntity) {
		Student student = convertDtoToEntity(dtoEntity);
		student.setId(dtoEntity.getId());
		studentRespository.save(student);
		
		return student;
	}

	@Override
	public void delete(Long id) {
		studentRespository.deleteById(id);
	}

	@Override
	public List<PhysicalAssessment> getAllPhysicalAssessments(Long idStudent) {
		return studentRespository.findAllPhysicalAssessment(idStudent);
	}
	
	private Student convertDtoToEntity(StudentDTO dtoEntity) {
		Student student = new Student();
		student.setName(dtoEntity.getName());
		student.setCpf(dtoEntity.getCpf());
		student.setNeighborhood(dtoEntity.getNeighborhood());
		student.setBirthDate(dtoEntity.getBirthDate());
		
		return student;
	}

}
