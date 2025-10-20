package com.example.aula10.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClienteRequestDTO {
    @NotBlank(message = "O nome é obrigatório. ")
    @Size(min = 3, message = "O nome deve ter no minimo 3 caracteres. ")
    @Size(max = 200, message = "O nome não deve ter mais de 200 caracteres. ")
    private String nome;

    @NotBlank(message = "O e-mail é obrigatório. ")
    @Size(min = 3, message = "Deve ser um e-mail válido. ")
    @Size(max = 200, message = "O e-mail não deve ter mais de 200 caracteres. ")
    private String email;
}
