package br.com.usjt.collegeproject.service;

import br.com.usjt.collegeproject.model.entities.Professional;
import br.com.usjt.collegeproject.dao.ProfessionalDAO;

public class ProfessionalService {

	ProfessionalDAO dao = new ProfessionalDAO();
	
	public int criar(Professional professional) {
		return dao.criar(professional);
	}
	
	public void atualizar(Professional professional){
		dao.atualizar(professional);
	}
	
	public void excluir(Professional professional){
		dao.excluir(professional);
	}
	
	public Professional carregar(String crm){
		return dao.carregar(crm);
	}
	
}
