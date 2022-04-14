package it.engineering.web.WebApp.action.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;

	private String firstname;

	private String lastname;

	private String password;

	private String username;

	public User() {
	}
	
	
	
	public User(String password, String username, String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.username = username;
	}



	public User(BigInteger id, String password, String username, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.username = username;
	}



	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public BigInteger getId() {
		return this.id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}



	@Override
	public int hashCode() {
		return Objects.hash(password, username);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", password=" + password
				+ ", username=" + username + "]";
	}

	public User clone(){
		return new User(id,username, null,firstname,lastname);
	}
}