package br.com.usjt.collegeproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.usjt.collegeproject.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	public Optional<Patient> findById(Integer id);
	
	@Query("SELECT cpf FROM Patient WHERE cpf = :cpf")
	public Optional<String> checkExist(@Param("cpf") String cpf);
}
