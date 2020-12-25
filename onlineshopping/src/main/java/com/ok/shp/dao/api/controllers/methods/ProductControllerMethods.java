package com.ok.shp.dao.api.controllers.methods;

import com.ok.shp.dao.ProductRepository;
import com.ok.shp.entities.Product;
import com.ok.shp.requests.CreateProductRequest;
import com.ok.shp.requests.FindProductRequest;
import com.ok.shp.requests.UpdateProductRequest;
import com.ok.shp.responses.CreateProductResponse;
import com.ok.shp.responses.FindProductResponse;
import com.ok.shp.responses.UpdateProductResponse;

public class ProductControllerMethods {

    public static void findProduct(Product product, FindProductRequest request, FindProductResponse response) {
        response.setProductName(product.getProductName());
        response.setProductCategory(product.getProductCategory());
        response.setProductPrice(product.getProductPrice());
        response.setProductAmount(product.getProductAmount());
        response.setProductDescription(product.getProductDescription());
        response.setSuccess(true);
        response.setMessage("Successful!");
    }

    public static void updateProduct(Product product, ProductRepository proRepo, UpdateProductRequest request, UpdateProductResponse response) {
        product.setProductName(request.getNewProductName());
        product.setProductCategory(request.getNewProductCategory());
        product.setProductPrice(request.getNewProductPrice());
        product.setProductAmount(request.getNewProductAmount());
        product.setProductDescription(request.getNewProductDescription());
        proRepo.save(product);
        response.setSuccess(true);
        response.setMessage("Updated!");
    }

    public static void createProduct(Product product, ProductRepository proRepo, CreateProductRequest request, CreateProductResponse response) {
        product.setProductName(request.getProductName());
        product.setProductCategory(request.getProductCategory());
        product.setProductPrice(request.getProductPrice());
        product.setProductAmount(request.getProductAmount());
        product.setProductDescription(request.getProductDescription());
        proRepo.save(product);
        response.setMessage("Successful!");
        response.setSuccess(true);
    }
}
