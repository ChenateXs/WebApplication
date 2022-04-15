package it.engineering.web.WebApp.domain;

import java.util.Objects;

public class City {
	private String zipCode;
	private String name;
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	public City(String zipCode, String name) {
		super();
		this.zipCode = zipCode;
		this.name = name;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(zipCode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return Objects.equals(zipCode, other.zipCode);
	}
	@Override
	public String toString() {
		return "City [zipCode=" + zipCode + ", name=" + name + "]";
	}
	
}
