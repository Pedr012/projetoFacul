package br.com.usjt.collegeproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.usjt.collegeproject.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	public Optional<Patient> findById(Integer id);
}
