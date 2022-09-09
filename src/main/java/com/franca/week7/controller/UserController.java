package com.franca.week7.controller;

import com.franca.week7.dto.LoginDTO;
import com.franca.week7.dto.SignUpDTO;
import com.franca.week7.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class UserController {

    //user registration
    private final UserService userService;
    private HttpSession session;
    @ModelAttribute("user")
    public SignUpDTO signUpDTO(){
        return new SignUpDTO();
    }
    @GetMapping("/registration")
    public String showRegistrationForm(){
    return "sign-up";
}

   @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") SignUpDTO dto){
    userService.createUser(dto);
        return "redirect:/login";
    }

    // user login
        @GetMapping("/login")
        public String login(){
            //this should return the login template
            return "login";

        }

        @PostMapping({"/login", "/"})
        public ModelAndView home(LoginDTO dto){
         return userService.userLogin(dto);
        }

    @GetMapping("/logout")
    public String logout(){
        session.invalidate();
        return "redirect:login";
    }




}


