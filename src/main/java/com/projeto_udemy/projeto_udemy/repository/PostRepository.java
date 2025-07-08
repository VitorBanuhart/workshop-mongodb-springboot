package com.projeto_udemy.projeto_udemy.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.projeto_udemy.projeto_udemy.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{


    @Query("{ 'title' : {$regex: ?0, $options: 'i' }}")
    List<Post> findByTitle(String title);

    List<Post> findByTitleContainingIgnoreCase(String title);
}
