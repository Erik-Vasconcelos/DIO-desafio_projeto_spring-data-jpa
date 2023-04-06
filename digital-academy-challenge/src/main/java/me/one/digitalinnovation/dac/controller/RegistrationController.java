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

import me.one.digitalinnovation.dac.dto.RegistrationDTO;
import me.one.digitalinnovation.dac.model.Registration;
import me.one.digitalinnovation.dac.service.interfaces.RegistrationService;

/**
 * Registration controller class
 * 
 * @author erikv
 * @since 04/04/2023
 */

@RestController
@RequestMapping("/registration")
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
	private Registration insert(@Valid @RequestBody RegistrationDTO registrationDTO) {
		return registrationService.insert(registrationDTO);
	}

	@GetMapping("/{id}")
	public Registration getRegistration(@PathVariable Long id) {
		return registrationService.get(id);
	}

	@GetMapping
	public List<Registration> getAllRegistration() {
		return registrationService.getAll();
	}
	
	@GetMapping("/neighborhood")
	public List<Registration> getAllRegistrationPerNeighborhood(@RequestParam(name = "neighborhood", required = true) String neighborhood) {
		return registrationService.findByNeighborhood(neighborhood);
	}
	

	@DeleteMapping("/{id}")
	public void deleteRegistration(@PathVariable Long id) {
		registrationService.delete(id);
	}
}
