package es.soprasteria.formacion.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.soprasteria.formacion.dao.EjercicioRepository;
import es.soprasteria.formacion.dto.PersonaDTO;
import es.soprasteria.formacion.entity.PersonaEntity;

@Service
public class EjercicioServiceImpl implements EjercicioService{
	
	@Autowired
	private EjercicioRepository ejercicioRepository;

	@Override
	public PersonaDTO getByNif(String nif) {
	    PersonaEntity entity = ejercicioRepository.findById(nif).get();
	    PersonaDTO dto = new PersonaDTO(entity.getNif(), entity.getName() + entity.getSurname(),
	    		entity.getYear());
	    return dto;
	}
	@Override
	public List<PersonaDTO> getAllPersons() {
	    List<PersonaEntity> entities = ejercicioRepository.findAll();
	    List<PersonaDTO> personDtos = entities.stream()
	        .map(entity -> new PersonaDTO(entity.getNif(), entity.getName() + " " + entity.getSurname(),
		    		entity.getYear())).collect(Collectors.toList());    
	    return personDtos;
	}

	@Override
	public PersonaDTO createPerson(PersonaDTO newPerson) {
	    PersonaEntity personEntity = new PersonaEntity();
	    personEntity.setNif(newPerson.getNif());
	    Integer i = newPerson.getFullName().indexOf(" ");
	    personEntity.setName(newPerson.getFullName().substring(0,i));
	    personEntity.setSurname(newPerson.getFullName().substring(i+1,newPerson.getFullName().length()));
	    personEntity.setYear(newPerson.getYear());
	
	    PersonaEntity persistedEntity = ejercicioRepository.save(personEntity);
	
	    PersonaDTO personDto = new PersonaDTO(persistedEntity.getNif(), persistedEntity.getName() + " " +
	    		persistedEntity.getSurname(), persistedEntity.getYear());
	    return personDto;
	}
	
	@Override
	public PersonaDTO editPerson(PersonaDTO newPerson) {
		ejercicioRepository.deleteById(newPerson.getNif());
		PersonaDTO personDto = createPerson(newPerson);
	    return personDto;
	}
	
	@Override
	public void deleteByNif(String nif) {
		ejercicioRepository.deleteById(nif);
	}

}
