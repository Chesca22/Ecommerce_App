package com.franca.week7.ServiceImpl;

import com.franca.week7.dto.ProductDTO;
import com.franca.week7.model.Product;
import com.franca.week7.repository.ProductRepository;
import com.franca.week7.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    @Override
    public Product addProduct(ProductDTO dto){
        Product product = new Product();
        product.setProductName(dto.getProductName());
        product.setProductCategory(dto.getProductCategory());
        product.setProductDescription(dto.getProductDescription());
        product.setProductPrice(dto.getProductPrice());
        return productRepository.save(product);
    }


    @Override
   public void updateProduct(ProductDTO dto, Long id){
        Optional<Product> prod = productRepository.findById(id);
        if(prod.isPresent()){
            Product product = prod.get();
            product.setProductName(dto.getProductName());
            product.setProductCategory(dto.getProductCategory());
            product.setProductCategory(dto.getProductCategory());
            product.setProductPrice(dto.getProductPrice());
             productRepository.save(product);}

            else {
                System.out.println("product not found");
            }
    }


    @Override
   public List<Product> findAllProduct(){
        return productRepository.findAll();
    }

    @Override
    public List<Product> displayProduct(){
        return productRepository.findAll();
    }


    @Override
    public void deleteProduct(Long id){
        Optional<Product> prod = productRepository.findById(id);
        if(prod.isPresent()){
            Product product = prod.get();
            productRepository.delete(product);
        }
        else {
            System.out.println("product not found");
        }

    }



}
