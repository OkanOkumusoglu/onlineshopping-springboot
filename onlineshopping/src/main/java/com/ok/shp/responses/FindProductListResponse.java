package com.ok.shp.responses;

import java.util.List;

import com.ok.shp.entities.Product;


public class FindProductListResponse {
	
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}


	

}
