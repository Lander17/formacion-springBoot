package es.soprasteria.formacion.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import es.soprasteria.formacion.dao.EjercicioRepository;
import es.soprasteria.formacion.dto.PersonaDTO;
import es.soprasteria.formacion.entity.PersonaEntity;

public class EjercicioServiceImpl implements EjercicioService{
	
	@Autowired
	private EjercicioRepository ejercicioRepository;

	@Override
	public PersonaDTO getByName(String name) {
	    PersonaEntity entity = ejercicioRepository.findById(name).get();
	    PersonaDTO dto = new PersonaDTO(entity.getName(), entity.getAge());
	    return dto;
	}
	@Override
	public List<PersonaDTO> getAllPersons() {
	    List<PersonaEntity> entities = ejercicioRepository.findAll();
	    List<PersonaDTO> personDtos = entities.stream()
	        .map(personaEntity -> new PersonaDTO(personaEntity.getName(), personaEntity.getAge()))
	        .collect(Collectors.toList());
	    return personDtos;
	}

	@Override
	public PersonaDTO createPerson(PersonaDTO newPerson) {
	    PersonaEntity personEntity = new PersonaEntity();
	    personEntity.setAge(newPerson.getAge());
	    personEntity.setName(newPerson.getName());
	
	    PersonaEntity persistedEntity = ejercicioRepository.save(personEntity);
	
	    PersonaDTO personDto = new PersonaDTO(persistedEntity.getName(), persistedEntity.getAge());
	    return personDto;
	}

}
