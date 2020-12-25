package com.ok.shp.requests;

public class CreateUserRequest {

	private String firstName;
	private String lastName;
	private String sitePassword;
	private String email;
	private long phoneNumber;
	private String homeAddress;
	private long wallet;
	private boolean admin;

	public boolean getAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public long getWallet() {
		return wallet;
	}

	public void setWallet(long wallet) {
		this.wallet = wallet;
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

	public String getSitePassword() {
		return sitePassword;
	}

	public void setSitePassword(String sitePassword) {
		this.sitePassword = sitePassword;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

}
