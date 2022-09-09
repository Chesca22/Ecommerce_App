package com.franca.week7.dto;

import com.franca.week7.model.Cart;
import com.franca.week7.model.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@RequiredArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String productName;
    private String productCategory;
    private String productPrice;
    private String productDescription;




}
