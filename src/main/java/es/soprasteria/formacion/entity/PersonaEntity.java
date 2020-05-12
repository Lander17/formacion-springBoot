package es.soprasteria.formacion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "persona")
public class PersonaEntity {

	  @Id
	  @Column(name = "name")
	  private String name;
	
	  @Column(name = "age")
	  private Integer age;
	
	  public String getName() {
		  return name;
	  }
	
	  public void setName(String name) {
		  this.name = name;
	  }
	
	  public Integer getAge() {
		  return age;
	  }
	
	  public void setAge(Integer age) {
		  this.age = age;
	  }
}