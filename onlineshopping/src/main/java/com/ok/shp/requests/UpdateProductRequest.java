package com.ok.shp.requests;

public class UpdateProductRequest {

	private long productId;
	private String newProductName;
	private String newProductCategory;
	private Long newProductPrice;
	private Long newProductAmount;
	private String newProductDescription;
	
	public long getProductId() {
		return productId;
	}

	public String getNewProductName() {
		return newProductName;
	}

	public void setNewProductName(String newProductName) {
		this.newProductName = newProductName;
	}

	public String getNewProductCategory() {
		return newProductCategory;
	}

	public void setNewProductCategory(String newProductCategory) {
		this.newProductCategory = newProductCategory;
	}

	public Long getNewProductPrice() {
		return newProductPrice;
	}


	public Long getNewProductAmount() {
		return newProductAmount;
	}

	public void setNewProductAmount(long newProductAmount) {
		this.newProductAmount = newProductAmount;
	}

	public String getNewProductDescription() {
		return newProductDescription;
	}

	public void setNewProductDescription(String newProductDescription) {
		this.newProductDescription = newProductDescription;
	}

	public void setNewProductPrice(Long newProductPrice) {
		this.newProductPrice = newProductPrice;
	}

	public void setNewProductAmount(Long newProductAmount) {
		this.newProductAmount = newProductAmount;
	}

}
