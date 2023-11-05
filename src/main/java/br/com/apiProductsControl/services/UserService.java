package br.com.apiProductsControl.services;

import br.com.apiProductsControl.dtos.UserPostDTO;
import br.com.apiProductsControl.models.User;
import br.com.apiProductsControl.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void save(User user){
        this.userRepository.save(user);
    }

    public User createUser(UserPostDTO dto) {
        User user = new User(dto);
        this.save(user);
        return user;
    }

    public User authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user != null) {
            if (password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }
}
