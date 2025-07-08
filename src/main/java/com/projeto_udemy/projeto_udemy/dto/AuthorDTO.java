package com.projeto_udemy.projeto_udemy.dto;

import java.io.Serializable;

import com.projeto_udemy.projeto_udemy.domain.User;

public class AuthorDTO implements Serializable{
    
    private String id;
    private String name;

    public AuthorDTO() {}

    public AuthorDTO(User obj) {
        id = obj.getId();
        name = obj.getnome();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
}
