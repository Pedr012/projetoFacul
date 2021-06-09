package br.com.usjt.collegeproject.model;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Embeddable
@Table(name = "TB_PATIENT")
public class Patient extends Person {	
	
	@OneToMany(mappedBy = "patient")
	private List<Consult> consultAssociation;
	
	public Patient() { }

	public List<Consult> getConsultAssociation() {
		return consultAssociation;
	}

	public void setConsultAssociation(List<Consult> consultAssociation) {
		this.consultAssociation = consultAssociation;
	}
}
