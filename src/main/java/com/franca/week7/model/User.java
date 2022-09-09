package com.franca.week7.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "field must not be blank")
    private String firstName;
    @NotBlank(message = "field must not be blank")
    private String lastName;
    @Column(unique = true)
    @NotBlank(message = "email is required")
    private String email;
    @NotBlank(message = "password is required")
    private String password;




}
