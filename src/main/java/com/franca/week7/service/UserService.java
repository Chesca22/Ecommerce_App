package com.franca.week7.service;

import com.franca.week7.dto.LoginDTO;
import com.franca.week7.dto.SignUpDTO;
import com.franca.week7.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.ModelAndView;

public interface UserService extends UserDetailsService {
    User createUser(SignUpDTO dto);

    ModelAndView userLogin(LoginDTO dto);
 //dependency injection means passing objects that are needed to a class into a class

}
