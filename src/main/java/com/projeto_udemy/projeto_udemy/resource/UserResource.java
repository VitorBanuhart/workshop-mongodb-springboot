package com.projeto_udemy.projeto_udemy.resource;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto_udemy.projeto_udemy.domain.User;
import com.projeto_udemy.projeto_udemy.dto.UserDTO;
import com.projeto_udemy.projeto_udemy.services.UserServices;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserServices repo; 

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = repo.findAll();
        List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
}

