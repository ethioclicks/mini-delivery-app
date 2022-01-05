package com.samrit.deliveryapp.service;


import com.samrit.deliveryapp.model.User;
import com.samrit.deliveryapp.repository.UserRepository;

import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

   private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User save(User user) {

        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findUserById(Long userId) {
        Optional<User> userOption = userRepository.findById(userId);
        return  userOption.get();
    }

}


