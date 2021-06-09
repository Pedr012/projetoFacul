package br.com.usjt.collegeproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.usjt.collegeproject.model.Clinic;

public interface ClinicRepository extends JpaRepository<Clinic, Integer> {

	public List<Clinic> findAll();
}
