package com.ok.shp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "products", schema = "public")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	@SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 1, initialValue = 1)
	@Column(name = "product_id")
	private long productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_category")
	private String productCategory;

	@Column(name = "product_price")
	private long productPrice;

	@Column(name = "product_amount")
	private long productAmount;

	@Column(name = "product_description")
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

	public void setProductId(long productId) {
		this.productId = productId;
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

	public long getProductId() {
		return productId;
	}

}
