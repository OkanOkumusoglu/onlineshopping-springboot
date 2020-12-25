package com.ok.shp.dao.api.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import com.ok.shp.dao.api.controllers.methods.ProductControllerMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ok.shp.dao.ProductRepository;
import com.ok.shp.entities.Product;
import com.ok.shp.requests.CreateProductRequest;
import com.ok.shp.requests.DeleteProductRequest;
import com.ok.shp.requests.FindProductByCategoryRequest;
import com.ok.shp.requests.FindProductByNameRequest;
import com.ok.shp.requests.FindProductRequest;
import com.ok.shp.requests.UpdateProductRequest;
import com.ok.shp.responses.CreateProductResponse;
import com.ok.shp.responses.DeleteProductResponse;
import com.ok.shp.responses.FindProductListResponse;
import com.ok.shp.responses.FindProductResponse;
import com.ok.shp.responses.UpdateProductResponse;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository proRepo;


    @GetMapping("/find-categories")
    public ArrayList<String> getFindCategories() {
        return proRepo.findAllProductCategories();
    }

    @PostMapping("/delete")
    public DeleteProductResponse deleteProduct(@RequestBody @Valid DeleteProductRequest request) {
        DeleteProductResponse response = new DeleteProductResponse();
        if (proRepo.existsById(request.getProductId())) {
            Product product = proRepo.findById(request.getProductId()).get();
            proRepo.deleteById(request.getProductId());
            response.setSuccess(true);
            response.setMessage(product.getProductName() + " is deleted!");
        } else {
            response.setMessage("Product doesn't exist!");
            response.setSuccess(false);
        }
        return response;
    }

    @PostMapping("/find")
    public FindProductResponse getProducts(@RequestBody @Valid FindProductRequest request) {
        FindProductResponse response = new FindProductResponse();
        if (proRepo.existsById(request.getProductId())) {
            Product product = proRepo.findById(request.getProductId()).get();
            ProductControllerMethods.findProduct(product, request, response);

        } else {
            response.setSuccess(false);
            response.setMessage("Product doesn't exist!");
        }
        return response;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse create(@RequestBody @Valid CreateProductRequest request) {
        CreateProductResponse response = new CreateProductResponse();

        Product product = new Product();

        ProductControllerMethods.createProduct(product, proRepo, request, response);

        return response;

    }

    @PostMapping("/partial-update")
    public UpdateProductResponse partialProductUpdate(@RequestBody @Valid UpdateProductRequest request) {
        UpdateProductResponse response = new UpdateProductResponse();
        if (proRepo.existsById(request.getProductId())) {
            Product product = proRepo.findById(request.getProductId()).get();
            if (request.getNewProductName() != null) {
                product.setProductName(request.getNewProductName());
            }
            if (request.getNewProductCategory() != null) {
                product.setProductCategory(request.getNewProductCategory());
            }
            if (request.getNewProductPrice() != null) {
                product.setProductPrice(request.getNewProductPrice());
            }
            if (request.getNewProductAmount() != null) {
                product.setProductAmount(request.getNewProductAmount());
            }
            if (request.getNewProductDescription() != null) {
                product.setProductDescription(request.getNewProductDescription());
            }
            proRepo.save(product);
            response.setSuccess(true);
            response.setMessage("Updated!");
        } else {
            response.setSuccess(false);
            response.setMessage("Product id doesn't exist!");
        }
        return response;
    }

    @PostMapping("/find-by-name")
    public FindProductListResponse findByProductName(@RequestBody @Valid FindProductByNameRequest request) {
        FindProductListResponse response = new FindProductListResponse();
        ArrayList<Product> products = proRepo.findByProductName(request.getProductName());
        response.setProducts(products);
        return response;

    }

    @PostMapping("/find-by-category")
    public FindProductListResponse findByProductCategory(@RequestBody @Valid FindProductByCategoryRequest request) {
        FindProductListResponse response = new FindProductListResponse();
        ArrayList<Product> products = proRepo.findByProductCategory(request.getProductCategory());
        response.setProducts(products);
        return response;
    }

    @GetMapping("list-by-price-desc/{category}")
    public ArrayList<Product> listDescByProductPrice(@PathVariable String productCategory) {
        return proRepo.findByProductCategoryOrderByProductPriceDesc(productCategory);
    }

    @GetMapping("list-by-price-asc/{category}")
    public ArrayList<Product> listAscByProductPrice(@PathVariable String productCategory) {
        return proRepo.findByProductCategoryOrderByProductPriceAsc(productCategory);
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public UpdateProductResponse updateProduct(@RequestBody @Valid UpdateProductRequest request) {
        UpdateProductResponse response = new UpdateProductResponse();
        if (proRepo.existsById(request.getProductId())) {
            Product product = proRepo.findById(request.getProductId()).get();

            ProductControllerMethods.updateProduct(product, proRepo, request, response);
        } else {
            response.setSuccess(false);
            response.setMessage("Product doesn't exist!");
        }
        return response;

    }


}
