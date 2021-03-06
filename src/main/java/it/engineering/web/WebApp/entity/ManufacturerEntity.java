package it.engineering.web.WebApp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;


/**
 * The persistent class for the manufacturer database table.
 * 
 */
@Entity
@NamedQuery(name="ManufacturerEntity.findAll", query="SELECT m FROM ManufacturerEntity m")
public class ManufacturerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="manufactortr_id")
	private String manufactortrId;

	@Column(name="tax_id")
	private String taxId;

	private String address;
	
	@ManyToOne (
			cascade = {CascadeType.MERGE,CascadeType.PERSIST}
			)
	@JoinColumn(name="zip_code")
	private CityEntity city;

	public ManufacturerEntity() {
	}
	
	public ManufacturerEntity(String manufactortrId, String taxId, String address, CityEntity city) {
		super();
		this.address = address;
		this.manufactortrId = manufactortrId;
		this.taxId = taxId;
		this.city = city;
	}

	public ManufacturerEntity(long id,  String manufactortrId, String taxId, String address, CityEntity city) {
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

	public String getManufactortrId() {
		return this.manufactortrId;
	}

	public void setManufactortrId(String manufactortrId) {
		this.manufactortrId = manufactortrId;
	}

	public String getTaxId() {
		return this.taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public CityEntity getCity() {
		return city;
	}

	public void setCity(CityEntity city) {
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
		ManufacturerEntity other = (ManufacturerEntity) obj;
		return Objects.equals(address, other.address) && Objects.equals(city, other.city) && id == other.id
				&& Objects.equals(manufactortrId, other.manufactortrId) && Objects.equals(taxId, other.taxId);
	}

	@Override
	public String toString() {
		return "Manufacturer [id=" + id + ", address=" + address + ", manufactortrId=" + manufactortrId + ", taxId="
				+ taxId + ", city=" + city + "]";
	}

	
}