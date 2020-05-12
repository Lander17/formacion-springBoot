package es.soprasteria.formacion.dao;

import es.soprasteria.formacion.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EjercicioRepository extends JpaRepository<PersonaEntity, String>{

}
