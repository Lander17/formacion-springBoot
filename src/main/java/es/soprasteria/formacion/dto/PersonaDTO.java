package es.soprasteria.formacion.dto;

public class PersonaDTO {

	private String nif;
	private String fullName;
	private Integer year;

	public PersonaDTO(String nif, String fullName, Integer year) {
		this.nif = nif;
		this.fullName = fullName;
		this.year = year;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

}
