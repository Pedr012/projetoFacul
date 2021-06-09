 package br.com.usjt.collegeproject.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TB_PROFESSIONAL")
public class Professional extends Person {
	
	private String crm;

	@ManyToOne
	private Clinic clinic;
	

	public Professional() {

	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	@JsonBackReference
	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
}
