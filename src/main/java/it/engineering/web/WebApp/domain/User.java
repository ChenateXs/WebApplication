package it.engineering.web.WebApp.domain;

import java.util.Objects;

public class User {
	private long id;

	private String username;

	private String password;

	private String firstname;

	private String lastname;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.username = username;
	}

	public User(long id, String username, String password, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.username = username;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public int hashCode() {
		return Objects.hash(username);
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
		return Objects.equals(username, other.username);
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
