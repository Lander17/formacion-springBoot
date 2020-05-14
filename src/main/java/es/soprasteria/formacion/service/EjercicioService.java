package es.soprasteria.formacion.service;

import java.util.List;

import es.soprasteria.formacion.dto.PersonaDTO;

public interface EjercicioService {
	
	PersonaDTO getByNif(String nif);
	
	List<PersonaDTO> getAllPersons();
	
	PersonaDTO createPerson(PersonaDTO newPersona);
	
	PersonaDTO editPerson(PersonaDTO newPersona);
	
	void deleteByNif(String nif);

}
