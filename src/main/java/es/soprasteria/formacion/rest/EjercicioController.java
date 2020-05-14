package es.soprasteria.formacion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.soprasteria.formacion.dto.PersonaDTO;
import es.soprasteria.formacion.service.EjercicioService;

@RestController
@RequestMapping("/api/v1/ejercicio")
public class EjercicioController {
	
	@Autowired
	private EjercicioService ejercicioService;
		
	@GetMapping("/list/{nif}")
	public PersonaDTO findPerson(@PathVariable(name="nif") String nif) {
	    return ejercicioService.getByNif(nif);
	}
	
	@GetMapping(value = "/list")
	public List<PersonaDTO> listPersons() {
		return ejercicioService.getAllPersons();
	}

	@PostMapping("/person")
	public PersonaDTO createPerson(@RequestBody PersonaDTO newPerson) {
		return ejercicioService.createPerson(newPerson);
	}
	
	@PutMapping("/edit")
	public PersonaDTO editPerson(@RequestBody PersonaDTO newPerson) {
		return ejercicioService.editPerson(newPerson);
	}
	
	@DeleteMapping("/delete/{nif}")
	public void deleteByNif(@PathVariable(name="nif") String nif) {
		ejercicioService.deleteByNif(nif);
	}

}
