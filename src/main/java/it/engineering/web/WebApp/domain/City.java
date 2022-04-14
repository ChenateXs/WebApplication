package it.engineering.web.WebApp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;


/**
 * The persistent class for the city database table.
 * 
 */
@Entity
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	@Id
	@Column(name="zip_code")
	private BigInteger zipCode;

	public City() {
	}

	public City(BigInteger zipCode, String name) {
		super();
		this.name = name;
		this.zipCode = zipCode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigInteger getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(BigInteger zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, zipCode);
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
		return Objects.equals(name, other.name) && Objects.equals(zipCode, other.zipCode);
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", zipCode=" + zipCode + "]";
	}
}