package com.ok.shp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users", schema = "public")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1, initialValue = 1)
	@Column(name = "user_id")
	private long userId;

	@Column(name = "first_name")
	String firstName;

	@Column(name = "last_name")
	String lastName;
	
	@Column(name="email")
	private String email;

	@Column(name = "phone_number")
	private long phoneNumber;

	@Column(name = "home_address")
	private String homeAddress;

	@Column(name = "site_password")
	private String sitePassword;

	@Column(name = "wallet")
	private Long wallet;

	@Column(name = "admin")
	private boolean admin;

	public boolean getAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Long getWallet() {
		return wallet;
	}

	public void setWallet(Long wallet) {
		this.wallet = wallet;
	}

	public long getUserId() {
		return userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public String getSitePassword() {
		return sitePassword;
	}

	public void setSitePassword(String sitePassword) {
		this.sitePassword = sitePassword;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

}
