package br.com.usjt.collegeproject.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.usjt.collegeproject.dto.PatientDTO;
import br.com.usjt.collegeproject.model.Patient;
import br.com.usjt.collegeproject.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	public String createPatient(Patient patient) {
		boolean nullPatient = checkNullPatient(patient);
		if(!nullPatient) return "Campos obrigatórios não foram preenchidos!";
		
		boolean attributesPatient = checkPatientAttributes(patient);
		if(!attributesPatient) return "Algum campo foi preenchido incorretamente!"; 
		
		boolean alreadyExists = patientRepository.checkExist(patient.getCpf()).isPresent() ? true : false;
		if(alreadyExists) return "Esse cpf já está cadastrado!";
		
		if(nullPatient && attributesPatient && !alreadyExists) {
			patientRepository.save(patient);
		}
		return "Paciente cadastrado!";
	}
	
	public PatientDTO readPatientById(Integer id) {
		Optional<Patient> result = patientRepository.findById(id);
		if(result.isPresent()) {
			return PatientDTO.toPatientDTO(result.get());
		}
		return null;
	}
	
	private boolean checkNullPatient(Patient patient) {
		if(patient.getName() != null
				&& patient.getBirth() != null
				&& patient.getSex() != null
				&& patient.getPhone() != null
				&& patient.getEmail() != null
				&& patient.getCpf() != null
				&& patient.getAddress() != null
				&& patient.getNumber() != 0
				&& patient.getPassword() != null) {
			return true;
		}
		return false;
	}
	
	private boolean checkPatientAttributes(Patient patient) {
		String name;
		name = patient.getName();
		name = name.trim();
		name = name.replaceAll("[^A-Z | ^a-z]", "");
		name = name.replaceAll("\\s+", " ");
		
		String phone;
		phone = patient.getPhone();
		if(!phone.matches("\\((\\d{2})\\) (\\d{5})-(\\d{4})")) {
			phone = phone.trim();
			phone = phone.replaceAll("\\D", "");
			phone = phone.replaceAll("\\s", "");
			
			if(phone.length() == 11) {
				phone = phone.replaceAll("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3");
			}
		}
		
		String cpf;
		cpf = patient.getCpf();
		if(!cpf.matches("(\\d{3}).(\\d{3}).(\\d{3})-(\\d{2})")) {
			cpf = cpf.trim();
			cpf = cpf.replaceAll("\\D", "");
			cpf = cpf.replaceAll("\\s", "");
			
			if(cpf.length() == 11) {
				cpf = cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
			}
		}
				
		long differenceInMillies = new Date().getTime() - patient.getBirth().getTime();
		long differenceInDays = differenceInMillies / (1000L * 60L * 60L * 24L);
		int age = (int) Math.floor((differenceInDays - 5) / 365);
		
		if(name.length() >= 6
				&& age >= 18
				&& age <= 120
				&& phone.length() == 15
				&& patient.getEmail().length() > 10
				&& cpf.length() == 14
				&& patient.getAddress().length() > 5
				&& patient.getNumber() > 0
				&& patient.getPassword().length() >= 6) {
			patient.setName(name);
			patient.setAge(age);
			patient.setPhone(phone);
			patient.setCpf(cpf);
			patient.setDeleted(false);
					
			return true;
		}
		return false;
	}
}