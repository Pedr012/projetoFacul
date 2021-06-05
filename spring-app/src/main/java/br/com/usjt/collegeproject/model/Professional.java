package br.com.usjt.collegeproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PROFESSIONAL")
public class Professional extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
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

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
}
