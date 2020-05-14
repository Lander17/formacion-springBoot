package es.soprasteria.formacion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "persona")
public class PersonaEntity {
	
	@Id
	@Column(name = "nif")
	private String nif;
  
    @Column(name = "name")
    private String name;
  
    @Column(name = "surname")
    private String surname;

    @Column(name = "year")
    private Integer year;

	public String getNif() {
		return nif;
	}
	
	public void setNif(String nif) {
		this.nif = nif;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public Integer getYear() {
		return year;
	}
	
	public void setYear(Integer year) {
		this.year = year;
	}
	
}