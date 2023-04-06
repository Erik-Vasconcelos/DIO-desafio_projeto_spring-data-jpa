package me.one.digitalinnovation.dac.service.interfaces;

import java.util.List;

/**
 * Interface that declares the basic methods that every entity must have 
 * 
 * @author erikv
 * @since 04/04/2023
 */

public interface CrudMethods<T, E> {

	E insert(T dtoEntity);
	
	E get(Long id);
	
	List<E> getAll();
	
	E update(T dtoEntity);
	
	void delete(Long id);
}
