package com.projeto_udemy.projeto_udemy.config;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.projeto_udemy.projeto_udemy.domain.Post;
import com.projeto_udemy.projeto_udemy.domain.User;
import com.projeto_udemy.projeto_udemy.dto.AuthorDTO;
import com.projeto_udemy.projeto_udemy.repository.PostRepository;
import com.projeto_udemy.projeto_udemy.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

    @Autowired
    private UserRepository repo;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
    
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        repo.deleteAll();
        postRepository.deleteAll();


        User jackie = new User(null, "Jackie Brown", "jackie@gmail.com");
        User alex = new User(null, "Alex Blue", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        
        repo.saveAll(List.of(jackie,bob,alex));        

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Viagem para SP", new AuthorDTO(alex));

        Post post2 = new Post(null, sdf.parse("28/03/2018"), "voltei de viagem", "n ext amr em sp", new AuthorDTO(alex));
        postRepository.saveAll(List.of(post1, post2));
    
        alex.getPosts().addAll(List.of(post1, post2));
        repo.save(alex);
    }
    
}
