package br.com.usjt.collegeproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.usjt.collegeproject.dto.DistanceMatrixDTO;
import br.com.usjt.collegeproject.model.Clinic;
import br.com.usjt.collegeproject.model.distance.Distance;
import br.com.usjt.collegeproject.model.distance.DistanceMatrix;
import br.com.usjt.collegeproject.repository.ClinicRepository;

@Service
public class ClinicService {
	
	@Autowired
	private ClinicRepository clinicRepository;
	
	public List<DistanceMatrixDTO> sortByDistance(String address) {
		List<Clinic> clinics = clinicRepository.findAll();
		
		final String API_KEY = "AIzaSyCB1O_Ld0F7d_Pl5aGNq1Q-9ZpNuolTTps";
		
		List<String> addresses = new ArrayList<String>();
		if(clinics != null) {
			for(Clinic clinic: clinics) {
				addresses.add(clinic.getAddress() + ", " + clinic.getNumber());
			}
		}
		
		String formatedAddresses = addresses.stream()
				.map(elem -> elem.replaceAll(" ", "+"))
				.collect(Collectors.joining("|"));
		
		WebClient webClient = WebClient.create("https://maps.googleapis.com/maps/api/distancematrix/json");
		DistanceMatrix matrix = webClient.get()
				.uri("?origins=" + address + "&destinations=" + formatedAddresses + "&language=pt-BR&key=" + API_KEY)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(DistanceMatrix.class)
				.block();
		
		List<String> googleAddresses = matrix.getDestination_addresses();
		List<Distance> googleDistances = matrix.getRows().get(0).getElements().stream().map(elem -> elem.getDistance()).toList();
		
		List<DistanceMatrixDTO> listMatrixDTO = new ArrayList<DistanceMatrixDTO>(); 
		for(int i = 0; i < googleAddresses.size(); i++) {
			DistanceMatrixDTO matrixDTO = new DistanceMatrixDTO();
			matrixDTO.setName(clinics.get(i).getName().toUpperCase());
			matrixDTO.setLocation(googleAddresses.get(i));
			matrixDTO.setDistance(googleDistances.get(i).getText());
			matrixDTO.setValue(googleDistances.get(i).getValue());
			
			listMatrixDTO.add(matrixDTO);
		}
		
		listMatrixDTO = listMatrixDTO.stream().sorted((v1, v2) -> v1.compareTo(v2)).toList();
		
		return listMatrixDTO;
	}
}
