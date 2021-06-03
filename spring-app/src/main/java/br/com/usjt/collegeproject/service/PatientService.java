package br.com.usjt.collegeproject.service;

import br.com.usjt.collegeproject.model.entities.Patient;
import br.com.usjt.collegeproject.dao.PatientDAO;

public class PatientService {

	PatientDAO dao = new PatientDAO();
	
	public int criar(Patient paciente) {
		return dao.criar(paciente);
	}
	
	public void atualizar(Patient paciente){
		dao.atualizar(paciente);
	}
	
	public void excluir(Patient paciente){
		dao.excluir(paciente);
	}
	
	public Patient carregar(String cpf){
		return dao.carregar(cpf);
	}
	
}
