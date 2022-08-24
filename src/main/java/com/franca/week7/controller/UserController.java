package com.franca.week7.controller;

import com.franca.week7.dto.LoginDTO;
import com.franca.week7.dto.SignUpDTO;
import com.franca.week7.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/registration")
public class UserController {


    private final UserService userService;
    @GetMapping
    public String showRegistrationForm(){
    return "registration";
}

   @PostMapping
    public String registerUserAccount(@ModelAttribute("user") SignUpDTO dto){
    userService.createUser(dto);
        return "redirect:/registration?success";
    }






    }


