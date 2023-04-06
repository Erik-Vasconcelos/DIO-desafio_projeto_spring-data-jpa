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
import org.springframework.web.bind.annotation.RestController;

import me.one.digitalinnovation.dac.dto.PhysicalAssessmentDTO;
import me.one.digitalinnovation.dac.model.PhysicalAssessment;
import me.one.digitalinnovation.dac.service.interfaces.PhysicalAssessmentService;

/**
 * PhysicalAssessment controller class
 * 
 * @author erikv
 * @since 04/04/2023
 */

@RestController
@RequestMapping("/assessment")
public class PhysicalAssessmentController {

	@Autowired
	private PhysicalAssessmentService assessmentService;
	
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
	public PhysicalAssessment insert(@Valid @RequestBody PhysicalAssessmentDTO assessmentDTO) {
		return assessmentService.insert(assessmentDTO);
	}
	
	@GetMapping("/{id}")
	public PhysicalAssessment getAssessment(@PathVariable Long id) {
		return assessmentService.get(id);
	}

	@GetMapping
	public List<PhysicalAssessment> getAllAssessment() {
		return assessmentService.getAll();
	}
	
	@DeleteMapping("/{id}")
	public void deleteAssessment(@PathVariable Long id) {
		assessmentService.delete(id);
	}
	
}
