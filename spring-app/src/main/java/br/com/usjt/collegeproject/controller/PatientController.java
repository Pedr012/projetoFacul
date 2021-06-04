package br.com.usjt.collegeproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.usjt.collegeproject.dto.PatientDTO;
import br.com.usjt.collegeproject.model.Patient;
import br.com.usjt.collegeproject.service.PatientService;


@RestController
@CrossOrigin("*")
@RequestMapping("/patients")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping
	public ResponseEntity<PatientDTO> readPatientById(
			@RequestParam(name = "id") Integer id) {
		PatientDTO result = patientService.readPatientById(id);
		
		HttpStatus code = result != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST;	
		return new ResponseEntity<PatientDTO>(result, code);
	}
	
	@PostMapping
	public ResponseEntity<String> createPatient(@RequestBody Patient patient) {
		String result = patientService.createPatient(patient);
		
		HttpStatus code = result.equals("Paciente cadastrado!") ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
		return new ResponseEntity<String>(result, code);
	}
}
