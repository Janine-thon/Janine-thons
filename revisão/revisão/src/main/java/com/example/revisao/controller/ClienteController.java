package com.example.revisao.controller;

import com.example.revisao.model.ClienteModel;
import com.example.revisao.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // GET /clientes
    @GetMapping
    public List<ClienteModel> listarClientes() {
        return clienteService.listarClientes();
    }

    // POST /clientes
    @PostMapping
    public ResponseEntity<Map<String, Object>> salvarCliente(@RequestBody ClienteModel clienteModel) {
        try {
            clienteService.salvar(clienteModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Map.of("mensagem", "Cliente cadastrado com sucesso!")
            );
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    Map.of("erro", e.getMessage())
            );
        }
    }

    // PUT /clientes/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizarCliente(@PathVariable UUID id, @RequestBody ClienteModel clienteModel) {
        try {
            clienteService.atualizar(id, clienteModel);
            return ResponseEntity.status(HttpStatus.OK).body(
                    Map.of("mensagem", "Cliente atualizado com sucesso!")
            );
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    Map.of("erro", e.getMessage())
            );
        }
    }

    // DELETE /clientes/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletarCliente(@PathVariable UUID id) {
        try {
            clienteService.deletar(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    Map.of("mensagem", "Cliente excluído com sucesso!")
            );
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    Map.of("erro", e.getMessage())
            );
        }
    }
}
