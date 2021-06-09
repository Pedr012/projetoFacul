package br.com.usjt.collegeproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.usjt.collegeproject.model.Professional;
import br.com.usjt.collegeproject.service.ProfessionalService;

@RestController
@CrossOrigin("*")
@RequestMapping("/professionals")
public class ProfessionalController {

	@Autowired
	private ProfessionalService professionalService;
	
	@GetMapping
	public ResponseEntity<List<Professional>> getProfessionals(
			@RequestParam(name = "clinic_id") int id) {
		List<Optional<Professional>> optionalProfessionals = professionalService.getProfessionals(id);
		List<Professional> professionals = new ArrayList<Professional>();
		for(Optional<Professional> professional: optionalProfessionals) {
			if(professional.isPresent()) professionals.add(professional.get());
		}
		
		HttpStatus code = professionals.size() > 0 ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
		
		return new ResponseEntity<List<Professional>>(professionals, code);
	}
	
}
