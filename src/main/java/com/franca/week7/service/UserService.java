package com.franca.week7.service;

import com.franca.week7.dto.LoginDTO;
import com.franca.week7.dto.SignUpDTO;
import com.franca.week7.model.User;

public interface UserService {
    User createUser(SignUpDTO dto);

    void loginUser(LoginDTO dto);
    //dependency injection means passing objects that are needed to a class into a class

}
