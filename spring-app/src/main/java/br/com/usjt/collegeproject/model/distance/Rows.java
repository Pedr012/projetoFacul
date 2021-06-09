package br.com.usjt.collegeproject.model.distance;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Rows {

	private List<Elements> elements;
	
	public Rows() { }

	public List<Elements> getElements() {
		return elements;
	}

	public void setElements(List<Elements> elements) {
		this.elements = elements;
	}

	@Override
	public String toString() {
		return "Rows [elements=" + elements + "]";
	}
}
