package br.com.usjt.collegeproject.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PATIENT")
public class Patient extends Person {	
	
	@ManyToMany(mappedBy = "patients")
	private List<Clinic> clinics;

	public List<Clinic> getClinics() {
		return clinics;
	}

	public void setClinics(List<Clinic> clinics) {
		this.clinics = clinics;
	}

	@Override
	public String toString() {
		return "Patient [toString()=" + super.toString() + "]";
	}
}
