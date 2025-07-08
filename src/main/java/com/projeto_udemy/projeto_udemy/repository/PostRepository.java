package com.projeto_udemy.projeto_udemy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projeto_udemy.projeto_udemy.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
}
