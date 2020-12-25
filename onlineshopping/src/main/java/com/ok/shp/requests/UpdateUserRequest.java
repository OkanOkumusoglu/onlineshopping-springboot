package com.ok.shp.requests;

public class UpdateUserRequest {

	private long userId;
	private String newFirstName;
	private String newLastName;
	private String newEmail;
	private Long newPhoneNumber;
	private String newHomeAddress;

	public long getUserId() {
		return userId;
	}

	public String getNewFirstName() {
		return newFirstName;
	}

	public void setNewFirstName(String newFirstName) {
		this.newFirstName = newFirstName;
	}

	public String getNewLastName() {
		return newLastName;
	}

	public void setNewLastName(String newLastName) {
		this.newLastName = newLastName;
	}

	public String getNewEmail() {
		return newEmail;
	}

	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}

	public Long getNewPhoneNumber() {
		return newPhoneNumber;
	}

	public void setNewPhoneNumber(Long newPhoneNumber) {
		this.newPhoneNumber = newPhoneNumber;
	}

	public String getNewHomeAddress() {
		return newHomeAddress;
	}

	public void setNewHomeAddress(String newHomeAddress) {
		this.newHomeAddress = newHomeAddress;
	}
}
