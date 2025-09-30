package com.example.teste.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.teste.model.ClienteModel;
import com.example.teste.service.ClienteService;

@RestController
@RequestMapping("/alunos")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteModel> listar(){
        return clienteService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<ClienteModel> salvar(@RequestBody ClienteModel clienteModel){
        clienteService.salvar(clienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> atualizar(@PathVariable UUID ID,ClienteModel clienteModel){
        clienteService.atualizar(ID, clienteModel);
        return ResponseEntity.status(HttpStatus.OK).body(clienteModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable UUID ID){
        clienteService.excluir(ID);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
