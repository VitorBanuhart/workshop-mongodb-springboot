package com.projeto_udemy.projeto_udemy.dto;

import java.io.Serializable;

import com.projeto_udemy.projeto_udemy.domain.User;

public class UserDTO implements Serializable{
    
    private String id;
    private String nome;
    private String email;
    
    public UserDTO() {
    }

    public UserDTO(User obj) {
        this.id = obj.getId();
        this.nome = obj.getnome();
        this.email = obj.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
