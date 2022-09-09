package com.franca.week7.controller;

import com.franca.week7.dto.ProductDTO;
import com.franca.week7.model.Product;
import com.franca.week7.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final ProductService productService;

    @GetMapping("/add_product")
    public String addProductPage(Model model){
        return "addProduct";
    }

    @PostMapping("/add_product")
    public String addingProduct(@ModelAttribute ProductDTO productDTO){
      Product product= productService.addProduct(productDTO);
        if(Objects.nonNull(product)) {
            return "redirect:/adminCRUD";
        } else {
            return "redirect:/addProduct";
        }


    }




}
