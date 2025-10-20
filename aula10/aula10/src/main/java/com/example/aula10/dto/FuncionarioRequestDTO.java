package com.example.aula10.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FuncionarioRequestDTO {
    @NotBlank(message = "O nome é obrigatório. ")
    @Size(min = 3, message = "O nome deve ter no minimo 3 caracteres. ")
    @Size(max = 200, message = "O nome não deve ter mais de 200 caracteres. ")
    private String nome;

    @NotBlank(message = "O e-mail é obrigatório. ")
    @Size(min = 3, message = "Deve ser um e-mail válido. ")
    @Size(max = 200, message = "O e-mail não deve ter mais de 200 caracteres. ")
    private String email;

    @NotBlank(message = "A senha é obrigatório. ")
    @Size(min = 3, message = "A senha deve ter no minimo 3 caracteres.  ")
    @Size(max = 200, message = "A senha não deve ter mais de 200 caracteres. ")
    private String senha;

    public FuncionarioRequestDTO() {
    }

    public FuncionarioRequestDTO(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public @NotBlank(message = "O nome é obrigatório. ") @Size(min = 3, message = "O nome deve ter no minimo 3 caracteres. ") @Size(max = 200, message = "O nome não deve ter mais de 200 caracteres. ") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatório. ") @Size(min = 3, message = "O nome deve ter no minimo 3 caracteres. ") @Size(max = 200, message = "O nome não deve ter mais de 200 caracteres. ") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O e-mail é obrigatório. ") @Size(min = 3, message = "Deve ser um e-mail válido. ") @Size(max = 200, message = "O e-mail não deve ter mais de 200 caracteres. ") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O e-mail é obrigatório. ") @Size(min = 3, message = "Deve ser um e-mail válido. ") @Size(max = 200, message = "O e-mail não deve ter mais de 200 caracteres. ") String email) {
        this.email = email;
    }

    public @NotBlank(message = "A senha é obrigatório. ") @Size(min = 3, message = "A senha deve ter no minimo 3 caracteres.  ") @Size(max = 200, message = "A senha não deve ter mais de 200 caracteres. ") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "A senha é obrigatório. ") @Size(min = 3, message = "A senha deve ter no minimo 3 caracteres.  ") @Size(max = 200, message = "A senha não deve ter mais de 200 caracteres. ") String senha) {
        this.senha = senha;
    }
}
