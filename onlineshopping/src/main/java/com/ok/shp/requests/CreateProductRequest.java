package com.ok.shp.requests;

public class CreateProductRequest {

	private String productName;
	private String productCategory;
	private long productPrice;
	private long productAmount;
	private String productDescription;

	public long getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(long productAmount) {
		this.productAmount = productAmount;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}

}
