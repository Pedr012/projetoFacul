package br.com.usjt.collegeproject.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "TB_PROFESSIONAL")
public class Professional extends Person {
	
	@NotBlank(message = "O crm não deve ser vazio!")
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
