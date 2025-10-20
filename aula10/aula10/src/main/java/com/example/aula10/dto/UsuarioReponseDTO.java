package com.example.aula10.dto;


public class UsuarioReponseDTO {
    private String nome;
    private String email;

    public UsuarioReponseDTO() {
    }

    public UsuarioReponseDTO(String nome, String email) {
        this.nome = nome;
        this.email = email;
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
