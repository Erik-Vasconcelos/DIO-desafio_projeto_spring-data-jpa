package me.one.digitalinnovation.dac.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.one.digitalinnovation.dac.dto.RegistrationDTO;
import me.one.digitalinnovation.dac.model.Registration;
import me.one.digitalinnovation.dac.model.Student;
import me.one.digitalinnovation.dac.repository.RegistrationRepository;
import me.one.digitalinnovation.dac.service.interfaces.RegistrationService;
import me.one.digitalinnovation.dac.service.interfaces.StudentService;

/**
 * Registration services class
 * 
 * @author erikv
 * @since 04/04/2023
 */

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;

	@Autowired
	private StudentService studentService;

	@Override
	public Registration insert(RegistrationDTO dtoEntity) {
		Registration registration = convertDtoToEntity(dtoEntity);
		Student student = studentService.get(dtoEntity.getStudentId());
		registration.setStudent(student);
		registrationRepository.save(registration);

		return registration;
	}

	@Override
	public Registration get(Long id) {
		Optional<Registration> reOptional = registrationRepository.findById(id);

		if (reOptional.isPresent()) {
			return reOptional.get();
		} else {
			throw new IllegalArgumentException("No registration found with the given id");
		}
	}

	@Override
	public List<Registration> getAll() {
		return registrationRepository.findAll();
	}

	@Override
	public List<Registration> findByNeighborhood(String neighborhood) {
		return registrationRepository.findByNeighborhood(neighborhood);
	}

	@Override
	public Registration update(RegistrationDTO dtoEntity) {
		Registration registration = convertDtoToEntity(dtoEntity);
		registration.setId(dtoEntity.getId());
		registrationRepository.save(registration);

		return registration;
	}

	@Override
	public void delete(Long id) {
		registrationRepository.deleteById(id);
	}

	private Registration convertDtoToEntity(RegistrationDTO dtoEntity) {
		Registration registration = new Registration();
		Student student = studentService.get(dtoEntity.getStudentId());
		registration.setStudent(student);

		return registration;
	}

}
