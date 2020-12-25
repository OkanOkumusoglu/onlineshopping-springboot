package com.ok.shp.requests;

public class AddMoneyRequest {
	
	private Long userId;
	private Long amount;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}
	

}
