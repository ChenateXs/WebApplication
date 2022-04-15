package it.engineering.web.WebApp.domain;

import java.util.Objects;

public class Manufacturer {
	private long id;

	private String manufactortrId;

	private String taxId;
	
	private String address;

	private City city;

	public Manufacturer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manufacturer(String manufactortrId, String taxId, String address, City city) {
		super();
		this.address = address;
		this.manufactortrId = manufactortrId;
		this.taxId = taxId;
		this.city = city;
	}

	public Manufacturer(long id, String manufactortrId, String taxId, String address, City city) {
		super();
		this.id = id;
		this.address = address;
		this.manufactortrId = manufactortrId;
		this.taxId = taxId;
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getManufactortrId() {
		return manufactortrId;
	}

	public void setManufactortrId(String manufactortrId) {
		this.manufactortrId = manufactortrId;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		return Objects.hash(manufactortrId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manufacturer other = (Manufacturer) obj;
		return Objects.equals(manufactortrId, other.manufactortrId);
	}

	@Override
	public String toString() {
		return "Manufacturer [id=" + id + ", address=" + address + ", manufactortrId=" + manufactortrId + ", taxId="
				+ taxId + ", city=" + city + "]";
	}
	

}
