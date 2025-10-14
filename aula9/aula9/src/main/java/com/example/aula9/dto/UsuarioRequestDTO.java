package com.example.aula9.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
public class UsuarioRequestDTO {
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O E-mail é obrigatório")
    @Email(message = "Deve ser um e-mail válido")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 5,max = 20,message = "A senha deve ter entre 5 e 20 caracteres")
    private String senha;

    public UsuarioRequestDTO() {
    }

    public UsuarioRequestDTO(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public @NotBlank(message = "O nome é obrigatório") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatório") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O E-mail é obrigatório") @Email(message = "Deve ser um e-mail válido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O E-mail é obrigatório") @Email(message = "Deve ser um e-mail válido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "A senha é obrigatória") @Size(min = 5, max = 20, message = "A senha deve ter entre 5 e 20 caracteres") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "A senha é obrigatória") @Size(min = 5, max = 20, message = "A senha deve ter entre 5 e 20 caracteres") String senha) {
        this.senha = senha;
    }
}
