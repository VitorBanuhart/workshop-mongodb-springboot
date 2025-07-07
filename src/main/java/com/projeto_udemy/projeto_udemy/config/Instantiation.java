package com.projeto_udemy.projeto_udemy.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.projeto_udemy.projeto_udemy.domain.User;
import com.projeto_udemy.projeto_udemy.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

    @Autowired
    private UserRepository repo;

    @Override
    public void run(String... args) throws Exception {
        
        repo.deleteAll();

        User jackie = new User(null, "Jackie Brown", "jackie@gmail.com");
        User alex = new User(null, "Alex Blue", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        
        repo.saveAll(List.of(jackie,bob,alex));
    }
    
}
