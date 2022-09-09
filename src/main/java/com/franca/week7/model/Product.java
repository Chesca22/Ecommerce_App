package com.franca.week7.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String productName;;
    @NotBlank
    private String productCategory;
    @NotBlank
    private String productPrice;
    private String productDescription;



}
