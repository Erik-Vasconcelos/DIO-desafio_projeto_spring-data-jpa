package me.one.digitalinnovation.dac.service.interfaces;

import java.util.List;

import me.one.digitalinnovation.dac.dto.RegistrationDTO;
import me.one.digitalinnovation.dac.model.Registration;


/**
 * License plate services interface
 * 
 * @author erikv
 * @since 04/04/2023
 */
public interface RegistrationService extends CrudMethods<RegistrationDTO, Registration> {

	List<Registration> findByNeighborhood(String neighborhood);
}
