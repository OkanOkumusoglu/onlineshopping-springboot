package com.ok.shp.requests;

public class BuyProductRequest {

	private Long userId;
	private Long productId;
	private Long productAmount;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(Long productAmount) {
		this.productAmount = productAmount;
	}

}
