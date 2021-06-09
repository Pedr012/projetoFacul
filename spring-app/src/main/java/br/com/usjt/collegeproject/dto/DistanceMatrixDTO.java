package br.com.usjt.collegeproject.dto;

public class DistanceMatrixDTO {

	private int id;
	private String name;
	private String location;
	private String distance;
	private int value;
	
	public DistanceMatrixDTO() { }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "DistanceMatrixDTO [location=" + location + ", distance=" + distance + ", value=" + value + "]";
	}

	public int compareTo(DistanceMatrixDTO distance) {
		return this.getValue() - distance.getValue();
	}
}
