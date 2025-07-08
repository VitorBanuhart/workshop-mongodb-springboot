package com.projeto_udemy.projeto_udemy.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto_udemy.projeto_udemy.domain.Post;
import com.projeto_udemy.projeto_udemy.services.PostServices;

@RestController
@RequestMapping(value = "/post")
public class PostResource {

    @Autowired 
    private PostServices postServices;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById (@PathVariable String id) {
        Post obj = postServices.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    
}
