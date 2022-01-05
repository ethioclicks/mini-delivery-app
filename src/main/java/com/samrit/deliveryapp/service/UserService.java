package com.samrit.deliveryapp.service;


import com.samrit.deliveryapp.model.User;

import java.util.Optional;

public interface UserService {
    User save(User user);

    User findByEmail(String email);

    User findUserById(Long userId);

   // Optional<User> findById(Long userId);
}