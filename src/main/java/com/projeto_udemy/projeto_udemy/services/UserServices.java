package com.projeto_udemy.projeto_udemy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_udemy.projeto_udemy.domain.User;
import com.projeto_udemy.projeto_udemy.repository.UserRepository;

@Service
public class UserServices {
    
    @Autowired
    private UserRepository userRepository; 

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
