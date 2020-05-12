package es.soprasteria.formacion.service;

import java.util.List;

import es.soprasteria.formacion.dto.PersonaDTO;

public interface EjercicioService {
	
	PersonaDTO getByName(String name);
	
	List<PersonaDTO> getAllPersons();
	
	PersonaDTO createPerson(PersonaDTO newPersona);

}
