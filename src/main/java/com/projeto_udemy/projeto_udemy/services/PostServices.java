package com.projeto_udemy.projeto_udemy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_udemy.projeto_udemy.domain.Post;
import com.projeto_udemy.projeto_udemy.repository.PostRepository;
import com.projeto_udemy.projeto_udemy.services.exception.ObjectNotFoundException;

@Service
public class PostServices {
    
    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
