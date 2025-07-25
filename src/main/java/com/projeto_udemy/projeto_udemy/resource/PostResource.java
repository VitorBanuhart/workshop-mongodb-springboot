package com.projeto_udemy.projeto_udemy.resource;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projeto_udemy.projeto_udemy.domain.Post;
import com.projeto_udemy.projeto_udemy.services.PostServices;
import com.projeto_udemy.projeto_udemy.util.URL;

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

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle (@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = postServices.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }    

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch (
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(minDate, new Date());
        List<Post> list = postServices.fullSearch(text, min, max);
        return ResponseEntity.ok().body(list);
    }
}
