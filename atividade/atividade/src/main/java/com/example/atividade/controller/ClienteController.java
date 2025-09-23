package com.example.atividade.controller;

import com.example.atividade.model.Cliente;
import com.example.atividade.repository.ClienteRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteRepositoy clienteRepositoy;



    @GetMapping
    public List<Cliente> listarTodos(){
        return clienteRepositoy.findAll();
    }

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente){
        clienteRepositoy.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }
}
