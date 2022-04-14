package it.engineering.web.WebApp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;


/**
 * The persistent class for the manufacturer database table.
 * 
 */
@Entity
@NamedQuery(name="Manufacturer.findAll", query="SELECT m FROM Manufacturer m")
public class Manufacturer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String address;

	@Column(name="manufactortr_id")
	private BigInteger manufactortrId;

	@Column(name="tax_id")
	private BigInteger taxId;
	
	@ManyToOne (
			cascade = {CascadeType.MERGE,CascadeType.PERSIST}
			)
	@JoinColumn(name="zip_code")
	private City city;

	public Manufacturer() {
	}
	
	public Manufacturer(BigInteger manufactortrId, BigInteger taxId, String address, City city) {
		super();
		this.address = address;
		this.manufactortrId = manufactortrId;
		this.taxId = taxId;
		this.city = city;
	}

	public Manufacturer(long id, String address, BigInteger manufactortrId, BigInteger taxId, City city) {
		super();
		this.id = id;
		this.address = address;
		this.manufactortrId = manufactortrId;
		this.taxId = taxId;
		this.city = city;
	}


	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigInteger getManufactortrId() {
		return this.manufactortrId;
	}

	public void setManufactortrId(BigInteger manufactortrId) {
		this.manufactortrId = manufactortrId;
	}

	public BigInteger getTaxId() {
		return this.taxId;
	}

	public void setTaxId(BigInteger taxId) {
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
		return Objects.hash(address, city, id, manufactortrId, taxId);
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
		return Objects.equals(address, other.address) && Objects.equals(city, other.city) && id == other.id
				&& Objects.equals(manufactortrId, other.manufactortrId) && Objects.equals(taxId, other.taxId);
	}

	@Override
	public String toString() {
		return "Manufacturer [id=" + id + ", address=" + address + ", manufactortrId=" + manufactortrId + ", taxId="
				+ taxId + ", city=" + city + "]";
	}

	
}