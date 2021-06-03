package br.com.usjt.collegeproject.service;

import br.com.usjt.collegeproject.model.entities.Clinic;
import br.com.usjt.collegeproject.dao.ClinicDAO;

public class ClinicService {

	ClinicDAO dao = new ClinicDAO();
		
		public int criar(Clinic clinica) {
			return dao.criar(clinica);
		}
		
		public void atualizar(Clinic clinica){
			dao.atualizar(clinica);
		}
		
		public void excluir(Clinic clinica){
			dao.excluir(clinica);
		}
		
		public Clinic carregar(String cnpj){
			return dao.carregar(cnpj);
		}
	
}
