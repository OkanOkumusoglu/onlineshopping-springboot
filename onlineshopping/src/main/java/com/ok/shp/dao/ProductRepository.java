package com.ok.shp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ok.shp.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {


    @Override
    List<Product> findAll();

    @Query("{ 'productCategory' : { $regex: '?0', $options: 'i'} }")
    ArrayList<Product> findByProductCategory(String productCategory);

    @Query("{ 'productName' : { $regex: '?0', $options: 'i'} }")
    ArrayList<Product> findByProductName(String productName);

    @Query(value = "{'productCategory': {$regex : '^?0$', $options: 'i'}}")
    ArrayList<String> findAllProductCategories();

    ArrayList<Product> findByProductCategoryOrderByProductPriceAsc(String productCategory);

    ArrayList<Product> findByProductCategoryOrderByProductPriceDesc(String productCategory);

}
