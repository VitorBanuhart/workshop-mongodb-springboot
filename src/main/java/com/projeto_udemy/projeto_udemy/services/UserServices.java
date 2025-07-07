package com.projeto_udemy.projeto_udemy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_udemy.projeto_udemy.domain.User;
import com.projeto_udemy.projeto_udemy.repository.UserRepository;
import com.projeto_udemy.projeto_udemy.services.exception.ObjectNotFoundException;

@Service
public class UserServices {
    
    @Autowired
    private UserRepository userRepository; 

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
