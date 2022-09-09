package com.franca.week7.ServiceImpl;

import com.franca.week7.dto.LoginDTO;
import com.franca.week7.dto.SignUpDTO;
import com.franca.week7.model.Product;
import com.franca.week7.model.User;
import com.franca.week7.repository.UserRepository;
import com.franca.week7.service.ProductService;
import com.franca.week7.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final  UserRepository repository;
  private final ProductService productService;
  private final HttpSession session;

    @Override
    public User createUser(SignUpDTO dto) {
       User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
       return repository.save(user);

    }

    @Override
    public ModelAndView userLogin(LoginDTO dto) {
        if(dto.getEmail().equals("admin@gmail.com") && dto.getPassword().equals("4321")){
            ModelAndView mv = new ModelAndView("adminCRUD");
            List<Product> prod = productService.displayProduct();
            mv.addObject(prod);
        }
        Optional<User> user = repository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if(user.isPresent()){
            session.setAttribute("loginUser", user.get());
            List<Product> prod = productService.displayProduct();
            ModelAndView mv = new ModelAndView("index");
            mv.addObject("productList", prod);
            mv.addObject("user", user);
            return mv;
        }
        else  return new ModelAndView("login");
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
