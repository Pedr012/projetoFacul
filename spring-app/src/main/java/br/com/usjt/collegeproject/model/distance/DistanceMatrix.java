package br.com.usjt.collegeproject.model.distance;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class DistanceMatrix {

	private List<String> destination_addresses;
	private List<Rows> rows;
	
	public DistanceMatrix() { }

	public List<String> getDestination_addresses() {
		return destination_addresses;
	}

	public void setDestination_addresses(List<String> destination_addresses) {
		this.destination_addresses = destination_addresses;
	}

	public List<Rows> getRows() {
		return rows;
	}

	public void setRows(List<Rows> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "DistanceMatrix [destination_addresses=" + destination_addresses + ", rows=" + rows + "]";
	}
}
