package br.com.usjt.collegeproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.usjt.collegeproject.model.Professional;
import br.com.usjt.collegeproject.repository.ProfessionalRepository;

@Service
public class ProfessionalService {

	@Autowired
	private ProfessionalRepository professionalRepository;
	
	public List<Optional<Professional>> getProfessionals(int id) {
		List<Optional<Professional>> professionals = professionalRepository.getProfessionals(id);		
		return professionals;
	}
}
