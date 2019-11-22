package com.ctiliescu.toeventsourcinglab.account.model;

import java.util.Objects;
import java.util.Optional;

public class User {

	private String id;

	private String email;

	private String password;

	private String firstName;

	private String secondName;

	private String country;

	private Optional<String> socialSecurityNumber;

	private Optional<String> cnp;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Optional<String> getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(Optional<String> socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public Optional<String> getCnp() {
		return cnp;
	}

	public void setCnp(Optional<String> cnp) {
		this.cnp = cnp;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof User))
			return false;
		User user = (User) o;
		return Objects.equals(id, user.id) && Objects.equals(email, user.email)
				&& Objects.equals(password, user.password)
				&& Objects.equals(firstName, user.firstName)
				&& Objects.equals(secondName, user.secondName)
				&& Objects.equals(country, user.country)
				&& Objects.equals(socialSecurityNumber, user.socialSecurityNumber)
				&& Objects.equals(cnp, user.cnp);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, email, password, firstName, secondName, country,
				socialSecurityNumber, cnp);
	}

}
