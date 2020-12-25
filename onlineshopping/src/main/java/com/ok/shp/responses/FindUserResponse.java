package com.ok.shp.responses;

public class FindUserResponse {

	private String name;
	private String lastName;
	private String email;
	private long phoneNumber;
	private String homeAddress;
	private String sitePassword;
	private long wallet;
	private boolean admin;
	private boolean success;
	private String message;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getSitePassword() {
		return sitePassword;
	}

	public void setSitePassword(String sitePassword) {
		this.sitePassword = sitePassword;
	}

	public long getWallet() {
		return wallet;
	}

	public void setWallet(long wallet) {
		this.wallet = wallet;
	}

	public boolean getAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
