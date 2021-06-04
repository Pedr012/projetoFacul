package br.com.usjt.collegeproject.dto;

import br.com.usjt.collegeproject.model.Patient;

public class PatientDTO {
	
	private String name;
	private String birth;
	private int age;
	private String phone;
	private String email;
	private String cpf;
	private String address;
	private int number;
	
	public PatientDTO() { }
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public static PatientDTO toPatientDTO(Patient patient) {
		PatientDTO patientDTO = new PatientDTO();
		patientDTO.setName(patient.getName());
		patientDTO.setAge(patient.getAge());	
		patientDTO.setPhone(patient.getPhone());
		patientDTO.setEmail(patient.getEmail());
		patientDTO.setCpf(patient.getCpf());
		patientDTO.setAddress(patient.getAddress());
		patientDTO.setNumber(patient.getNumber());
		
		return patientDTO;
	}
}
