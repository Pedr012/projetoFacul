package br.com.usjt.collegeproject.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_CLINIC")
public class Clinic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "O nome não deve ser vazio!")
	private String name;
	
	@NotBlank(message = "O endereço não deve ser vazio!")
	private String address;
	
	@Positive(message = "O número deve ser maior que 0!")
	private int number;
	
	@Size(min = 14, max = 14, message = "O cnpj é inválido!")
	private String cnpj;
	
	@ManyToMany
	private List<Patient> patients;
	
	@Transient
	private List<Professional> professionals;
	
	public Clinic() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public List<Professional> getProfessionals() {
		return professionals;
	}

	public void setProfessionals(List<Professional> professionals) {
		this.professionals = professionals;
	}
}
