package br.com.usjt.collegeproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.usjt.collegeproject.dto.DistanceMatrixDTO;
import br.com.usjt.collegeproject.service.ClinicService;

@RestController
@CrossOrigin("*")
@RequestMapping("/clinics")
public class ClinicController {
	
	@Autowired
	private ClinicService clinicService;
	
	@GetMapping
	public ResponseEntity<List<DistanceMatrixDTO>> sortByDistance(
			@RequestParam(name = "address") String address) {
		List<DistanceMatrixDTO> sorted = clinicService.sortByDistance(address);
		return new ResponseEntity<List<DistanceMatrixDTO>>(sorted, HttpStatus.OK);
	}
}
