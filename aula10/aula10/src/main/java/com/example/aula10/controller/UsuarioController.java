package com.example.aula10.controller;

import com.example.aula10.dto.UsuarioReponseDTO;
import com.example.aula10.dto.UsuarioRequestDTO;
import com.example.aula10.model.UsuarioModel;
import com.example.aula10.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioReponseDTO>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody UsuarioRequestDTO dto){
        UsuarioModel usuario = usuarioService.salvarUsuario(dto);


        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity
                .created(location)
                .body(Map.of("mensagem","Usuario cadastrado com sucesso"));
    }
}
