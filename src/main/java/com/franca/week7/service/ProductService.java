package com.franca.week7.service;

import com.franca.week7.dto.ProductDTO;
import com.franca.week7.model.Product;

import java.util.List;



public interface ProductService {
    Product addProduct(ProductDTO dto);
    void updateProduct(ProductDTO dto, Long id);

    List<Product> findAllProduct();

    void deleteProduct(Long id);


    List<Product> displayProduct();




}
