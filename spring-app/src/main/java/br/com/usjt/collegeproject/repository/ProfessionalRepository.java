package br.com.usjt.collegeproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.usjt.collegeproject.model.Professional;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Integer> {
	
	@Query("SELECT p FROM Professional p WHERE clinic_id = :id")
	public List<Optional<Professional>> getProfessionals(@Param("id") int id);
}
