package me.one.digitalinnovation.dac.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.one.digitalinnovation.dac.dto.StudentDTO;
import me.one.digitalinnovation.dac.model.PhysicalAssessment;
import me.one.digitalinnovation.dac.model.Student;
import me.one.digitalinnovation.dac.service.interfaces.StudentService;

/**
 * Controller class for student
 * 
 * @author erikv
 * @since 04/04/2023
 */

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	private Student insert(@Valid @RequestBody StudentDTO studentDTO) {
		return studentService.insert(studentDTO);
	}
	
	@GetMapping("/{id}")
	public Student getStudent(@PathVariable Long id) {
		return studentService.get(id);
	}
	
	@GetMapping
	public List<Student> getAllStudent() {
		return studentService.getAll();
	}
	
	@GetMapping("/assessment")
	public List<PhysicalAssessment> getAllRegistrationPerNeighborhood(@RequestParam(name = "id", required = true) Long id) {
		return studentService.getAllPhysicalAssessments(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentService.delete(id);
	}
	
}
