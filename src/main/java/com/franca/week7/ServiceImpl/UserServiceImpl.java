package com.franca.week7.ServiceImpl;

import com.franca.week7.dto.LoginDTO;
import com.franca.week7.dto.SignUpDTO;
import com.franca.week7.model.User;
import com.franca.week7.repository.UserRepository;
import com.franca.week7.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final  UserRepository repository;
    @Override
    public User createUser(SignUpDTO dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
       return repository.save(user);




    }

    public void loginUser(LoginDTO dto){
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        repository.save(user);
    }
}
